FROM openjdk:8-jdk-alpine
EXPOSE 8006
COPY payment.jar app.jar
ENTRYPOINT ENTRYPOINT ["java","-jar","/app.jar"]