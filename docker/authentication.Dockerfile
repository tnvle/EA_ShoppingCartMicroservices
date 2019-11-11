FROM openjdk:8-jdk-alpine
EXPOSE 8888
COPY target/authentication.jar app.jar
ENTRYPOINT ENTRYPOINT ["java","-jar","/app.jar"]