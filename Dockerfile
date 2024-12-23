# Use the official OpenJDK image as a base
FROM openjdk:21-slim

# Set the working directory in the container
WORKDIR /app

# Install dependencies and Google Chrome
RUN apt-get update && \
    apt-get install -y wget gnupg2 && \
    wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - && \
    echo "deb [arch=amd64] https://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list && \
    apt-get update && \
    apt-get install -y google-chrome-stable && \
    apt-get install -y unzip && \
    rm -rf /var/lib/apt/lists/*

    # Install the correct version of Chromedriver that matches the installed Google Chrome version
RUN CHROME_VERSION=$(google-chrome --version | grep -oP '\d+\.\d+\.\d+') && \
    echo "Detected Chrome version: $CHROME_VERSION" && \
    CHROMEDRIVER_VERSION=$(curl -sS chromedriver.storage.googleapis.com/LATEST_RELEASE_$CHROME_VERSION) && \
    echo "Detected Chromedriver version: $CHROMEDRIVER_VERSION" && \
    curl -sSL "https://chromedriver.storage.googleapis.com/${CHROMEDRIVER_VERSION}/chromedriver_linux64.zip" -o chromedriver.zip && \
    unzip chromedriver.zip -d /usr/bin/ && \
    chmod +x /usr/bin/chromedriver && \
    rm chromedriver.zip

# Download and install Gradle
RUN wget https://services.gradle.org/distributions/gradle-8.3-bin.zip && \
    unzip gradle-8.3-bin.zip && \
    mv gradle-8.3 /opt/gradle && \
    ln -s /opt/gradle/bin/gradle /usr/bin/gradle && \
    rm gradle-8.3-bin.zip

# Copy your application code
COPY . ./

# Ensure gradlew is executable
RUN chmod +x gradlew
RUN ls -R /app
# Build the application
RUN ./gradlew build --no-daemon

# List the contents of build directory for debugging
#RUN ls -R build/

# Specify the command to run your Java application
CMD ["./gradlew", "build"]