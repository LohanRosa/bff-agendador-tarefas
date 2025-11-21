FROM maven:3.8.8-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .

RUN mvn clean install -DskipTests
FROM azul/zulu-openjdk:21.0.8-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8083
CMD ["java", "-jar", "/app/bff-agendador-tarefas.jar"]


