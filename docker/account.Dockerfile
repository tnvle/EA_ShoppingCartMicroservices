FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY account.jar app.jar
ENTRYPOINT ENTRYPOINT ["java","-jar","/app.jar"]