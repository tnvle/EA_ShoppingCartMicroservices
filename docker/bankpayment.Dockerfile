FROM openjdk:8-jdk-alpine
EXPOSE 8001
COPY target/bankpayment.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]