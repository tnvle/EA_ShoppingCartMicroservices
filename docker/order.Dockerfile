FROM openjdk:8-jdk-alpine
EXPOSE 8005
COPY target/order.jar app.jar
ENTRYPOINT ENTRYPOINT ["java","-jar","/app.jar"]