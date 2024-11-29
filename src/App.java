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
        Label helloLabel = new Label("Hello, Catherine!");
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
