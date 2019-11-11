FROM openjdk:8-jdk-alpine
EXPOSE 8004
COPY target/inventory.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]