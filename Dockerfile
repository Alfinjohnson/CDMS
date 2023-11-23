# Use an official Eclipse Temurin runtime as a parent image
FROM eclipse-temurin:17-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container
COPY target/cdms-0.0.1.jar /app/cdms.jar

# Copy your SSL certificate and private key into the container
COPY  data/ssl/keystore.p12 /app/ssl/keystore.p12

# Expose the SSL port
EXPOSE 8443
ENV SSL_KEYSTORE_PASSWORD=rootcdms
ENV SPRING_PROFILE=docker
# Define the command to run your application with SSL
CMD ["java", "-jar", "/app/cdms.jar", "--spring.profiles.active=${SPRING_PROFILE}", "--server.ssl.key-store=/app/ssl/keystore.p12", "--server.ssl.key-store-type=PKCS12", "--server.ssl.key-store-password=${SSL_KEYSTORE_PASSWORD}", "--server.ssl.key-alias=cdms","--management.datadog.metrics.export.api-key=your-datadog-key","--spring.main.allow-bean-definition-overriding=true"]