FROM openjdk:8-jdk-alpine
EXPOSE 8005
COPY target/order.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]