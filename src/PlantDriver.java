import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * This is the PlantDriver Class
 * This class controls the GUI and facilitates user input and output
 * @author: Keelin Saranchuk
 * */

public class PlantDriver extends Application implements Global {
    ImageView startImage = new ImageView();
    ImageView tulip = new ImageView();

    Pane homeCanvas = new Pane();
    Pane plantNameCanvas = new Pane();
    Pane plantSpeciesCanvas = new Pane();
    Pane plantTypeCanvas = new Pane();
    Pane plantWaterCanvas = new Pane();

    Button addPlant = new Button("Add Plant");
    Button plantName = new Button("Submit Plant Name");
    Button plantSpecies = new Button("Submit Plant Species");
    Button plantType = new Button("Submit Plant Type");
    Button plantWater = new Button("Submit Water Percentage");

    Text plantNameText = new Text(30, 75, "What is your plant's name?");
    Text plantSpeciesText = new Text(30, 75, "What is your plant's species?");
    Text plantTypeText = new Text(30, 75, "Select your plant type.");
    Text plantWaterText = new Text(30, 75, "Water requirements (% moisture) of your plant?");

    TextField plantNameInput = new TextField();
    TextField plantSpeciesInput = new TextField();
    ComboBox<PlantType> plantTypeInput = new ComboBox<PlantType>();
    TextField plantWaterInput = new TextField();

    String plantTypeString;

    ArrayList<Plant> plantArrayList;

    CircuitBoardConnection connector = new CircuitBoardConnection();

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene homeScene = new Scene(homeCanvas, 600, 780, Color.WHITE);
        Scene plantNameScene = new Scene(plantNameCanvas, 510, 410, Color.WHITE);
        Scene plantSpeciesScene = new Scene(plantSpeciesCanvas, 510, 410, Color.WHITE);
        Scene plantTypeScene = new Scene(plantTypeCanvas, 510, 370, Color.WHITE);
        Scene plantWaterScene = new Scene(plantWaterCanvas, 510, 410, Color.WHITE);
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

        plantType.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Remove elements from home scene:
                plantTypeCanvas.getChildren().remove(plantType);
                plantTypeCanvas.getChildren().remove(plantTypeText);
                plantTypeCanvas.getChildren().remove(plantTypeInput);
                //Initiate user input scene:
                startPlantWaterScene();
                primaryStage.setScene(plantWaterScene);
            }
        });

        plantWater.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                plantWaterCanvas.getChildren().remove(plantWater);
                plantWaterCanvas.getChildren().remove(plantWaterText);
                plantWaterCanvas.getChildren().remove(plantWaterInput);
                primaryStage.setScene(homeScene);
                startHomeScene();

                //temporary parameters
                String name = plantNameInput.getText();
                String species = plantSpeciesInput.getText();
                PlantType typeEnum = plantTypeInput.getValue();
                String type = typeEnum.toString();
                String waterString = plantWaterInput.getText();
                int water = Integer.parseInt(waterString);


                System.out.println(name + " " + species + " " + type + " " + water);
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
        //tulip picture
        tulip.setImage(new Image("tulips.png"));
        tulip.setX(-10);
        tulip.setY(84);
        tulip.setFitWidth(525);
        tulip.setPreserveRatio(true);
        //Adding all elements to the canvas:
        plantNameCanvas.getChildren().add(tulip);
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
        plantSpeciesCanvas.getChildren().add(tulip);
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
        //Defining drop down list:
        plantTypeInput.getItems().setAll(PlantType.values());
        plantTypeInput.setLayoutX(30);
        plantTypeInput.setLayoutY(95);
        plantTypeInput.setPrefHeight(40);
        plantTypeInput.setPrefWidth(200);
        plantTypeInput.setStyle("-fx-background-color: #91C031");
        //Defining submit button:
        plantType.setStyle("-fx-background-color: #488940");
        plantType.setLayoutX(30);
        plantType.setLayoutY(155);
        plantType.setTextFill(Color.WHITE);
        plantType.setFont(buttonFont);
        //change tulip layout
        tulip.setY(54);
        //Adding all elements to the canvas:
        plantTypeCanvas.getChildren().add(tulip);
        plantTypeCanvas.getChildren().add(plantType);
        plantTypeCanvas.getChildren().add(plantTypeText);
        plantTypeCanvas.getChildren().add(plantTypeInput);
        plantTypeCanvas.setStyle("-fx-background-color: white;");
    }

    public void startPlantWaterScene() {
        plantWaterCanvas.setStyle("-fx-background-color: white;");
        Font buttonFont = new Font("Impact", 20); //Impact
        Font textBoxFont = new Font("Arial", 12);
        //Defining text:
        plantWaterText.setFont(buttonFont);
        plantWaterText.setFill(Color.rgb(72, 137, 64));
        //Defining text box:
        plantWaterInput.setLayoutX(30);
        plantWaterInput.setLayoutY(95);
        plantWaterInput.setPrefHeight(95);
        plantWaterInput.setPrefWidth(405);
        plantWaterInput.setFont(textBoxFont);
        //Defining submit button:
        plantWater.setStyle("-fx-background-color: #488940");
        plantWater.setLayoutX(30);
        plantWater.setLayoutY(210);
        plantWater.setTextFill(Color.WHITE);
        plantWater.setFont(buttonFont);
        //change tulip layout back
        tulip.setY(84);
        //Adding all elements to the canvas:
        plantWaterCanvas.getChildren().add(tulip);
        plantWaterCanvas.getChildren().add(plantWater);
        plantWaterCanvas.getChildren().add(plantWaterText);
        plantWaterCanvas.getChildren().add(plantWaterInput);
        plantWaterCanvas.setStyle("-fx-background-color: white;");

    }

    public void findPlantTypeIndex(String plantType) {
        for(int count = 0; count < plantTypeCompareArray.length; count++) {

        }
    }
}


//sort by water levels
//sort by name