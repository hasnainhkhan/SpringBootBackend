# Use Eclipse Temurin JDK 21 instead of 20
FROM eclipse-temurin:21

# Expose application port
EXPOSE 8080

# Copy JAR file into the container
ADD target/Smart-contact-docker.jar Smart-contact-docker.jar

# Set the entrypoint
ENTRYPOINT [ "java", "-jar", "/Smart-contact-docker.jar" ]


