FROM openjdk:8-jdk-alpine
EXPOSE 8003
COPY target/creditcardpayment.jar app.jar
ENTRYPOINT ENTRYPOINT ["java","-jar","/app.jar"]