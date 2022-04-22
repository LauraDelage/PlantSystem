import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This is the PlantDriver Class
 * This class controls the GUI and facilitates user input and output
 * @author: Keelin Saranchuk
 * */

public class PlantDriver extends Application {
    Pane homeCanvas = new Pane();
    ImageView startImage = new ImageView();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene homeScene = new Scene(homeCanvas, 600, 780, Color.WHITE);
        primaryStage.setScene(homeScene);
        primaryStage.show();
        startHomeScene();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void startHomeScene() {
        //Defining main title image:
        startImage.setImage(new Image("plantTitle.jpg"));
        startImage.setX(0);
        startImage.setY(-20);
        startImage.setFitWidth(600);
        startImage.setPreserveRatio(true);
        //Adding all elements to the canvas:
        homeCanvas.getChildren().add(startImage);
    }
}
