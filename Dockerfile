FROM mcr.microsoft.com/devcontainers/java:21

# Install required packages
RUN apt update && \
    apt install -y x11-apps libarchive-tools libgtk-3-0 libglib2.0-0 libx11-6 libasound2 libnss3 libxext6 libxrender1 libxtst6 libxi6 libxrandr2

RUN curl -sSL "https://download2.gluonhq.com/openjfx/21.0.5/openjfx-21.0.5_linux-x64_bin-sdk.zip" | bsdtar -xvf- -C /usr/lib/jvm/
