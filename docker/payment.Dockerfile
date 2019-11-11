FROM openjdk:8-jdk-alpine
EXPOSE 8006
COPY target/payment.jar app.jar
ENTRYPOINT ENTRYPOINT ["java","-jar","/app.jar"]