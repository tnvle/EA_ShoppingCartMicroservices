FROM openjdk:8-jdk-alpine
EXPOSE 8008
COPY shipping.jar app.jar
ENTRYPOINT ENTRYPOINT ["java","-jar","/app.jar"]