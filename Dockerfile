FROM openjdk:11-jdk-slim
COPY target/my-app.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
