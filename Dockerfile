FROM openjdk:17-alpine

WORKDIR /app

COPY ./2024-msg-server.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
