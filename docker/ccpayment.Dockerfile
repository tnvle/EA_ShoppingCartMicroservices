FROM openjdk:8-jdk-alpine
EXPOSE 8003
COPY creditcardpayment.jar app.jar
ENTRYPOINT ENTRYPOINT ["java","-jar","/app.jar"]