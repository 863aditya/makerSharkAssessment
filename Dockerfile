# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Add the Spring Boot application jar to the container
COPY target/makershark-0.0.1-SNAPSHOT.jar /usr/local/lib/myapp.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/usr/local/lib/myapp.jar"]
