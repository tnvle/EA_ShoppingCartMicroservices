FROM openjdk:8-jdk-alpine
EXPOSE 8885
COPY target/payment.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]