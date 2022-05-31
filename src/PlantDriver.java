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
    ImageView startImage = new ImageView(); //plant title image, home scene
    ImageView tulip = new ImageView(); //tulip image, user input scenes

    Pane homeCanvas = new Pane(); //home canvas
    Pane plantNameCanvas = new Pane(); //user plant name input canvas
    Pane plantSpeciesCanvas = new Pane(); //user plant species input canvas
    Pane plantTypeCanvas = new Pane(); //user plant type input canvas
    Pane plantWaterCanvas = new Pane(); //user plant water input canvas
    Pane plant1Canvas = new Pane(); //plant 1 info canvas
    Pane plant2Canvas = new Pane(); //plant 2 info canvas
    Pane plant3Canvas = new Pane(); //plant 3 info canvas
    Pane plant4Canvas = new Pane(); //plant 4 info canvas
    Pane plant5Canvas = new Pane(); //plant 5 info canvas
    Pane plant6Canvas = new Pane(); //plant 6 info canvas
    Pane plant7Canvas = new Pane(); //plant 7 info canvas
    Pane plant8Canvas = new Pane(); //plant 8 info canvas
    Pane plant9Canvas = new Pane(); //plant 9 info canvas

    Button addPlant = new Button("Add Plant"); //switches between home scene and plant name scene
    Button plantName = new Button("Submit Plant Name"); //switches between plant name scene and plant species scene
    Button plantSpecies = new Button("Submit Plant Species"); //switches between plant species and plant type scene
    Button plantType = new Button("Submit Plant Type"); //switches between plant type and plant water scene
    Button plantWater = new Button("Submit Water Percentage"); //switches between plant water and home scene
    Button sortByWater = new Button("Sort by Need of Water"); //sorts the plants by water levels
    Button sortAlphabet = new Button("Sort Alphabetically"); //sorts the plants alphabetically

    //Text used in user input scenes:
    Text plantNameText = new Text(30, 75, "What is your plant's name?");
    Text plantSpeciesText = new Text(30, 75, "What is your plant's species?");
    Text plantTypeText = new Text(30, 75, "Select your plant type.");
    Text plantWaterText = new Text(30, 75, "Water requirements (% moisture) of your plant?");

    //Text that will display each plants' name, when added:
    Text text1 = new Text();
    Text text2 = new Text();
    Text text3 = new Text();
    Text text4 = new Text();
    Text text5 = new Text();
    Text text6 = new Text();
    Text text7 = new Text();
    Text text8 = new Text();
    Text text9 = new Text();

    //Textfields and one ComboBox, allows for user input to be collected:
    TextField plantNameInput = new TextField();
    TextField plantSpeciesInput = new TextField();
    ComboBox<PlantType> plantTypeInput = new ComboBox<>();
    TextField plantWaterInput = new TextField();

    int plantIdentificator; //used to determine which plant the user has currently selected to view, changes depending on which button has been clicked
    boolean changePlant = false; //when changePlant() method is called, this boolean is declared true
    int plantCounter = 1; //determines how many plants have been added, so we know where they will appear on screen

    ArrayList<Plant> plantArrayList = new ArrayList<>(); //plant array list, all created plants are added
    ArrayList<Plant> sortedPlantArrayList = new ArrayList<>(); //Laura's methods used to sort, returned and used as a sorted array list
    ArrayList<Button> correspondingButtonArrayList = new ArrayList<>(); //button arraylist, has plant image buttons that correspond to plants of the plant array list

    //Plant buttons, have image of plant:
    Button button1 = new Button();
    Button button2 = new Button();
    Button button3 = new Button();
    Button button4 = new Button();
    Button button5 = new Button();
    Button button6 = new Button();
    Button button7 = new Button();
    Button button8 = new Button();
    Button button9 = new Button();

    //Plant objects, contain info:
    Plant plant1;
    Plant plant2;
    Plant plant3;
    Plant plant4;
    Plant plant5;
    Plant plant6;
    Plant plant7;
    Plant plant8;
    Plant plant9;

    PlantHelper sorter = new PlantHelper(plantArrayList);  //Sorter object, used to sort plants

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene homeScene = new Scene(homeCanvas, 600, 780, Color.WHITE); //home scene
        Scene plantNameScene = new Scene(plantNameCanvas, 510, 410, Color.WHITE); //user name input scene
        Scene plantSpeciesScene = new Scene(plantSpeciesCanvas, 510, 410, Color.WHITE); //user species input scene
        Scene plantTypeScene = new Scene(plantTypeCanvas, 510, 370, Color.WHITE); //user type input scene
        Scene plantWaterScene = new Scene(plantWaterCanvas, 510, 410, Color.WHITE); //user water input scene
        Scene plant1Scene = new Scene(plant1Canvas, 930, 280, Color.WHITE); //plant 1 info scene
        Scene plant2Scene = new Scene(plant2Canvas, 930, 280, Color.WHITE); //plant 2 info scene
        Scene plant3Scene = new Scene(plant3Canvas, 930, 280, Color.WHITE); //plant 3 info scene
        Scene plant4Scene = new Scene(plant4Canvas, 930, 280, Color.WHITE); //plant 4 info scene
        Scene plant5Scene = new Scene(plant5Canvas, 930, 280, Color.WHITE); //plant 5 info scene
        Scene plant6Scene = new Scene(plant6Canvas, 930, 280, Color.WHITE); //plant 6 info scene
        Scene plant7Scene = new Scene(plant7Canvas, 930, 280, Color.WHITE); //plant 7 info scene
        Scene plant8Scene = new Scene(plant8Canvas, 930, 280, Color.WHITE); //plant 8 info scene
        Scene plant9Scene = new Scene(plant9Canvas, 930, 280, Color.WHITE); //plant 9 info scene

        //home scene appears when program is run:
        primaryStage.setScene(homeScene);
        primaryStage.show();
        startHomeScene();

        //if addPlant button is pressed:
        addPlant.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Remove elements from home scene:
                homeCanvas.getChildren().remove(startImage);
                homeCanvas.getChildren().remove(addPlant);
                homeCanvas.getChildren().remove(sortByWater);
                homeCanvas.getChildren().remove(sortAlphabet);
                for(int i = 0; i < correspondingButtonArrayList.size(); i++) {
                    homeCanvas.getChildren().remove(correspondingButtonArrayList.get(i));
                }
                //Initiate plant name user input scene:
                startPlantNameScene();
                primaryStage.setScene(plantNameScene);
            }
        });

        //if plantName button is pressed:
        plantName.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Remove elements from plant name scene:
                plantNameCanvas.getChildren().remove(plantName);
                plantNameCanvas.getChildren().remove(plantNameText);
                plantNameCanvas.getChildren().remove(plantNameInput);
                //Initiate plant species user input scene:
                startPlantSpeciesScene();
                primaryStage.setScene(plantSpeciesScene);
            }
        });

        //if plantSpecies button is pressed:
        plantSpecies.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Remove elements from plant species scene:
                plantSpeciesCanvas.getChildren().remove(plantSpecies);
                plantSpeciesCanvas.getChildren().remove(plantSpeciesText);
                plantSpeciesCanvas.getChildren().remove(plantSpeciesInput);
                //Initiate plant type user input scene:
                startPlantTypeScene();
                primaryStage.setScene(plantTypeScene);
            }
        });

        //if plantType button is pressed:
        plantType.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Remove elements from plant type scene:
                plantTypeCanvas.getChildren().remove(plantType);
                plantTypeCanvas.getChildren().remove(plantTypeText);
                plantTypeCanvas.getChildren().remove(plantTypeInput);
                //Initiate plant water user input scene:
                startPlantWaterScene();
                primaryStage.setScene(plantWaterScene);
            }
        });

        //if plantWater button is pressed:
        plantWater.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Remove elements from plant water scene:
                plantWaterCanvas.getChildren().remove(plantWater);
                plantWaterCanvas.getChildren().remove(plantWaterText);
                plantWaterCanvas.getChildren().remove(plantWaterInput);
                //Initiate home scene:
                primaryStage.setScene(homeScene);
                startHomeScene();

                //temporary parameters, they hold user input:
                String name = plantNameInput.getText(); //plant name
                String species = plantSpeciesInput.getText(); //plant species
                PlantType typeEnum = plantTypeInput.getValue();
                String typeString = typeEnum.toString();
                int type = findPlantTypeIndex(typeString); //plant type index
                String waterString = plantWaterInput.getText();
                int water = Integer.parseInt(waterString); //plant water

                if(changePlant) { //if change plant boolean is true (user has clicked change plant button and updated parameters using same process)
                    changePlant(name, species, type, water, plantIdentificator); //call change plant method

                    //depending which plant was edited, it must be removed from canvas so that we can return to home scene (avoid duplicate children):
                    if(plantIdentificator == 1) {
                        //plant 1
                        plant1.removePlant(plant1Canvas, plant1);
                    }
                    else if(plantIdentificator == 2) {
                        //plant 2
                        plant2.removePlant(plant2Canvas, plant2);
                    }
                    else if(plantIdentificator == 3) {
                        //plant 3
                        plant3.removePlant(plant3Canvas, plant3);
                    }
                    else if(plantIdentificator == 4) {
                        //plant 4
                        plant4.removePlant(plant4Canvas, plant4);
                    }
                    else if(plantIdentificator == 5) {
                        //plant 5
                        plant5.removePlant(plant5Canvas, plant5);
                    }
                    else if(plantIdentificator == 6) {
                        //plant 6
                        plant6.removePlant(plant6Canvas, plant6);
                    }
                    else if(plantIdentificator == 7) {
                        //plant 7
                        plant7.removePlant(plant7Canvas, plant7);
                    }
                    else if(plantIdentificator == 8) {
                        //plant 8
                        plant8.removePlant(plant8Canvas, plant8);
                    }
                    else if(plantIdentificator == 9) {
                        //plant 9
                        plant9.removePlant(plant9Canvas, plant9);
                    }
                }

                //if change plant button was not clicked, draw plant on home scene as you would normally
                else {
                    drawPlantMainScene(name, species, type, water, plantCounter);
                }

                //plants are automatically sorted by need of water, to get user's attention
                sortedPlantArrayList = sorter.waterSort(plantArrayList);
                sortingPlants(); //position of plants changed accordingly
                changePlant = false; //changePlant is now false so that it can be used in the future

                //clear past input:
                plantNameInput.clear();
                plantSpeciesInput.clear();
                plantWaterInput.clear();
            }

        });

        //on button1 click:
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Remove elements from home scene:
                homeCanvas.getChildren().remove(startImage);
                homeCanvas.getChildren().remove(addPlant);
                homeCanvas.getChildren().remove(sortByWater);
                homeCanvas.getChildren().remove(sortAlphabet);
                //Initiate plant 1 info scene:
                primaryStage.setScene(plant1Scene);
                plant1.drawPlant(plant1Canvas, plant1);
                plantIdentificator = 1; //Identify that user is viewing plant 1
            }
        });

        //on button2 click:
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Remove elements from home scene:
                homeCanvas.getChildren().remove(startImage);
                homeCanvas.getChildren().remove(addPlant);
                homeCanvas.getChildren().remove(sortByWater);
                homeCanvas.getChildren().remove(sortAlphabet);
                //Initiate plant 2 info scene:
                primaryStage.setScene(plant2Scene);
                plant2.drawPlant(plant2Canvas, plant2);
                plantIdentificator = 2; //Identify that user is viewing plant 2
            }
        });

        //on button3 click:
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Remove elements from home scene:
                homeCanvas.getChildren().remove(startImage);
                homeCanvas.getChildren().remove(addPlant);
                homeCanvas.getChildren().remove(sortByWater);
                homeCanvas.getChildren().remove(sortAlphabet);
                //Initiate plant 3 info scene:
                primaryStage.setScene(plant3Scene);
                plant3.drawPlant(plant3Canvas, plant3);
                plantIdentificator = 3; //Identify that user is viewing plant 3
            }
        });

        //on button4 click:
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Remove elements from home scene:
                homeCanvas.getChildren().remove(startImage);
                homeCanvas.getChildren().remove(addPlant);
                homeCanvas.getChildren().remove(sortByWater);
                homeCanvas.getChildren().remove(sortAlphabet);
                //Initiate plant 4 info scene:
                primaryStage.setScene(plant4Scene);
                plant4.drawPlant(plant4Canvas, plant4);
                plantIdentificator = 4; //Identify that user is viewing plant 4
            }
        });

        //on button5 click:
        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Remove elements from home scene:
                homeCanvas.getChildren().remove(startImage);
                homeCanvas.getChildren().remove(addPlant);
                homeCanvas.getChildren().remove(sortByWater);
                homeCanvas.getChildren().remove(sortAlphabet);
                //Initiate plant 5 info scene:
                primaryStage.setScene(plant5Scene);
                plant5.drawPlant(plant5Canvas, plant5);
                plantIdentificator = 5; //Identify that user is viewing plant 5
            }
        });

        //on button6 click:
        button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Remove elements from home scene:
                homeCanvas.getChildren().remove(startImage);
                homeCanvas.getChildren().remove(addPlant);
                homeCanvas.getChildren().remove(sortByWater);
                homeCanvas.getChildren().remove(sortAlphabet);
                //Initiate plant 6 info scene:
                primaryStage.setScene(plant6Scene);
                plant6.drawPlant(plant6Canvas, plant6);
                plantIdentificator = 6; //Identify that user is viewing plant 6
            }
        });

        //on button7 click:
        button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Remove elements from home scene:
                homeCanvas.getChildren().remove(startImage);
                homeCanvas.getChildren().remove(addPlant);
                homeCanvas.getChildren().remove(sortByWater);
                homeCanvas.getChildren().remove(sortAlphabet);
                //Initiate plant 7 info scene:
                primaryStage.setScene(plant7Scene);
                plant7.drawPlant(plant7Canvas, plant7);
                plantIdentificator = 7; //Identify that user is viewing plant 7
            }
        });

        //on button8 click:
        button8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Remove elements from home scene:
                homeCanvas.getChildren().remove(startImage);
                homeCanvas.getChildren().remove(addPlant);
                homeCanvas.getChildren().remove(sortByWater);
                homeCanvas.getChildren().remove(sortAlphabet);
                //Initiate plant 8 info scene:
                primaryStage.setScene(plant8Scene);
                plant8.drawPlant(plant8Canvas, plant8);
                plantIdentificator = 8; //Identify that user is viewing plant 8
            }
        });

        //on button9 click:
        button9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Remove elements from home scene:
                homeCanvas.getChildren().remove(startImage);
                homeCanvas.getChildren().remove(addPlant);
                homeCanvas.getChildren().remove(sortByWater);
                homeCanvas.getChildren().remove(sortAlphabet);
                //Initiate plant 9 info scene:
                primaryStage.setScene(plant9Scene);
                plant9.drawPlant(plant9Canvas, plant9);
                plantIdentificator = 9; //Identify that user is viewing plant 9
            }
        });

        //on returnToHome click:
        returnToHome.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Initiate home scene
                primaryStage.setScene(homeScene);
                startHomeScene();

                //Depending which plant was currently being viewed, it must be removed from canvas so that we can return to home scene (avoid duplicate children):
                if(plantIdentificator == 1) {
                    //plant 1
                    plant1.removePlant(plant1Canvas, plant1);
                }
                else if(plantIdentificator == 2) {
                    //plant 2
                    plant2.removePlant(plant2Canvas, plant2);
                }
                else if(plantIdentificator == 3) {
                    //plant 3
                    plant3.removePlant(plant3Canvas, plant3);
                }
                else if(plantIdentificator == 4) {
                    //plant 4
                    plant4.removePlant(plant4Canvas, plant4);
                }
                else if(plantIdentificator == 5) {
                    //plant 5
                    plant5.removePlant(plant5Canvas, plant5);
                }
                else if(plantIdentificator == 6) {
                    //plant 6
                    plant6.removePlant(plant6Canvas, plant6);
                }
                else if(plantIdentificator == 7) {
                    //plant 7
                    plant7.removePlant(plant7Canvas, plant7);
                }
                else if(plantIdentificator == 8) {
                    //plant 8
                    plant8.removePlant(plant8Canvas, plant8);
                }
                else if(plantIdentificator == 9) {
                    //plant 9
                    plant9.removePlant(plant9Canvas, plant9);
                }
            }
        });

        //on deletePlant click:
        deletePlant.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Initiate home scene:
                primaryStage.setScene(homeScene);
                deletePlant(); //deletePlant() method finds plant that was being viewed, removes it
                //sort plants in accordance with new data:
                sortedPlantArrayList = sorter.waterSort(plantArrayList);
                sortingPlants(); //position of plants changed accordingly
                startHomeScene();
            }
        });

        //on sortByWater click:
        sortByWater.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //sortedPlantArrayList is sorted by water using Laura's methods that return an array list:
                sortedPlantArrayList = sorter.waterSort(plantArrayList);
                sortingPlants(); //position of plants changed accordingly
            }
        });

        //on sortAlphabet click:
        sortAlphabet.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //sortedPlantArrayList is sorted by water using Laura's methods that return an array list:
                sortedPlantArrayList = sorter.alphaSort(plantArrayList);
                sortingPlants(); //position of plants changed accordingly
            }
        });

        //on editPlant click:
        editPlant.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //brought to first input scene:
                startPlantNameScene();
                primaryStage.setScene(plantNameScene);
                changePlant = true; //boolean used to identify if plant is being changed, set to true
            }
        });


    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The deletePlant() removes a specific plant when the user clicks on the deletePlant button
     * plant is removed from arraylist, button is removed from arraylist, button and text are removed from home scene
     * We can track which plant is being deleted because the delete plant button can only be accessed within a specific plant scene
     * plantIdentificator is changed depending on which plant scene the user is in
     *
     * @author Keelin Saranchuk
     */
    public void deletePlant() {
        if(plantIdentificator == 1) { //plantIdentificator is used to identify which plant the user is currently viewing
            //Remove all elements from canvas:
            plant1.removePlant(plant1Canvas, plant1);
            homeCanvas.getChildren().remove(button1);
            homeCanvas.getChildren().remove(text1);
            plantArrayList.remove(plant1); //removed from plant array list
            correspondingButtonArrayList.remove(button1); //corresponding image removed from button array list
        }
        else if(plantIdentificator == 2) {
            //Remove all elements from canvas:
            plant2.removePlant(plant2Canvas, plant2);
            homeCanvas.getChildren().remove(button2);
            homeCanvas.getChildren().remove(text2);
            plantArrayList.remove(plant2); //removed from plant array list
            correspondingButtonArrayList.remove(button2); //corresponding image removed from button array list

        }
        else if(plantIdentificator == 3) {
            //Remove all elements from canvas:
            plant3.removePlant(plant3Canvas, plant3);
            homeCanvas.getChildren().remove(button3);
            homeCanvas.getChildren().remove(text3);
            plantArrayList.remove(plant3); //removed from plant array list
            correspondingButtonArrayList.remove(button3); //corresponding image removed from button array list

        }
        else if(plantIdentificator == 4) {
            //Remove all elements from canvas:
            plant4.removePlant(plant4Canvas, plant4);
            homeCanvas.getChildren().remove(button4);
            homeCanvas.getChildren().remove(text4);
            plantArrayList.remove(plant4); //removed from plant array list
            correspondingButtonArrayList.remove(button4); //corresponding image removed from button array list

        }
        else if(plantIdentificator == 5) {
            //Remove all elements from canvas:
            plant5.removePlant(plant5Canvas, plant5);
            homeCanvas.getChildren().remove(button5);
            homeCanvas.getChildren().remove(text5);
            plantArrayList.remove(plant5); //removed from plant array list
            correspondingButtonArrayList.remove(button5); //corresponding image removed from button array list
        }
        else if(plantIdentificator == 6) {
            //Remove all elements from canvas:
            plant6.removePlant(plant6Canvas, plant6);
            homeCanvas.getChildren().remove(button6);
            homeCanvas.getChildren().remove(text6);
            plantArrayList.remove(plant6); //removed from plant array list
            correspondingButtonArrayList.remove(button6); //corresponding image removed from button array list
        }
        else if(plantIdentificator == 7) {
            //Remove all elements from canvas:
            plant7.removePlant(plant7Canvas, plant7);
            homeCanvas.getChildren().remove(button7);
            homeCanvas.getChildren().remove(text7);
            plantArrayList.remove(plant7); //removed from plant array list
            correspondingButtonArrayList.remove(button7); //corresponding image removed from button array list
        }
        else if(plantIdentificator == 8) {
            //Remove all elements from canvas:
            plant8.removePlant(plant8Canvas, plant8);
            homeCanvas.getChildren().remove(button8);
            homeCanvas.getChildren().remove(text8);
            plantArrayList.remove(plant8); //removed from plant array list
            correspondingButtonArrayList.remove(button8); //corresponding image removed from button array list

        }
        else if(plantIdentificator == 9) {
            //Remove all elements from canvas:
            plant9.removePlant(plant9Canvas, plant9);
            homeCanvas.getChildren().remove(button9);
            homeCanvas.getChildren().remove(text9);
            plantArrayList.remove(plant9); //removed from plant array list
            correspondingButtonArrayList.remove(button9); //corresponding image removed from button array list
        }
    }

    /**
     * The startHomeScene() adds all original elements to home scene
     * The home scene is the welcome page
     * User is able to add plant from this scene, buttons are created to allow this
     *
     * @author Keelin Saranchuk
     */
    public void startHomeScene() {
        homeCanvas.setStyle("-fx-background-color: white;");
        Font font2 = new Font("Impact", 20); //Impact
        //Defining main title image:
        startImage.setImage(new Image("plantTitle.jpg"));
        startImage.setX(0);
        startImage.setY(-30);
        startImage.setFitWidth(600);
        startImage.setPreserveRatio(true);
        //Defining add plant button:
        addPlant.setStyle("-fx-background-color: #488940");
        addPlant.setLayoutX(25);
        addPlant.setLayoutY(725);
        addPlant.setTextFill(Color.WHITE);
        addPlant.setFont(font2);
        //Defining sort by water button:
        sortByWater.setStyle("-fx-background-color: #488940");
        sortByWater.setLayoutX(140);
        sortByWater.setLayoutY(725);
        sortByWater.setTextFill(Color.WHITE);
        sortByWater.setFont(font2);
        //Defining sort by water button:
        sortAlphabet.setStyle("-fx-background-color: #488940");
        sortAlphabet.setLayoutX(353);
        sortAlphabet.setLayoutY(725);
        sortAlphabet.setTextFill(Color.WHITE);
        sortAlphabet.setFont(font2);
        //Adding all elements to the canvas:
        homeCanvas.getChildren().add(startImage);
        homeCanvas.getChildren().add(addPlant);
        homeCanvas.getChildren().add(sortByWater);
        homeCanvas.getChildren().add(sortAlphabet);
    }

    /**
     * The startPlantNameScene() is the first scene to appear when the user adds a plant
     * The user is to enter the name they have given their plant
     *
     * @author Keelin Saranchuk
     */
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

    /**
     * The startPlantSpeciesScene() is the second scene to appear when the user adds a plant
     * The user is to enter the species of their plant
     * The species should be written on the label that comes with their plant when purchased (or can be looked up online)
     *
     * @author Keelin Saranchuk
     */
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

    /**
     * The startPlantTypeScene() is the third scene to appear when the user adds a plant
     * The user is to pick which option, out of the 7 offered by the dropdown list, best suits their plant
     *
     * @author Keelin Saranchuk
     */
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

    /**
     * The startPlantWaterScene() is the fourth scene to appear when the user adds a plant
     * The user is to enter the water percentage requirements of their plant
     * The requirements should be written on the label that comes with their plant when purchased (or can be looked up online)
     *
     * @author Keelin Saranchuk
     */
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

    /**
     * The drawPlantMainScene() method draws the plant on the home scene when all user data has been entered
     * Up to 9 plants can be drawn in the given room
     * Plant objects are created and added to an array list
     * Corresponding button/image and text appear on screen
     *
     * @param name Name data, entered by user
     * @param species Species data, entered by user
     * @param plantTypeIndex Indicates which plant user chose from drop down list
     * @param waterRequirements Water data, entered by user
     * @param plantIDCounter Counts how many plants have been created, so we know where plant should appear on screen
     * @author Keelin Saranchuk
     */
    public void drawPlantMainScene(String name, String species, int plantTypeIndex, int waterRequirements, int plantIDCounter) {
        if(plantIDCounter == 1) { //plantIDCounter passes information about how many plants have been created by user thus far
            ImageView image = new ImageView(); //Defining plant image
            //Defining plant name text for plant1:
            Font font = new Font("Impact", 16);
            text1.setText(name);
            text1.setFont(font);
            text1.setLayoutX(75);
            text1.setLayoutY(290);
            text1.setFill(Color.rgb(72, 137, 64));
            homeCanvas.getChildren().add(text1);
            //plant initialized and added to plant array list:
            plant1 = new Plant(name, species, plantTypeIndex, waterRequirements, plantIDCounter);
            plantArrayList.add(plant1);
            //button added to array list:
            correspondingButtonArrayList.add(button1);
            button1.setStyle("-fx-background-color: #FFFFFF");
            button1.setLayoutX(50);
            button1.setLayoutY(120);

            //Image is changed depending on which plant type hs been selected:
            if(plantTypeIndex == 0) { //flower
                image.setImage(new Image("flower.png"));
                image.setFitHeight(141);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 1) { //succulent
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(142);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 2) { //herb
                image.setImage(new Image("herb.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 3) { //fruit
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 4) { //tree
                image.setImage(new Image("tree.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 5) {
                image.setImage(new Image("fern.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 6) { //other
                image.setImage(new Image("other.png"));
                image.setFitHeight(133);
                image.setPreserveRatio(true);
            }
            button1.setGraphic(image);
        }

        if(plantIDCounter == 2) {
            ImageView image = new ImageView();  //Defining plant image
            //plant initialized and added to plant array list:
            plant2 = new Plant(name, species, plantTypeIndex, waterRequirements, plantIDCounter);
            plantArrayList.add(plant2);
            button2.setStyle("-fx-background-color: #FFFFFF");
            //Defining plant name text for plant2:
            Font font = new Font("Impact", 16);
            text2.setText(name);
            text2.setFont(font);
            text2.setLayoutX(250);
            text2.setLayoutY(290);
            text2.setFill(Color.rgb(72, 137, 64));
            homeCanvas.getChildren().add(text2);
            //button added to array list:
            correspondingButtonArrayList.add(button2);
            button2.setLayoutX(225);
            button2.setLayoutY(120);

            //Image is changed depending on which plant type hs been selected:
            if(plantTypeIndex == 0) { //flower
                image.setImage(new Image("flower.png"));
                image.setFitHeight(141);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 1) { //succulent
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(142);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 2) { //herb
                image.setImage(new Image("herb.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 3) { //fruit
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 4) { //tree
                image.setImage(new Image("tree.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 5) { //fern
                image.setImage(new Image("fern.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 6) { //other
                image.setImage(new Image("other.png"));
                image.setFitHeight(133);
                image.setPreserveRatio(true);
            }
            button2.setGraphic(image);
        }

        if(plantIDCounter == 3) {
            ImageView image = new ImageView();  //Defining plant image
            //plant initialized and added to plant array list:
            plant3 = new Plant(name, species, plantTypeIndex, waterRequirements, plantIDCounter);
            plantArrayList.add(plant3);
            correspondingButtonArrayList.add(button3); //button added to array list
            button3.setStyle("-fx-background-color: #FFFFFF");
            //Defining plant name text for plant3:
            Font font = new Font("Impact", 16);
            text3.setText(name);
            text3.setFont(font);
            text3.setFill(Color.rgb(72, 137, 64));
            text3.setLayoutX(425);
            text3.setLayoutY(290);
            //Defining button:
            button3.setLayoutX(400);
            button3.setLayoutY(120);
            homeCanvas.getChildren().add(text3);

            //Image is changed depending on which plant type hs been selected:
            if(plantTypeIndex == 0) { //flower
                image.setImage(new Image("flower.png"));
                image.setFitHeight(141);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 1) { //succulent
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(142);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 2) { //herb
                image.setImage(new Image("herb.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 3) { //fruit
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 4) { //tree
                image.setImage(new Image("tree.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 5) { //fern
                image.setImage(new Image("fern.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 6) { //other
                image.setImage(new Image("other.png"));
                image.setFitHeight(133);
                image.setPreserveRatio(true);
            }
            button3.setGraphic(image);
        }

        if(plantIDCounter == 4) {
            ImageView image = new ImageView(); //Defining plant image
            //plant initialized and added to plant array list:
            plant4 = new Plant(name, species, plantTypeIndex, waterRequirements, plantIDCounter);
            plantArrayList.add(plant4);
            correspondingButtonArrayList.add(button4); //button added to array list
            button4.setStyle("-fx-background-color: #FFFFFF");
            //Defining plant name text for plant4:
            Font font = new Font("Impact", 16);
            text4.setText(name);
            text4.setFont(font);
            text4.setFill(Color.rgb(72, 137, 64));
            text4.setLayoutX(75);
            text4.setLayoutY(490);
            //Defining button:
            button4.setLayoutX(50);
            button4.setLayoutY(320);

            homeCanvas.getChildren().add(text4);

            //Image is changed depending on which plant type hs been selected:
            if(plantTypeIndex == 0) { //flower
                image.setImage(new Image("flower.png"));
                image.setFitHeight(141);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 1) { //succulent
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(142);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 2) { //herb
                image.setImage(new Image("herb.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 3) { //fruit
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 4) { //tree
                image.setImage(new Image("tree.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 5) { //fern
                image.setImage(new Image("fern.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 6) { //other
                image.setImage(new Image("other.png"));
                image.setFitHeight(133);
                image.setPreserveRatio(true);
            }
            button4.setGraphic(image);
        }

        if(plantIDCounter == 5) {
            ImageView image = new ImageView(); //Defining plant image
            //plant initialized and added to plant array list:
            plant5 = new Plant(name, species, plantTypeIndex, waterRequirements, plantIDCounter);
            plantArrayList.add(plant5);
            correspondingButtonArrayList.add(button5); //button added to array list
            button5.setStyle("-fx-background-color: #FFFFFF");
            //Defining plant name text for plant5:
            Font font = new Font("Impact", 16);
            text5.setFill(Color.rgb(72, 137, 64));
            text5.setText(name);
            text5.setFont(font);
            text5.setLayoutX(250);
            text5.setLayoutY(490);
            //Defining button:
            button5.setLayoutX(225);
            button5.setLayoutY(320);
            homeCanvas.getChildren().add(text5);

            //Image is changed depending on which plant type hs been selected:
            if(plantTypeIndex == 0) { //flower
                image.setImage(new Image("flower.png"));
                image.setFitHeight(141);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 1) { //succulent
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(142);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 2) { //herb
                image.setImage(new Image("herb.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 3) { //fruit
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 4) { //tree
                image.setImage(new Image("tree.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 5) { //fern
                image.setImage(new Image("fern.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 6) { //other
                image.setImage(new Image("other.png"));
                image.setFitHeight(133);
                image.setPreserveRatio(true);
            }
            button5.setGraphic(image);
        }

        if(plantIDCounter == 6) {
            ImageView image = new ImageView();  //Defining plant image
            //plant initialized and added to plant array list:
            plant6 = new Plant(name, species, plantTypeIndex, waterRequirements, plantIDCounter);
            plantArrayList.add(plant6);
            correspondingButtonArrayList.add(button6); //button added to array list
            button6.setStyle("-fx-background-color: #FFFFFF");
            //Defining plant name text for plant6:
            Font font = new Font("Impact", 16);
            text6.setText(name);
            text6.setFont(font);
            text6.setFill(Color.rgb(72, 137, 64));
            text6.setLayoutX(425);
            text6.setLayoutY(490);
            //Defining button:
            button6.setLayoutX(400);
            button6.setLayoutY(320);

            homeCanvas.getChildren().add(text6);

            //Image is changed depending on which plant type hs been selected:
            if(plantTypeIndex == 0) { //flower
                image.setImage(new Image("flower.png"));
                image.setFitHeight(141);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 1) { //succulent
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(142);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 2) { //herb
                image.setImage(new Image("herb.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 3) { //fruit
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 4) { //tree
                image.setImage(new Image("tree.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 5) { //fern
                image.setImage(new Image("fern.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 6) { //other
                image.setImage(new Image("other.png"));
                image.setFitHeight(133);
                image.setPreserveRatio(true);
            }
            button6.setGraphic(image);
        }

        if(plantIDCounter == 7) {
            ImageView image = new ImageView(); //Defining plant image
            //plant initialized and added to plant array list:
            plant7 = new Plant(name, species, plantTypeIndex, waterRequirements, plantIDCounter);
            plantArrayList.add(plant7); //button added to array list
            correspondingButtonArrayList.add(button7);
            button7.setStyle("-fx-background-color: #FFFFFF");
            //Defining plant name text for plant7:
            Font font = new Font("Impact", 16);
            text7.setText(name);
            text7.setFont(font);
            text7.setFill(Color.rgb(72, 137, 64));
            text7.setLayoutX(75);
            text7.setLayoutY(695);
            //Defining button:
            button7.setLayoutX(50);
            button7.setLayoutY(525);

            homeCanvas.getChildren().add(text7);

            //Image is changed depending on which plant type hs been selected:
            if(plantTypeIndex == 0) { //flower
                image.setImage(new Image("flower.png"));
                image.setFitHeight(141);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 1) { //succulent
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(142);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 2) { //herb
                image.setImage(new Image("herb.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 3) { //fruit
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 4) { //tree
                image.setImage(new Image("tree.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 5) { //fern
                image.setImage(new Image("fern.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 6) { //other
                image.setImage(new Image("other.png"));
                image.setFitHeight(133);
                image.setPreserveRatio(true);
            }
            button7.setGraphic(image);
        }

        if(plantIDCounter == 8) {
            ImageView image = new ImageView(); //Defining plant image
            //plant initialized and added to plant array list:
            plant8 = new Plant(name, species, plantTypeIndex, waterRequirements, plantIDCounter);
            plantArrayList.add(plant8);
            correspondingButtonArrayList.add(button8); //button added to array list
            button8.setStyle("-fx-background-color: #FFFFFF");
            //Defining plant name text for plant8:
            Font font = new Font("Impact", 16);
            text8.setText(name);
            text8.setFont(font);
            text8.setFill(Color.rgb(72, 137, 64));
            text8.setLayoutX(250);
            text8.setLayoutY(695);
            //Defining button:
            button8.setLayoutX(225);
            button8.setLayoutY(525);

            homeCanvas.getChildren().add(text8);

            //Image is changed depending on which plant type hs been selected:
            if(plantTypeIndex == 0) { //flower
                image.setImage(new Image("flower.png"));
                image.setFitHeight(141);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 1) { //succulent
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(142);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 2) { //herb
                image.setImage(new Image("herb.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 3) { //fruit
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 4) { //tree
                image.setImage(new Image("tree.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 5) { //fern
                image.setImage(new Image("fern.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 6) { //other
                image.setImage(new Image("other.png"));
                image.setFitHeight(133);
                image.setPreserveRatio(true);
            }
            button8.setGraphic(image);
        }

        if(plantIDCounter == 9) {
            ImageView image = new ImageView(); //Defining plant image
            //plant initialized and added to plant array list:
            plant9 = new Plant(name, species, plantTypeIndex, waterRequirements, plantIDCounter);
            plantArrayList.add(plant9);
            correspondingButtonArrayList.add(button9); //button added to array list
            button9.setStyle("-fx-background-color: #FFFFFF");
            //Defining plant name text for plant9:
            Font font = new Font("Impact", 16);
            text9.setText(name);
            text9.setFont(font);
            text9.setFill(Color.rgb(72,137, 64));
            text9.setLayoutX(425);
            text9.setLayoutY(695);
            //Defining button:
            button9.setLayoutX(400);
            button9.setLayoutY(525);

            homeCanvas.getChildren().add(text9);

            //Image is changed depending on which plant type hs been selected:
            if(plantTypeIndex == 0) { //flower
                image.setImage(new Image("flower.png"));
                image.setFitHeight(141);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 1) { //succulent
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(142);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 2) { //herb
                image.setImage(new Image("herb.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 3) { //fruit
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 4) { //tree
                image.setImage(new Image("tree.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 5) { //fern
                image.setImage(new Image("fern.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            }
            else if(plantTypeIndex == 6) { //other
                image.setImage(new Image("other.png"));
                image.setFitHeight(133);
                image.setPreserveRatio(true);
            }
            button9.setGraphic(image);
        }

        //adds all buttons/plant images to home canvas
        for(int i = 0; i < correspondingButtonArrayList.size(); i++) {
            homeCanvas.getChildren().add(correspondingButtonArrayList.get(i));
        }
        plantCounter++; //counts how many plants have been created so we know where the plant should appear on screen

    }

    /**
     * The changePlant() method redraws the plant on the home scene according to the new data the user has entered
     * Allows user to fix any mistakes they made entering original data
     * Change plant button is found in specific plant scene
     *
     * @param name Name data, entered by user
     * @param species Species data, entered by user
     * @param plantTypeIndex Indicates which plant user chose from drop down list
     * @param waterRequirements Water data, entered by user
     * @param plantNumber Identifies which plant is being changed
     * @author Keelin Saranchuk
     */
    public void changePlant(String name, String species, int plantTypeIndex, int waterRequirements, int plantNumber) {
        if (plantNumber == 1) { //if plant identificator is 1, identity changes based on which plant the user is currently viewing
            ImageView image = new ImageView();
            //Defines new plant parameters and new plant name text:
            text1.setText(name);
            plant1.setName(name);
            plant1.setSpecies(species);
            plant1.setPlantTypeIndex(plantTypeIndex);
            plant1.setWaterReq(waterRequirements);
            plant1.setPlantID(plantNumber);

            //Image is changed depending on which plant type hs been selected:
            if (plantTypeIndex == 0) {
                image.setImage(new Image("flower.png"));
                image.setFitHeight(141);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 1) {
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(142);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 2) {
                image.setImage(new Image("herb.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 3) {
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 4) {
                image.setImage(new Image("tree.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 5) {
                image.setImage(new Image("fern.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 6) {
                image.setImage(new Image("other.png"));
                image.setFitHeight(133);
                image.setPreserveRatio(true);
            }
            button1.setGraphic(image);
        }

        if (plantNumber == 2) { //if plant identificator is 2, identity changes based on which plant the user is currently viewing
            ImageView image = new ImageView();
            //Defines new plant parameters and new plant name text:
            text2.setText(name);
            plant2.setName(name);
            plant2.setSpecies(species);
            plant2.setPlantTypeIndex(plantTypeIndex);
            plant2.setWaterReq(waterRequirements);
            plant2.setPlantID(plantNumber);

            //Image is changed depending on which plant type hs been selected:
            if (plantTypeIndex == 0) {
                image.setImage(new Image("flower.png"));
                image.setFitHeight(141);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 1) {
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(142);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 2) {
                image.setImage(new Image("herb.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 3) {
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 4) {
                image.setImage(new Image("tree.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 5) {
                image.setImage(new Image("fern.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 6) {
                image.setImage(new Image("other.png"));
                image.setFitHeight(133);
                image.setPreserveRatio(true);
            }
            button2.setGraphic(image);
        }

        if (plantNumber == 3) { //if plant identificator is 3, identity changes based on which plant the user is currently viewing
            ImageView image = new ImageView();
            //Defines new plant parameters and new plant name text:
            text3.setText(name);
            plant3.setName(name);
            plant3.setSpecies(species);
            plant3.setPlantTypeIndex(plantTypeIndex);
            plant3.setWaterReq(waterRequirements);
            plant3.setPlantID(plantNumber);

            //Image is changed depending on which plant type hs been selected:
            if (plantTypeIndex == 0) {
                image.setImage(new Image("flower.png"));
                image.setFitHeight(141);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 1) {
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(142);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 2) {
                image.setImage(new Image("herb.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 3) {
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 4) {
                image.setImage(new Image("tree.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 5) {
                image.setImage(new Image("fern.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 6) {
                image.setImage(new Image("other.png"));
                image.setFitHeight(133);
                image.setPreserveRatio(true);
            }
            button3.setGraphic(image);
        }

        if (plantNumber == 4) { //if plant identificator is 4, identity changes based on which plant the user is currently viewing
            ImageView image = new ImageView();
            //Defines new plant parameters and new plant name text:
            text4.setText(name);
            plant4.setName(name);
            plant4.setSpecies(species);
            plant4.setPlantTypeIndex(plantTypeIndex);
            plant4.setWaterReq(waterRequirements);
            plant4.setPlantID(plantNumber);

            //Image is changed depending on which plant type hs been selected:
            if (plantTypeIndex == 0) {
                image.setImage(new Image("flower.png"));
                image.setFitHeight(141);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 1) {
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(142);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 2) {
                image.setImage(new Image("herb.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 3) {
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 4) {
                image.setImage(new Image("tree.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 5) {
                image.setImage(new Image("fern.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 6) {
                image.setImage(new Image("other.png"));
                image.setFitHeight(133);
                image.setPreserveRatio(true);
            }
            button4.setGraphic(image);
        }

        if (plantNumber == 5) { //if plant identificator is 5, identity changes based on which plant the user is currently viewing
            ImageView image = new ImageView();
            //Defines new plant parameters and new plant name text:
            text5.setText(name);
            plant5.setName(name);
            plant5.setSpecies(species);
            plant5.setPlantTypeIndex(plantTypeIndex);
            plant5.setWaterReq(waterRequirements);
            plant5.setPlantID(plantNumber);

            //Image is changed depending on which plant type hs been selected:
            if (plantTypeIndex == 0) {
                image.setImage(new Image("flower.png"));
                image.setFitHeight(141);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 1) {
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(142);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 2) {
                image.setImage(new Image("herb.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 3) {
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 4) {
                image.setImage(new Image("tree.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 5) {
                image.setImage(new Image("fern.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 6) {
                image.setImage(new Image("other.png"));
                image.setFitHeight(133);
                image.setPreserveRatio(true);
            }
            button5.setGraphic(image);
        }

        if (plantNumber == 6) { //if plant identificator is 6, identity changes based on which plant the user is currently viewing
            ImageView image = new ImageView();
            //Defines new plant parameters and new plant name text:
            text6.setText(name);
            plant6.setName(name);
            plant6.setSpecies(species);
            plant6.setPlantTypeIndex(plantTypeIndex);
            plant6.setWaterReq(waterRequirements);
            plant6.setPlantID(plantNumber);

            //Image is changed depending on which plant type hs been selected:
            if (plantTypeIndex == 0) {
                image.setImage(new Image("flower.png"));
                image.setFitHeight(141);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 1) {
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(142);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 2) {
                image.setImage(new Image("herb.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 3) {
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 4) {
                image.setImage(new Image("tree.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 5) {
                image.setImage(new Image("fern.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 6) {
                image.setImage(new Image("other.png"));
                image.setFitHeight(133);
                image.setPreserveRatio(true);
            }
            button6.setGraphic(image);
        }

        if (plantNumber == 7) { //if plant identificator is 7, identity changes based on which plant the user is currently viewing
            ImageView image = new ImageView();
            //Defines new plant parameters and new plant name text:
            text7.setText(name);
            plant7.setName(name);
            plant7.setSpecies(species);
            plant7.setPlantTypeIndex(plantTypeIndex);
            plant7.setWaterReq(waterRequirements);
            plant7.setPlantID(plantNumber);

            //Image is changed depending on which plant type hs been selected:
            if (plantTypeIndex == 0) {
                image.setImage(new Image("flower.png"));
                image.setFitHeight(141);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 1) {
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(142);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 2) {
                image.setImage(new Image("herb.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 3) {
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 4) {
                image.setImage(new Image("tree.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 5) {
                image.setImage(new Image("fern.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 6) {
                image.setImage(new Image("other.png"));
                image.setFitHeight(133);
                image.setPreserveRatio(true);
            }
            button7.setGraphic(image);
        }

        if (plantNumber == 8) { //if plant identificator is 8, identity changes based on which plant the user is currently viewing
            ImageView image = new ImageView();
            //Defines new plant parameters and new plant name text:
            text8.setText(name);
            plant8.setName(name);
            plant8.setSpecies(species);
            plant8.setPlantTypeIndex(plantTypeIndex);
            plant8.setWaterReq(waterRequirements);
            plant8.setPlantID(plantNumber);

            //Image is changed depending on which plant type hs been selected:
            if (plantTypeIndex == 0) {
                image.setImage(new Image("flower.png"));
                image.setFitHeight(141);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 1) {
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(142);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 2) {
                image.setImage(new Image("herb.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 3) {
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 4) {
                image.setImage(new Image("tree.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 5) {
                image.setImage(new Image("fern.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 6) {
                image.setImage(new Image("other.png"));
                image.setFitHeight(133);
                image.setPreserveRatio(true);
            }
            button8.setGraphic(image);
        }

        if (plantNumber == 9) { //if plant identificator is 9, identity changes based on which plant the user is currently viewing
            ImageView image = new ImageView();
            //Defines new plant parameters and new plant name text:
            text9.setText(name);
            plant9.setName(name);
            plant9.setSpecies(species);
            plant9.setPlantTypeIndex(plantTypeIndex);
            plant9.setWaterReq(waterRequirements);
            plant9.setPlantID(plantNumber);

            //Image is changed depending on which plant type hs been selected:
            if (plantTypeIndex == 0) {
                image.setImage(new Image("flower.png"));
                image.setFitHeight(141);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 1) {
                image.setImage(new Image("succulent.png"));
                image.setFitHeight(142);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 2) {
                image.setImage(new Image("herb.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 3) {
                image.setImage(new Image("fruit.png"));
                image.setFitHeight(135);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 4) {
                image.setImage(new Image("tree.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 5) {
                image.setImage(new Image("fern.png"));
                image.setFitHeight(138);
                image.setPreserveRatio(true);
            } else if (plantTypeIndex == 6) {
                image.setImage(new Image("other.png"));
                image.setFitHeight(133);
                image.setPreserveRatio(true);
            }
            button9.setGraphic(image);
        }
    }

    /**
     * The findPlantTypeIndex() method takes in the plant type, selected by user in drop down list, and returns its index in array
     * Method created because it works better for Laura in terms of comparisons
     *
     * @author Keelin Saranchuk
     */
    public int findPlantTypeIndex(String plantType) {
        int returnCount = 0; //initializing integer to be returned
        for(int count = 0; count < plantTypeCompareArray.length; count++) {
            if(plantType.compareTo(plantTypeCompareArray[count]) == 0) { //if the input matches an element of the plant type array
                returnCount = count; //return current index
            }
        }
        return returnCount;
    }

    /**
     * The sortingPlants() method takes in a sorted the plant array
     * Changes coordinated of plants according to their new order
     *
     * @author Keelin Saranchuk
     */
    public void sortingPlants() {
        for(int i = 0; i < sortedPlantArrayList.size(); i++) { //for sorted plant array length
            if(i == 0) { //when at index 0
                //get plant at that index (which plant matches plant at that index):
                if (sortedPlantArrayList.get(i) == plant1) {
                    //change coordinates of text and button:
                    text1.setLayoutX(75);
                    text1.setLayoutY(290);
                    button1.setLayoutX(50);
                    button1.setLayoutY(120);
                }
                else if (sortedPlantArrayList.get(i) == plant2) {
                    //change coordinates of text and button:
                    text2.setLayoutX(75);
                    text2.setLayoutY(290);
                    button2.setLayoutX(50);
                    button2.setLayoutY(120);
                }
                else if (sortedPlantArrayList.get(i) == plant3) {
                    //change coordinates of text and button:
                    text3.setLayoutX(75);
                    text3.setLayoutY(290);
                    button3.setLayoutX(50);
                    button3.setLayoutY(120);
                }
                else if (sortedPlantArrayList.get(i) == plant4) {
                    //change coordinates of text and button:
                    text4.setLayoutX(75);
                    text4.setLayoutY(290);
                    button4.setLayoutX(50);
                    button4.setLayoutY(120);
                }
                else if (sortedPlantArrayList.get(i) == plant5) {
                    //change coordinates of text and button:
                    text5.setLayoutX(75);
                    text5.setLayoutY(290);
                    button5.setLayoutX(50);
                    button5.setLayoutY(120);
                }
                else if (sortedPlantArrayList.get(i) == plant6) {
                    //change coordinates of text and button:
                    text6.setLayoutX(75);
                    text6.setLayoutY(290);
                    button6.setLayoutX(50);
                    button6.setLayoutY(120);
                }
                else if (sortedPlantArrayList.get(i) == plant7) {
                    //change coordinates of text and button:
                    text7.setLayoutX(75);
                    text7.setLayoutY(290);
                    button7.setLayoutX(50);
                    button7.setLayoutY(120);
                }
                else if (sortedPlantArrayList.get(i) == plant8) {
                    //change coordinates of text and button:
                    text8.setLayoutX(75);
                    text8.setLayoutY(290);
                    button8.setLayoutX(50);
                    button8.setLayoutY(120);
                }
                else if (sortedPlantArrayList.get(i) == plant9) {
                    //change coordinates of text and button:
                    text9.setLayoutX(75);
                    text9.setLayoutY(290);
                    button9.setLayoutX(50);
                    button9.setLayoutY(120);
                }
            }
            else if(i == 1) { //when at index 1
                //get plant at that index (which plant matches plant at that index):
                if (sortedPlantArrayList.get(i) == plant1) {
                    //change coordinates of text and button:
                    button1.setLayoutX(225);
                    button1.setLayoutY(120);
                    text1.setLayoutX(250);
                    text1.setLayoutY(290);
                }
                else if (sortedPlantArrayList.get(i) == plant2) {
                    //change coordinates of text and button:
                    button2.setLayoutX(225);
                    button2.setLayoutY(120);
                    text2.setLayoutX(250);
                    text2.setLayoutY(290);
                }
                else if (sortedPlantArrayList.get(i) == plant3) {
                    //change coordinates of text and button:
                    button3.setLayoutX(225);
                    button3.setLayoutY(120);
                    text3.setLayoutX(250);
                    text3.setLayoutY(290);
                }
                else if (sortedPlantArrayList.get(i) == plant4) {
                    //change coordinates of text and button:
                    button4.setLayoutX(225);
                    button4.setLayoutY(120);
                    text4.setLayoutX(250);
                    text4.setLayoutY(290);
                }
                else if (sortedPlantArrayList.get(i) == plant5) {
                    //change coordinates of text and button:
                    button5.setLayoutX(225);
                    button5.setLayoutY(120);
                    text5.setLayoutX(250);
                    text5.setLayoutY(290);
                }
                else if (sortedPlantArrayList.get(i) == plant6) {
                    //change coordinates of text and button:
                    button6.setLayoutX(225);
                    button6.setLayoutY(120);
                    text6.setLayoutX(250);
                    text6.setLayoutY(290);
                }
                else if (sortedPlantArrayList.get(i) == plant7) {
                    //change coordinates of text and button:
                    button7.setLayoutX(225);
                    button7.setLayoutY(120);
                    text7.setLayoutX(250);
                    text7.setLayoutY(290);
                }
                else if (sortedPlantArrayList.get(i) == plant8) {
                    //change coordinates of text and button:
                    button8.setLayoutX(225);
                    button8.setLayoutY(120);
                    text8.setLayoutX(250);
                    text8.setLayoutY(290);
                }
                else if (sortedPlantArrayList.get(i) == plant9) {
                    //change coordinates of text and button:
                    button9.setLayoutX(225);
                    button9.setLayoutY(120);
                    text9.setLayoutX(250);
                    text9.setLayoutY(290);
                }
            }
            else if(i == 2) { //when at index 2
                //get plant at that index (which plant matches plant at that index):
                if (sortedPlantArrayList.get(i) == plant1) {
                    //change coordinates of text and button:
                    button1.setLayoutX(400);
                    button1.setLayoutY(120);
                    text1.setLayoutX(425);
                    text1.setLayoutY(290);
                }
                else if (sortedPlantArrayList.get(i) == plant2) {
                    //change coordinates of text and button:
                    button2.setLayoutX(400);
                    button2.setLayoutY(120);
                    text2.setLayoutX(425);
                    text2.setLayoutY(290);
                }
                else if (sortedPlantArrayList.get(i) == plant3) {
                    //change coordinates of text and button:
                    button3.setLayoutX(400);
                    button3.setLayoutY(120);
                    text3.setLayoutX(425);
                    text3.setLayoutY(290);
                }
                else if (sortedPlantArrayList.get(i) == plant4) {
                    //change coordinates of text and button:
                    button4.setLayoutX(400);
                    button4.setLayoutY(120);
                    text4.setLayoutX(425);
                    text4.setLayoutY(290);
                }
                else if (sortedPlantArrayList.get(i) == plant5) {
                    //change coordinates of text and button:
                    button5.setLayoutX(400);
                    button5.setLayoutY(120);
                    text5.setLayoutX(425);
                    text5.setLayoutY(290);
                }
                else if (sortedPlantArrayList.get(i) == plant6) {
                    //change coordinates of text and button:
                    button6.setLayoutX(400);
                    button6.setLayoutY(120);
                    text6.setLayoutX(425);
                    text6.setLayoutY(290);
                }
                else if (sortedPlantArrayList.get(i) == plant7) {
                    //change coordinates of text and button:
                    button7.setLayoutX(400);
                    button7.setLayoutY(120);
                    text7.setLayoutX(425);
                    text7.setLayoutY(290);
                }
                else if (sortedPlantArrayList.get(i) == plant8) {
                    //change coordinates of text and button:
                    button8.setLayoutX(400);
                    button8.setLayoutY(120);
                    text8.setLayoutX(425);
                    text8.setLayoutY(290);
                }
                else if (sortedPlantArrayList.get(i) == plant9) {
                    //change coordinates of text and button:
                    button9.setLayoutX(400);
                    button9.setLayoutY(120);
                    text9.setLayoutX(425);
                    text9.setLayoutY(290);
                }
            }
            else if(i == 3) { //when at index 3
                //get plant at that index (which plant matches plant at that index):
                if (sortedPlantArrayList.get(i) == plant1) {
                    //change coordinates of text and button:
                    button1.setLayoutX(50);
                    button1.setLayoutY(320);
                    text1.setLayoutX(75);
                    text1.setLayoutY(490);
                }
                else if (sortedPlantArrayList.get(i) == plant2) {
                    //change coordinates of text and button:
                    button2.setLayoutX(50);
                    button2.setLayoutY(320);
                    text2.setLayoutX(75);
                    text2.setLayoutY(490);
                }
                else if (sortedPlantArrayList.get(i) == plant3) {
                    //change coordinates of text and button:
                    button3.setLayoutX(50);
                    button3.setLayoutY(320);
                    text3.setLayoutX(75);
                    text3.setLayoutY(490);
                }
                else if (sortedPlantArrayList.get(i) == plant4) {
                    //change coordinates of text and button:
                    button4.setLayoutX(50);
                    button4.setLayoutY(320);
                    text4.setLayoutX(75);
                    text4.setLayoutY(490);
                }
                else if (sortedPlantArrayList.get(i) == plant5) {
                    //change coordinates of text and button:
                    button5.setLayoutX(50);
                    button5.setLayoutY(320);
                    text5.setLayoutX(75);
                    text5.setLayoutY(490);
                }
                else if (sortedPlantArrayList.get(i) == plant6) {
                    //change coordinates of text and button:
                    button6.setLayoutX(50);
                    button6.setLayoutY(320);
                    text6.setLayoutX(75);
                    text6.setLayoutY(490);
                }
                else if (sortedPlantArrayList.get(i) == plant7) {
                    //change coordinates of text and button:
                    button7.setLayoutX(50);
                    button7.setLayoutY(320);
                    text7.setLayoutX(75);
                    text7.setLayoutY(490);
                }
                else if (sortedPlantArrayList.get(i) == plant8) {
                    //change coordinates of text and button:
                    button8.setLayoutX(50);
                    button8.setLayoutY(320);
                    text8.setLayoutX(75);
                    text8.setLayoutY(490);
                }
                else if (sortedPlantArrayList.get(i) == plant9) {
                    //change coordinates of text and button:
                    button9.setLayoutX(50);
                    button9.setLayoutY(320);
                    text9.setLayoutX(75);
                    text9.setLayoutY(490);
                }
            }
            else if(i == 4) { //when at index 4
                //get plant at that index (which plant matches plant at that index):
                if (sortedPlantArrayList.get(i) == plant1) {
                    //change coordinates of text and button:
                    button1.setLayoutX(225);
                    button1.setLayoutY(320);
                    text1.setLayoutX(250);
                    text1.setLayoutY(490);
                }
                else if (sortedPlantArrayList.get(i) == plant2) {
                    //change coordinates of text and button:
                    button2.setLayoutX(225);
                    button2.setLayoutY(320);
                    text2.setLayoutX(250);
                    text2.setLayoutY(490);
                }
                else if (sortedPlantArrayList.get(i) == plant3) {
                    //change coordinates of text and button:
                    button3.setLayoutX(225);
                    button3.setLayoutY(320);
                    text3.setLayoutX(250);
                    text3.setLayoutY(490);
                }
                else if (sortedPlantArrayList.get(i) == plant4) {
                    //change coordinates of text and button:
                    button4.setLayoutX(225);
                    button4.setLayoutY(320);
                    text4.setLayoutX(250);
                    text4.setLayoutY(490);
                }
                else if (sortedPlantArrayList.get(i) == plant5) {
                    //change coordinates of text and button:
                    button5.setLayoutX(225);
                    button5.setLayoutY(320);
                    text5.setLayoutX(250);
                    text5.setLayoutY(490);
                }
                else if (sortedPlantArrayList.get(i) == plant6) {
                    //change coordinates of text and button:
                    button6.setLayoutX(225);
                    button6.setLayoutY(320);
                    text6.setLayoutX(250);
                    text6.setLayoutY(490);
                }
                else if (sortedPlantArrayList.get(i) == plant7) {
                    //change coordinates of text and button:
                    button7.setLayoutX(225);
                    button7.setLayoutY(320);
                    text7.setLayoutX(250);
                    text7.setLayoutY(490);
                }
                else if (sortedPlantArrayList.get(i) == plant8) {
                    //change coordinates of text and button:
                    button8.setLayoutX(225);
                    button8.setLayoutY(320);
                    text8.setLayoutX(250);
                    text8.setLayoutY(490);
                }
                else if (sortedPlantArrayList.get(i) == plant9) {
                    //change coordinates of text and button:
                    button9.setLayoutX(225);
                    button9.setLayoutY(320);
                    text9.setLayoutX(250);
                    text9.setLayoutY(490);
                }
            }
            else if(i == 5) { //when at index 5
                //get plant at that index (which plant matches plant at that index):
                if (sortedPlantArrayList.get(i) == plant1) {
                    //change coordinates of text and button:
                    button1.setLayoutX(400);
                    button1.setLayoutY(320);
                    text1.setLayoutX(425);
                    text1.setLayoutY(490);
                }
                else if (sortedPlantArrayList.get(i) == plant2) {
                    //change coordinates of text and button:
                    button2.setLayoutX(400);
                    button2.setLayoutY(320);
                    text2.setLayoutX(425);
                    text2.setLayoutY(490);
                }
                else if (sortedPlantArrayList.get(i) == plant3) {
                    //change coordinates of text and button:
                    button3.setLayoutX(400);
                    button3.setLayoutY(320);
                    text3.setLayoutX(425);
                    text3.setLayoutY(490);
                }
                else if (sortedPlantArrayList.get(i) == plant4) {
                    //change coordinates of text and button:
                    button4.setLayoutX(400);
                    button4.setLayoutY(320);
                    text4.setLayoutX(425);
                    text4.setLayoutY(490);
                }
                else if (sortedPlantArrayList.get(i) == plant5) {
                    //change coordinates of text and button:
                    button5.setLayoutX(400);
                    button5.setLayoutY(320);
                    text5.setLayoutX(425);
                    text5.setLayoutY(490);
                }
                else if (sortedPlantArrayList.get(i) == plant6) {
                    //change coordinates of text and button:
                    button6.setLayoutX(400);
                    button6.setLayoutY(320);
                    text6.setLayoutX(425);
                    text6.setLayoutY(490);
                }
                else if (sortedPlantArrayList.get(i) == plant7) {
                    //change coordinates of text and button:
                    button7.setLayoutX(400);
                    button7.setLayoutY(320);
                    text7.setLayoutX(425);
                    text7.setLayoutY(490);
                }
                else if (sortedPlantArrayList.get(i) == plant8) {
                    //change coordinates of text and button:
                    button8.setLayoutX(400);
                    button8.setLayoutY(320);
                    text8.setLayoutX(425);
                    text8.setLayoutY(490);
                }
                else if (sortedPlantArrayList.get(i) == plant9) {
                    //change coordinates of text and button:
                    button9.setLayoutX(400);
                    button9.setLayoutY(320);
                    text9.setLayoutX(425);
                    text9.setLayoutY(490);
                }
            }
            else if(i == 6) { //when at index 6
                //get plant at that index (which plant matches plant at that index):
                if (sortedPlantArrayList.get(i) == plant1) {
                    //change coordinates of text and button:
                    button1.setLayoutX(50);
                    button1.setLayoutY(525);
                    text1.setLayoutX(75);
                    text1.setLayoutY(695);
                }
                else if (sortedPlantArrayList.get(i) == plant2) {
                    //change coordinates of text and button:
                    button2.setLayoutX(50);
                    button2.setLayoutY(525);
                    text2.setLayoutX(75);
                    text2.setLayoutY(695);
                }
                else if (sortedPlantArrayList.get(i) == plant3) {
                    //change coordinates of text and button:
                    button3.setLayoutX(50);
                    button3.setLayoutY(525);
                    text3.setLayoutX(75);
                    text3.setLayoutY(695);
                }
                else if (sortedPlantArrayList.get(i) == plant4) {
                    //change coordinates of text and button:
                    button4.setLayoutX(50);
                    button4.setLayoutY(525);
                    text4.setLayoutX(75);
                    text4.setLayoutY(695);
                }
                else if (sortedPlantArrayList.get(i) == plant5) {
                    //change coordinates of text and button:
                    button5.setLayoutX(50);
                    button5.setLayoutY(525);
                    text5.setLayoutX(75);
                    text5.setLayoutY(695);
                }
                else if (sortedPlantArrayList.get(i) == plant6) {
                    //change coordinates of text and button:
                    button6.setLayoutX(50);
                    button6.setLayoutY(525);
                    text6.setLayoutX(75);
                    text6.setLayoutY(695);
                }
                else if (sortedPlantArrayList.get(i) == plant7) {
                    //change coordinates of text and button:
                    button7.setLayoutX(50);
                    button7.setLayoutY(525);
                    text7.setLayoutX(75);
                    text7.setLayoutY(695);
                }
                else if (sortedPlantArrayList.get(i) == plant8) {
                    //change coordinates of text and button:
                    button8.setLayoutX(50);
                    button8.setLayoutY(525);
                    text8.setLayoutX(75);
                    text8.setLayoutY(695);
                }
                else if (sortedPlantArrayList.get(i) == plant9) {
                    //change coordinates of text and button:
                    button9.setLayoutX(50);
                    button9.setLayoutY(525);
                    text9.setLayoutX(75);
                    text9.setLayoutY(695);
                }
            }
            else if(i == 7) { //when at index 7
                //get plant at that index (which plant matches plant at that index):
                if (sortedPlantArrayList.get(i) == plant1) {
                    //change coordinates of text and button:
                    button1.setLayoutX(225);
                    button1.setLayoutY(525);
                    text1.setLayoutX(250);
                    text1.setLayoutY(695);
                }
                else if (sortedPlantArrayList.get(i) == plant2) {
                    //change coordinates of text and button:
                    button2.setLayoutX(225);
                    button2.setLayoutY(525);
                    text2.setLayoutX(250);
                    text2.setLayoutY(695);
                }
                else if (sortedPlantArrayList.get(i) == plant3) {
                    //change coordinates of text and button:
                    button3.setLayoutX(225);
                    button3.setLayoutY(525);
                    text3.setLayoutX(250);
                    text3.setLayoutY(695);
                }
                else if (sortedPlantArrayList.get(i) == plant4) {
                    //change coordinates of text and button:
                    button4.setLayoutX(225);
                    button4.setLayoutY(525);
                    text4.setLayoutX(250);
                    text4.setLayoutY(695);
                }
                else if (sortedPlantArrayList.get(i) == plant5) {
                    //change coordinates of text and button:
                    button5.setLayoutX(225);
                    button5.setLayoutY(525);
                    text5.setLayoutX(250);
                    text5.setLayoutY(695);
                }
                else if (sortedPlantArrayList.get(i) == plant6) {
                    //change coordinates of text and button:
                    button6.setLayoutX(225);
                    button6.setLayoutY(525);
                    text6.setLayoutX(250);
                    text6.setLayoutY(695);
                }
                else if (sortedPlantArrayList.get(i) == plant7) {
                    //change coordinates of text and button:
                    button7.setLayoutX(225);
                    button7.setLayoutY(525);
                    text7.setLayoutX(250);
                    text7.setLayoutY(695);
                }
                else if (sortedPlantArrayList.get(i) == plant8) {
                    //change coordinates of text and button:
                    button8.setLayoutX(225);
                    button8.setLayoutY(525);
                    text8.setLayoutX(250);
                    text8.setLayoutY(695);
                }
                else if (sortedPlantArrayList.get(i) == plant9) {
                    //change coordinates of text and button:
                    button9.setLayoutX(225);
                    button9.setLayoutY(525);
                    text9.setLayoutX(250);
                    text9.setLayoutY(695);
                }
            }
            else if(i == 8) { //when at index 8
                //get plant at that index (which plant matches plant at that index):
                if (sortedPlantArrayList.get(i) == plant1) {
                    //change coordinates of text and button:
                    button1.setLayoutX(400);
                    button1.setLayoutY(525);
                    text1.setLayoutX(425);
                    text1.setLayoutY(695);
                }
                else if (sortedPlantArrayList.get(i) == plant2) {
                    //change coordinates of text and button:
                    button2.setLayoutX(400);
                    button2.setLayoutY(525);
                    text2.setLayoutX(425);
                    text2.setLayoutY(695);
                }
                else if (sortedPlantArrayList.get(i) == plant3) {
                    //change coordinates of text and button:
                    button3.setLayoutX(400);
                    button3.setLayoutY(525);
                    text3.setLayoutX(425);
                    text3.setLayoutY(695);
                }
                else if (sortedPlantArrayList.get(i) == plant4) {
                    //change coordinates of text and button:
                    button4.setLayoutX(400);
                    button4.setLayoutY(525);
                    text4.setLayoutX(425);
                    text4.setLayoutY(695);
                }
                else if (sortedPlantArrayList.get(i) == plant5) {
                    //change coordinates of text and button:
                    button5.setLayoutX(400);
                    button5.setLayoutY(525);
                    text5.setLayoutX(425);
                    text5.setLayoutY(695);
                }
                else if (sortedPlantArrayList.get(i) == plant6) {
                    //change coordinates of text and button:
                    button6.setLayoutX(400);
                    button6.setLayoutY(525);
                    text6.setLayoutX(425);
                    text6.setLayoutY(695);
                }
                else if (sortedPlantArrayList.get(i) == plant7) {
                    //change coordinates of text and button:
                    button7.setLayoutX(400);
                    button7.setLayoutY(525);
                    text7.setLayoutX(425);
                    text7.setLayoutY(695);
                }
                else if (sortedPlantArrayList.get(i) == plant8) {
                    //change coordinates of text and button:
                    button8.setLayoutX(400);
                    button8.setLayoutY(525);
                    text8.setLayoutX(425);
                    text8.setLayoutY(695);
                }
                else if (sortedPlantArrayList.get(i) == plant9) {
                    //change coordinates of text and button:
                    button9.setLayoutX(400);
                    button9.setLayoutY(525);
                    text9.setLayoutX(425);
                    text9.setLayoutY(695);
                }
            }
        }
    }

}

