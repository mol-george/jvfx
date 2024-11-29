# setup-java-and-javafx-sdk

## relevant videos
* JAVAFX SDK
    - https://www.youtube.com/watch?v=AubJaosfI-0
    - https://www.youtube.com/watch?v=ombuBCzClzo

* JAVA SDK
    - https://www.youtube.com/watch?v=AubJaosfI-0
    - https://www.youtube.com/watch?v=ombuBCzClzo

```sh
#1. download and run ARM64 java sdk installer (21 or later) from https://www.oracle.com/uk/java/technologies/downloads/#jdk21-mac
wget https://download.oracle.com/java/21/latest/jdk-21_macos-aarch64_bin.dmg # 21
open jdk-21_macos-aarch64_bin.dmg

# unmount dis
del jdk-21_macos-aarch64_bin.dmg

# update ~/.bash_profile or ~/.zshrc
export JAVA_HOME=$(/usr/libexec/java_home -v 21)
export PATH="${JAVA_HOME}/bin:${PATH}"

source ~/.bash_profile
source ~/.zshrc

echo $JAVA_HOME
echo $PATH

#2. download javafx sdk from https://gluonhq.com/products/javafx/, https://openjfx.io/openjfx-docs/#install-javafx
mkdir -pv ~/java
curl -sSL "https://download2.gluonhq.com/openjfx/21.0.5/openjfx-21.0.5_osx-aarch64_bin-sdk.zip" | ditto -x -k - ~/java/
```
