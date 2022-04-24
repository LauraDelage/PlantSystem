import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * This is the PlantDriver Class
 * This class controls the GUI and facilitates user input and output
 * @author: Keelin Saranchuk
 * */

public class PlantDriver extends Application {
    Pane homeCanvas = new Pane();
    ImageView startImage = new ImageView();
    Button addPlant = new Button("Add Plant");

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
        homeCanvas.setStyle("-fx-background-color: white;");
        Font font2 = new Font("Impact", 20); //Impact
        //Defining main title image:
        startImage.setImage(new Image("plantTitle.jpg"));
        startImage.setX(0);
        startImage.setY(-20);
        startImage.setFitWidth(600);
        startImage.setPreserveRatio(true);
        //Defining add plant button:
        addPlant.setStyle("-fx-background-color: #488940");
        addPlant.setLayoutX(30);
        addPlant.setLayoutY(710);
        addPlant.setTextFill(Color.WHITE);
        addPlant.setFont(font2);
        //Adding all elements to the canvas:
        homeCanvas.getChildren().add(startImage);
        homeCanvas.getChildren().add(addPlant);
    }
}
