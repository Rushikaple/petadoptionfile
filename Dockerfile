# Use the base image as JDK 11
FROM openjdk:11

# Create an Directory App
RUN mkdir /app

# Copy contents of target directory into app
COPY target/ /app

# Set the Working Directory as app
WORKDIR /app

# Execute the jar file which will run the project on port 9090
CMD java -jar eStoreBackend-0.0.1-SNAPSHOT.jar --spring.config.location=application.properties