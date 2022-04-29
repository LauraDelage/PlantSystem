import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This is the PlantDriver Class
 * This class controls the GUI and facilitates user input and output
 * @author: Keelin Saranchuk
 * */

public class PlantDriver extends Application {
    ImageView startImage = new ImageView();

    Pane homeCanvas = new Pane();
    Pane plantNameCanvas = new Pane();
    Pane plantSpeciesCanvas = new Pane();
    Pane plantTypeCanvas = new Pane();

    Button addPlant = new Button("Add Plant");
    Button plantName = new Button("Submit Plant Name");
    Button plantSpecies = new Button("Submit Plant Species");
    Button plantType = new Button("Submit Plant Type");

    Text plantNameText = new Text(30, 75, "What is your plant's name?");
    Text plantSpeciesText = new Text(30, 75, "What is your plant's species?");
    Text plantTypeText = new Text(30, 75, "Select your plant type.");

    TextField plantNameInput = new TextField();
    TextField plantSpeciesInput = new TextField();
    TextField plantTypeInput = new TextField();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene homeScene = new Scene(homeCanvas, 600, 780, Color.WHITE);
        Scene plantNameScene = new Scene(plantNameCanvas, 510, 300, Color.WHITE);
        Scene plantSpeciesScene = new Scene(plantSpeciesCanvas, 510, 300, Color.WHITE);
        Scene plantTypeScene = new Scene(plantTypeCanvas, 510, 300, Color.WHITE);
        primaryStage.setScene(homeScene);
        primaryStage.show();
        startHomeScene();

        addPlant.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Remove elements from home scene:
                homeCanvas.getChildren().remove(startImage);
                homeCanvas.getChildren().remove(addPlant);
                //Initiate user input scene:
                startPlantNameScene();
                primaryStage.setScene(plantNameScene);
            }
        });

        plantName.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Remove elements from home scene:
                plantNameCanvas.getChildren().remove(plantName);
                plantNameCanvas.getChildren().remove(plantNameText);
                plantNameCanvas.getChildren().remove(plantNameInput);
                //Initiate user input scene:
                startPlantSpeciesScene();
                primaryStage.setScene(plantSpeciesScene);
            }
        });

        plantSpecies.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Remove elements from home scene:
                plantSpeciesCanvas.getChildren().remove(plantSpecies);
                plantSpeciesCanvas.getChildren().remove(plantSpeciesText);
                plantSpeciesCanvas.getChildren().remove(plantSpeciesInput);
                //Initiate user input scene:
                startPlantTypeScene();
                primaryStage.setScene(plantTypeScene);
            }
        });

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

    public void startPlantNameScene() {
        plantNameCanvas.setStyle("-fx-background-color: white;");
        Font buttonFont = new Font("Impact", 20); //Impact
        Font textBoxFont = new Font("Arial", 12);
        //Defining text:
        plantNameText.setFont(buttonFont);
        plantNameText.setFill(Color.rgb(72, 137, 64));
        //Defining text box:
        plantNameInput.setLayoutX(30);
        plantNameInput.setLayoutY(95);
        plantNameInput.setPrefHeight(95);
        plantNameInput.setPrefWidth(405);
        plantNameInput.setFont(textBoxFont);
        //Defining submit button:
        plantName.setStyle("-fx-background-color: #488940");
        plantName.setLayoutX(30);
        plantName.setLayoutY(210);
        plantName.setTextFill(Color.WHITE);
        plantName.setFont(buttonFont);
        //Adding all elements to the canvas:
        plantNameCanvas.getChildren().add(plantName);
        plantNameCanvas.getChildren().add(plantNameText);
        plantNameCanvas.getChildren().add(plantNameInput);
        plantNameCanvas.setStyle("-fx-background-color: white;");
    }

    public void startPlantSpeciesScene() {
        plantSpeciesCanvas.setStyle("-fx-background-color: white;");
        Font buttonFont = new Font("Impact", 20); //Impact
        Font textBoxFont = new Font("Arial", 12);
        //Defining text:
        plantSpeciesText.setFont(buttonFont);
        plantSpeciesText.setFill(Color.rgb(72, 137, 64));
        //Defining text box:
        plantSpeciesInput.setLayoutX(30);
        plantSpeciesInput.setLayoutY(95);
        plantSpeciesInput.setPrefHeight(95);
        plantSpeciesInput.setPrefWidth(405);
        plantSpeciesInput.setFont(textBoxFont);
        //Defining submit button:
        plantSpecies.setStyle("-fx-background-color: #488940");
        plantSpecies.setLayoutX(30);
        plantSpecies.setLayoutY(210);
        plantSpecies.setTextFill(Color.WHITE);
        plantSpecies.setFont(buttonFont);
        //Adding all elements to the canvas:
        plantSpeciesCanvas.getChildren().add(plantSpecies);
        plantSpeciesCanvas.getChildren().add(plantSpeciesText);
        plantSpeciesCanvas.getChildren().add(plantSpeciesInput);
        plantSpeciesCanvas.setStyle("-fx-background-color: white;");
    }

    public void startPlantTypeScene() {
        plantTypeCanvas.setStyle("-fx-background-color: white;");
        Font buttonFont = new Font("Impact", 20); //Impact
        Font textBoxFont = new Font("Arial", 12);
        //Defining text:
        plantTypeText.setFont(buttonFont);
        plantTypeText.setFill(Color.rgb(72, 137, 64));
        //Defining text box:
        plantTypeInput.setLayoutX(30);
        plantTypeInput.setLayoutY(95);
        plantTypeInput.setPrefHeight(95);
        plantTypeInput.setPrefWidth(405);
        plantTypeInput.setFont(textBoxFont);
        //Defining submit button:
        plantType.setStyle("-fx-background-color: #488940");
        plantType.setLayoutX(30);
        plantType.setLayoutY(210);
        plantType.setTextFill(Color.WHITE);
        plantType.setFont(buttonFont);
        //Adding all elements to the canvas:
        plantTypeCanvas.getChildren().add(plantType);
        plantTypeCanvas.getChildren().add(plantTypeText);
        plantTypeCanvas.getChildren().add(plantTypeInput);
        plantTypeCanvas.setStyle("-fx-background-color: white;");
    }
}


//sort by water levels
//sort by name