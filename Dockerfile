# Use the official OpenJDK image as a base
FROM openjdk:21-slim

# Set the working directory in the container
WORKDIR /app

# Install wget and unzip
RUN apt-get update && \
    apt-get install -y wget unzip && \
    rm -rf /var/lib/apt/lists/*

# Download and install Gradle
RUN wget https://services.gradle.org/distributions/gradle-8.3-bin.zip && \
    unzip gradle-8.3-bin.zip && \
    mv gradle-8.3 /opt/gradle && \
    ln -s /opt/gradle/bin/gradle /usr/bin/gradle && \
    rm gradle-8.3-bin.zip

# Copy your application code and the gradlew file
COPY . ./
COPY build/libs/*.jar /app/app.jar
#COPY build/dependency/* /app/lib/

# Ensure gradlew is executable
RUN chmod +x gradlew

# Build the application
RUN ./gradlew build --no-daemon

# List the contents of build directory for debugging
RUN ls -R build/

# Copy the built jar and dependencies if they exist
RUN if [ -f build/libs/*.jar ]; then cp build/libs/*.jar /app/app.jar; fi
RUN if [ -d build/dependency ]; then cp -r build/dependency/* /app/lib/; fi

# Specify the command to run your Java application
CMD ["java", "-cp", "build/libs/DemoSiteTechlistic-1.0-SNAPSHOT.jar", "TechlisticClassPackage.TechlisticBaseClass"]
