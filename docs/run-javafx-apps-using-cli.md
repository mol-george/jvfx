# run-javafx-apps-using-cli

```sh
# Compile the JavaFX application
# - --module-path: Specifies the path to the JavaFX modules (in the lib directory of the SDK)
# - --add-modules: Includes the required JavaFX modules (controls, fxml)
# - -d: Specifies the directory to output the compiled .class files
# - Replace <javafx-sdk-path>, <src-path>, and <output-bin-path> with actual paths
javac --module-path <javafx-sdk-path> \
      --add-modules javafx.controls,javafx.fxml \
      -d <output-bin-path> \
      <src-path>/App.java

# Run the JavaFX application
# - --module-path: Specifies the path to the JavaFX modules
# - --add-modules: Includes the required JavaFX modules
# - -cp: Specifies the classpath (directory containing compiled .class files)
# - Replace <javafx-sdk-path>, <output-bin-path>, and <App> with actual paths and class names
java --module-path <javafx-sdk-path> \
     --add-modules javafx.controls,javafx.fxml \
     -cp <output-bin-path> \
     <App>

# Example
javac --module-path ~/java/javafx-sdk-21.0.5/lib/ --add-modules javafx.controls,javafx.fxml -d bin src/App.java
java  --module-path ~/java/javafx-sdk-21.0.5/lib/ --add-modules javafx.controls,javafx.fxml -cp bin App
```
