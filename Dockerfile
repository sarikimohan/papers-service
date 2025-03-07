# Use official Maven image to build the project
FROM maven:3.8.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Use a lightweight Java image to run the application
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
# Expose the application port (Render uses PORT dynamically)
EXPOSE 10000

# Run the application and pass environment variables (for secrets)
CMD ["sh", "-c", "java -jar app.jar --server.port=${PORT:-10000}"]