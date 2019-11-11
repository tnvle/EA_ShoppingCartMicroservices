FROM openjdk:8-jdk-alpine
EXPOSE 8002
COPY target/catalogue.jar app.jar
ENTRYPOINT ENTRYPOINT ["java","-jar","/app.jar"]