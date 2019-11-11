FROM openjdk:8-jdk-alpine
EXPOSE 8003
COPY target/creditcardpayment.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]