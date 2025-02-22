# Use a lightweight OpenJDK 17 image
FROM openjdk:17-jdk-slim

LABEL maintainer="rajanm.apps@gmail.com"

# Set the working directory inside the container
WORKDIR /app

# The application's jar file
ARG JAR_FILE=build/libs/myspringboot-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

# Expose the application port (change if needed)
EXPOSE 8090

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]