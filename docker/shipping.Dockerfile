FROM openjdk:8-jdk-alpine
EXPOSE 8008
COPY target/shipping.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]