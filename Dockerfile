# Use an official Eclipse Temurin runtime as a parent image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the source code into the container
COPY . /app

# Install Maven
RUN apk --no-cache add maven

# Build the Java application using Maven
RUN mvn clean install
# Expose the SSL port
EXPOSE 8443
# Define the command to run your application with SSL
CMD ["java", "-jar", "/app/cdms.jar", "--spring.profiles.active=docker", "--spring.main.allow-bean-definition-overriding=true"]
