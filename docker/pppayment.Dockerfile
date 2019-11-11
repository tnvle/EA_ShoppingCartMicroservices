FROM openjdk:8-jdk-alpine
EXPOSE 8007
COPY target/paypalpayment.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]