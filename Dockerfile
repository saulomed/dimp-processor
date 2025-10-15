FROM openjdk:11

WORKDIR /app

COPY target/dimp-processor-1.0.0.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
