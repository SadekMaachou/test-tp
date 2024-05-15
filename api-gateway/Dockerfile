# Use a base image with Java and Alpine Linux
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/my-microservice.jar /app/my-microservice.jar

# Expose the port that the microservice will listen on
EXPOSE 8080

# Define the command to run the microservice when the container starts
CMD ["java", "-jar", "my-microservice.jar"]
