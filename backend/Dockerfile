FROM openjdk:17-jdk-slim
COPY target/credit-0.1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["sh","-c","java -jar /app.jar"]
