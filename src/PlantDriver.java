import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

import static javafx.scene.text.Font.getFontNames;

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
    Pane plant1Canvas = new Pane();
    Pane plant2Canvas = new Pane();
    Pane plant3Canvas = new Pane();
    Pane plant4Canvas = new Pane();
    Pane plant5Canvas = new Pane();
    Pane plant6Canvas = new Pane();
    Pane plant7Canvas = new Pane();
    Pane plant8Canvas = new Pane();
    Pane plant9Canvas = new Pane();


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
    ComboBox<PlantType> plantTypeInput = new ComboBox<>();
    TextField plantWaterInput = new TextField();

    int plantCounter = 1;
    ArrayList<Plant> plantArrayList = new ArrayList<>();
    ArrayList<Button> correspondingButtonArrayList = new ArrayList<>();
    Button button1 = new Button();
    Button button2 = new Button();
    Button button3 = new Button();
    Button button4 = new Button();
    Button button5 = new Button();
    Button button6 = new Button();
    Button button7 = new Button();
    Button button8 = new Button();
    Button button9 = new Button();

    Plant plant1;
    Plant plant2;
    Plant plant3;
    Plant plant4;
    Plant plant5;
    Plant plant6;
    Plant plant7;
    Plant plant8;
    Plant plant9;

    CircuitBoardConnection connector = new CircuitBoardConnection();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene homeScene = new Scene(homeCanvas, 600, 780, Color.WHITE);
        Scene plantNameScene = new Scene(plantNameCanvas, 510, 410, Color.WHITE);
        Scene plantSpeciesScene = new Scene(plantSpeciesCanvas, 510, 410, Color.WHITE);
        Scene plantTypeScene = new Scene(plantTypeCanvas, 510, 370, Color.WHITE);
        Scene plantWaterScene = new Scene(plantWaterCanvas, 510, 410, Color.WHITE);
        Scene plant1Scene = new Scene(plant1Canvas, 930, 280, Color.WHITE);
        Scene plant2Scene = new Scene(plant2Canvas, 930, 280, Color.WHITE);
        Scene plant3Scene = new Scene(plant3Canvas, 930, 280, Color.WHITE);
        Scene plant4Scene = new Scene(plant4Canvas, 930, 280, Color.WHITE);
        Scene plant5Scene = new Scene(plant5Canvas, 930, 280, Color.WHITE);
        Scene plant6Scene = new Scene(plant6Canvas, 930, 280, Color.WHITE);
        Scene plant7Scene = new Scene(plant7Canvas, 930, 280, Color.WHITE);
        Scene plant8Scene = new Scene(plant8Canvas, 930, 280, Color.WHITE);
        Scene plant9Scene = new Scene(plant9Canvas, 930, 280, Color.WHITE);
        primaryStage.setScene(homeScene);
        primaryStage.show();
        startHomeScene();

        //System.out.println(getFontNames());

        addPlant.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Remove elements from home scene:
                homeCanvas.getChildren().remove(startImage);
                homeCanvas.getChildren().remove(addPlant);
                for(int i = 0; i < correspondingButtonArrayList.size(); i++) {
                    homeCanvas.getChildren().remove(correspondingButtonArrayList.get(i));
                }
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
                String typeString = typeEnum.toString();
                int type = findPlantTypeIndex(typeString);
                String waterString = plantWaterInput.getText();
                int water = Integer.parseInt(waterString);

                drawPlantMainScene(name, species, type, water, plantCounter);
            }
        });

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(plant1Scene);
                plant1.drawPlant(plant1Canvas, plant1);
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(plant2Scene);
                plant2.drawPlant(plant2Canvas, plant2);
            }
        });

        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(plant3Scene);
                plant3.drawPlant(plant3Canvas, plant3);
            }
        });

        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(plant4Scene);
                plant4.drawPlant(plant4Canvas, plant4);
            }
        });

        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(plant5Scene);
                plant5.drawPlant(plant5Canvas, plant5);
            }
        });

        button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(plant6Scene);
                plant6.drawPlant(plant6Canvas, plant6);
            }
        });

        button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(plant7Scene);
                plant7.drawPlant(plant7Canvas, plant7);
            }
        });

        button8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(plant8Scene);
                plant8.drawPlant(plant8Canvas, plant8);
            }
        });

        button9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(plant9Scene);
                plant9.drawPlant(plant9Canvas, plant9);
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
    public void drawPlantMainScene(String name, String species, int plantTypeIndex, int waterRequirements, int plantIDCounter) {

        if(plantIDCounter == 1) {
            ImageView image = new ImageView();
            /*Rectangle rectangle = new Rectangle();
            rectangle.setX(45);
            rectangle.setY(140);
            rectangle.setArcHeight(15);
            rectangle.setArcWidth(15);
            rectangle.setHeight(150);
            rectangle.setWidth(200);
            rectangle.setStyle("-fx-stroke: #b6fc8b");
            homeCanvas.getChildren().add(rectangle);*/

            plant1 = new Plant(name, species, plantTypeIndex, waterRequirements, plantIDCounter);
            plantArrayList.add(plant1);
            correspondingButtonArrayList.add(button1);
            button1.setStyle("-fx-background-color: #FFFFFF");
            button1.setLayoutX(50);
            button1.setLayoutY(140);

            if(plantTypeIndex == 0) {
                image.setImage(new Image("flower.png"));
                image.setFitHeight(156);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 1) {
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(160);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 2) {
                image.setImage(new Image("herb.png"));
                image.setFitHeight(150);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 3) {
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(150);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 4) {
                image.setImage(new Image("tree.png"));
                image.setFitHeight(153);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 5) {
                image.setImage(new Image("fern.png"));
                image.setFitHeight(153);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 6) {
                image.setImage(new Image("other.png"));
                image.setFitHeight(148);
                image.setPreserveRatio(true);
            }
            button1.setGraphic(image);
        }

        if(plantIDCounter == 2) {
            ImageView image = new ImageView();

            plant2 = new Plant(name, species, plantTypeIndex, waterRequirements, plantIDCounter);
            plantArrayList.add(plant2);
            correspondingButtonArrayList.add(button2);
            button2.setStyle("-fx-background-color: #FFFFFF");
            button2.setLayoutX(225);
            button2.setLayoutY(140);

            if(plantTypeIndex == 0) {
                image.setImage(new Image("flower.png"));
                image.setFitHeight(156);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 1) {
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(160);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 2) {
                image.setImage(new Image("herb.png"));
                image.setFitHeight(150);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 3) {
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(150);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 4) {
                image.setImage(new Image("tree.png"));
                image.setFitHeight(153);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 5) {
                image.setImage(new Image("fern.png"));
                image.setFitHeight(153);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 6) {
                image.setImage(new Image("other.png"));
                image.setFitHeight(148);
                image.setPreserveRatio(true);
            }
            button2.setGraphic(image);
        }

        if(plantIDCounter == 3) {
            ImageView image = new ImageView();

            plant3 = new Plant(name, species, plantTypeIndex, waterRequirements, plantIDCounter);
            plantArrayList.add(plant3);
            correspondingButtonArrayList.add(button3);
            button3.setStyle("-fx-background-color: #FFFFFF");
            button3.setLayoutX(400);
            button3.setLayoutY(140);

            if(plantTypeIndex == 0) {
                image.setImage(new Image("flower.png"));
                image.setFitHeight(156);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 1) {
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(160);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 2) {
                image.setImage(new Image("herb.png"));
                image.setFitHeight(150);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 3) {
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(150);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 4) {
                image.setImage(new Image("tree.png"));
                image.setFitHeight(153);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 5) {
                image.setImage(new Image("fern.png"));
                image.setFitHeight(153);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 6) {
                image.setImage(new Image("other.png"));
                image.setFitHeight(148);
                image.setPreserveRatio(true);
            }
            button3.setGraphic(image);
        }

        if(plantIDCounter == 4) {
            ImageView image = new ImageView();

            plant4 = new Plant(name, species, plantTypeIndex, waterRequirements, plantIDCounter);
            plantArrayList.add(plant4);
            correspondingButtonArrayList.add(button4);
            button4.setStyle("-fx-background-color: #FFFFFF");
            button4.setLayoutX(50);
            button4.setLayoutY(320);

            if(plantTypeIndex == 0) {
                image.setImage(new Image("flower.png"));
                image.setFitHeight(156);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 1) {
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(160);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 2) {
                image.setImage(new Image("herb.png"));
                image.setFitHeight(150);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 3) {
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(150);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 4) {
                image.setImage(new Image("tree.png"));
                image.setFitHeight(153);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 5) {
                image.setImage(new Image("fern.png"));
                image.setFitHeight(153);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 6) {
                image.setImage(new Image("other.png"));
                image.setFitHeight(148);
                image.setPreserveRatio(true);
            }
            button4.setGraphic(image);
        }

        if(plantIDCounter == 5) {
            ImageView image = new ImageView();

            plant5 = new Plant(name, species, plantTypeIndex, waterRequirements, plantIDCounter);
            plantArrayList.add(plant5);
            correspondingButtonArrayList.add(button5);
            button5.setStyle("-fx-background-color: #FFFFFF");
            button5.setLayoutX(225);
            button5.setLayoutY(320);

            if(plantTypeIndex == 0) {
                image.setImage(new Image("flower.png"));
                image.setFitHeight(156);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 1) {
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(160);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 2) {
                image.setImage(new Image("herb.png"));
                image.setFitHeight(150);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 3) {
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(150);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 4) {
                image.setImage(new Image("tree.png"));
                image.setFitHeight(153);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 5) {
                image.setImage(new Image("fern.png"));
                image.setFitHeight(153);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 6) {
                image.setImage(new Image("other.png"));
                image.setFitHeight(148);
                image.setPreserveRatio(true);
            }
            button5.setGraphic(image);
        }

        if(plantIDCounter == 6) {
            ImageView image = new ImageView();

            plant6 = new Plant(name, species, plantTypeIndex, waterRequirements, plantIDCounter);
            plantArrayList.add(plant6);
            correspondingButtonArrayList.add(button6);
            button6.setStyle("-fx-background-color: #FFFFFF");
            button6.setLayoutX(400);
            button6.setLayoutY(320);

            if(plantTypeIndex == 0) {
                image.setImage(new Image("flower.png"));
                image.setFitHeight(156);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 1) {
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(160);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 2) {
                image.setImage(new Image("herb.png"));
                image.setFitHeight(150);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 3) {
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(150);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 4) {
                image.setImage(new Image("tree.png"));
                image.setFitHeight(153);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 5) {
                image.setImage(new Image("fern.png"));
                image.setFitHeight(153);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 6) {
                image.setImage(new Image("other.png"));
                image.setFitHeight(148);
                image.setPreserveRatio(true);
            }
            button6.setGraphic(image);
        }

        if(plantIDCounter == 7) {
            ImageView image = new ImageView();

            plant7 = new Plant(name, species, plantTypeIndex, waterRequirements, plantIDCounter);
            plantArrayList.add(plant7);
            correspondingButtonArrayList.add(button7);
            button7.setStyle("-fx-background-color: #FFFFFF");
            button7.setLayoutX(50);
            button7.setLayoutY(500);

            if(plantTypeIndex == 0) {
                image.setImage(new Image("flower.png"));
                image.setFitHeight(156);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 1) {
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(160);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 2) {
                image.setImage(new Image("herb.png"));
                image.setFitHeight(150);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 3) {
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(150);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 4) {
                image.setImage(new Image("tree.png"));
                image.setFitHeight(153);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 5) {
                image.setImage(new Image("fern.png"));
                image.setFitHeight(153);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 6) {
                image.setImage(new Image("other.png"));
                image.setFitHeight(148);
                image.setPreserveRatio(true);
            }
            button7.setGraphic(image);
        }

        if(plantIDCounter == 8) {
            ImageView image = new ImageView();

            plant8 = new Plant(name, species, plantTypeIndex, waterRequirements, plantIDCounter);
            plantArrayList.add(plant8);
            correspondingButtonArrayList.add(button8);
            button8.setStyle("-fx-background-color: #FFFFFF");
            button8.setLayoutX(225);
            button8.setLayoutY(500);

            if(plantTypeIndex == 0) {
                image.setImage(new Image("flower.png"));
                image.setFitHeight(156);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 1) {
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(160);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 2) {
                image.setImage(new Image("herb.png"));
                image.setFitHeight(150);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 3) {
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(150);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 4) {
                image.setImage(new Image("tree.png"));
                image.setFitHeight(153);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 5) {
                image.setImage(new Image("fern.png"));
                image.setFitHeight(153);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 6) {
                image.setImage(new Image("other.png"));
                image.setFitHeight(148);
                image.setPreserveRatio(true);
            }
            button8.setGraphic(image);
        }

        if(plantIDCounter == 9) {
            ImageView image = new ImageView();

            plant9 = new Plant(name, species, plantTypeIndex, waterRequirements, plantIDCounter);
            plantArrayList.add(plant9);
            correspondingButtonArrayList.add(button9);
            button9.setStyle("-fx-background-color: #FFFFFF");
            button9.setLayoutX(400);
            button9.setLayoutY(500);

            if(plantTypeIndex == 0) {
                image.setImage(new Image("flower.png"));
                image.setFitHeight(156);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 1) {
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(160);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 2) {
                image.setImage(new Image("herb.png"));
                image.setFitHeight(150);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 3) {
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(150);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 4) {
                image.setImage(new Image("tree.png"));
                image.setFitHeight(153);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 5) {
                image.setImage(new Image("fern.png"));
                image.setFitHeight(153);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 6) {
                image.setImage(new Image("other.png"));
                image.setFitHeight(148);
                image.setPreserveRatio(true);
            }
            button9.setGraphic(image);
        }

        for(int i = 0; i < correspondingButtonArrayList.size(); i++) {
            homeCanvas.getChildren().add(correspondingButtonArrayList.get(i));
        }
        plantCounter++;
    }

    public int findPlantTypeIndex(String plantType) {
        int returnCount = 0;
        for(int count = 0; count < plantTypeCompareArray.length; count++) {
            if(plantType.compareTo(plantTypeCompareArray[count]) == 0) {
                returnCount = count;
            }
        }
        return returnCount;
    }
}


//sort by water levels
//sort by name