FROM mcr.microsoft.com/devcontainers/java:21

# Install necessary tools
RUN apt-get update && apt-get install -y wget unzip && apt-get clean

# Download and set up JavaFX
RUN wget --quiet https://download2.gluonhq.com/openjfx/23.0.1/openjfx-23.0.1_linux-aarch64_bin-sdk.zip \
    && unzip openjfx-23.0.1_linux-aarch64_bin-sdk.zip -d /usr/local \
    && rm openjfx-23.0.1_linux-aarch64_bin-sdk.zip

# Set working directory
WORKDIR /app

# Compile the application
RUN mkdir -p bin \
    && javac --module-path /usr/local/javafx-sdk-23.0.1/lib --add-modules javafx.controls,javafx.fxml -d bin src/App.java

# Run the application
CMD ["java", "--module-path", "/usr/local/javafx-sdk-23.0.1/lib", "--add-modules", "javafx.controls,javafx.fxml", "-cp", "bin", "App"]
