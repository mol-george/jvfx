# setup-vscode-for-java-and-javafx
* install VSC plugins
    - [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
    - [Project Manager for JavaFX](https://marketplace.visualstudio.com/items?itemName=AcademiaDosDevs.javafx)
* ![add javafx under JFX Referenced Libraries](./add-javafx-referenced-libraries.png)
* add configuration to launch.json `Run > Add Configuration... and choose Java` - which will create a `.vscode/launch.json` file where you need to add the path to the JavaFX SDK
```json
{
    "version": "0.2.0",
    "configurations": [
        {
            "vmArgs": "--module-path \" ~/java/javafx-sdk-21.0.5/lib\" --add-modules javafx.controls,javafx.fxml",
            "type": "java",
            "name": "Launch Current File",
            "request": "launch",
            "mainClass": "${file}"
        },
        {
            "vmArgs": "--module-path \" ~/java/javafx-sdk-21.0.5/lib\" --add-modules javafx.controls,javafx.fxml",
            "type": "java",
            "name": "Launch App",
            "request": "launch",
            "mainClass": "App"
        }
    ]
}
 ```
