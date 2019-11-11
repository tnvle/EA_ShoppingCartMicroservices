FROM openjdk:8-jdk-alpine
EXPOSE 8007
COPY paypalpayment.jar app.jar
ENTRYPOINT ENTRYPOINT ["java","-jar","/app.jar"]