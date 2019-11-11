FROM openjdk:8-jdk-alpine
EXPOSE 8001
COPY target/bankpayment.jar app.jar
ENTRYPOINT ENTRYPOINT ["java","-jar","/app.jar"]