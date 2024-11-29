# run-javafx-apps-using-cli

```sh
javac --module-path ~/java/javafx-sdk-21.0.5/lib/ --add-modules javafx.controls,javafx.fxml -d bin src/App.java
java --module-path  ~/java/javafx-sdk-21.0.5/lib/ --add-modules javafx.controls,javafx.fxml -cp bin App
```
