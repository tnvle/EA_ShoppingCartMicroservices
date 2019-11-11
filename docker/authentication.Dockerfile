FROM openjdk:8-jdk-alpine
EXPOSE 8888
COPY authentication.jar app.jar
ENTRYPOINT ENTRYPOINT ["java","-jar","/app.jar"]