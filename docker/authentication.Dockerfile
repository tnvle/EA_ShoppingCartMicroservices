FROM openjdk:8-jdk-alpine
EXPOSE 8888
COPY target/authentication.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]