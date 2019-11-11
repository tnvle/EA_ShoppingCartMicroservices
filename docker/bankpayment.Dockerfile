FROM openjdk:8-jdk-alpine
EXPOSE 8001
COPY bankpayment.jar app.jar
ENTRYPOINT ENTRYPOINT ["java","-jar","/app.jar"]