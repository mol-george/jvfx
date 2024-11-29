# run-javafx-apps-in-docker

```sh
## install XQuartz
* under XQuartz > Settings > Security
# disable "Authenticate connections"
# enable "Allow connections from network clients"
# restart XQuartz
defaults write org.xquartz.X11 enable_tcp   -bool true
defaults write org.xquartz.X11 nolisten_tcp -bool false
defaults write org.xquartz.X11 no_auth      -bool true
# restart XQuartz

## test XQuartz
xeyes

## run docker
docker run --detach \
  --platform linux/amd64 \
  --name jvfx \
  --env DISPLAY=host.docker.internal:0 \
  mcr.microsoft.com/devcontainers/java:21 \
  sleep infinity

docker container rm --force jvfx

# --- ONL LOCAL MAC ---#
## ALLOW CONTAINER TO CONNECT TO XQuartz X11 Server
## assuming container is named jvfx and runs on orbstack
xhost +jvfx.orb.local

# list jvfx.orb.local ip
dscacheutil -q host -a name jvfx.orb.local | grep ip_address | awk '{print $2}'

# ensure jvfx.orb.local ip is listed
xhost
# ------------------- #

docker exec -it jvfx /bin/bash

apt update
apt install -y x11-apps libarchive-tools libgtk-3-0 libglib2.0-0 libx11-6 libasound2 libnss3 libxext6 libxrender1 libxtst6 libxi6 libxrandr2
curl -sSL "https://download2.gluonhq.com/openjfx/21.0.5/openjfx-21.0.5_linux-x64_bin-sdk.zip" | bsdtar -xvf- -C /usr/lib/jvm/

ls  /usr/lib/jvm/javafx-sdk-21.0.5/lib/
xeyes

mkdir -pv /app/{src,bin}
cat <<EOF > /app/src/App.java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        // Print "Hello, World!" to the console with ANSI colors
        System.out.println("\u001B[35mHello, \u001B[33mWorld! \u001B[36m🌟\u001B[0m");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a label to display "Hello, World!" with styling
        Label helloLabel = new Label("Hello, World!");
        helloLabel.setStyle(
                "-fx-font-size: 36px; -fx-font-weight: bold; -fx-text-fill: linear-gradient(to right, red, orange, yellow, green, cyan, blue, violet);");

        // Add a drop shadow effect to the text
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.DARKMAGENTA);
        dropShadow.setRadius(15);
        helloLabel.setEffect(dropShadow);

        // Add the label to the layout
        StackPane root = new StackPane();
        root.getChildren().add(helloLabel);
        root.setStyle("-fx-background-color: radial-gradient(radius 100%, lightblue, lightgreen);");

        // Set up the stage with a title, scene, and size
        primaryStage.setTitle("Colorful Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));

        // Show the stage
        primaryStage.show();
    }
}
EOF

javac --module-path  /usr/lib/jvm/javafx-sdk-21.0.5/lib/ --add-modules javafx.controls,javafx.fxml -d   /app/bin  /app/src/App.java
java  --module-path  /usr/lib/jvm/javafx-sdk-21.0.5/lib/ --add-modules javafx.controls,javafx.fxml -cp  /app/bin App
```
