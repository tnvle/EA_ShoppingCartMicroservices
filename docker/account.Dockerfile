FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY target/account.jar app.jar
ENTRYPOINT ENTRYPOINT ["java","-jar","/app.jar"]