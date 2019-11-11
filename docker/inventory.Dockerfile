FROM openjdk:8-jdk-alpine
EXPOSE 8004
COPY target/inventory.jar app.jar
ENTRYPOINT ENTRYPOINT ["java","-jar","/app.jar"]