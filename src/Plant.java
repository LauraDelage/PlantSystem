import java.util.ArrayList;
import java.util.Date;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Plant class
 * Creates the structure for an individual plant object.
 * @author: Laura Delage, Keelin Saranchuk
 * */

public class Plant implements Global{
    private String plantName; //user input of plant name
    private String plantSpecies; //user input of plant species
    private String plantType; //user input of plant type
    private String plantTypeInfoString; //user input, info stored in global class
    int waterReq;   //plant's water requirements (% moisture of soil)
    int currWaterVal; //current % moisture in soil
    int waterNeeded; //% of water currently required to meet the waterReq
    int plantID; //identifies how many plants user has created so far
    int plantIndex; //identifies plant type index
    ArrayList<Date> waterDates = new ArrayList<>();
    ArrayList<Integer> waterLevels = new ArrayList<>();
    //Defining text, to be displayed on each plant's info scene:
    Text name = new Text();
    Text species = new Text();
    Text info = new Text();
    Text plantTypeDraw = new Text();
    Text waterReqDraw = new Text();
    Text waterCurrDraw = new Text();
    Text waterNeededDraw = new Text();
    CircuitBoardConnection board = new CircuitBoardConnection(); //CircuitBoard simulator, delivers data in sets


    Plant(String name, String species, int plantTypeIndex, int waterRequirements, int ID) {
        plantIndex = plantTypeIndex;
        plantID = ID;
        plantName = name;
        plantSpecies = species;
        plantType = Global.plantTypeCompareArray[plantTypeIndex]; //plant type is found using plant index
        plantTypeInfoString = Global.plantTypeInfo[plantTypeIndex]; //information about each plant stored in global class
        waterReq = waterRequirements;
        //when plant is created, current water level is simulated, currWaterVal is the last number given from the set of simulated data
        board.generate();
        board.read();
        waterLevels = board.getArray();
        currWaterVal = waterLevels.get(waterLevels.size() - 1);
    }

    /**
     * The drawPlant() draws a specific plant scene
     * Plant draws itself
     * Has info that includes plant name, plant water levels, plant type and plant species
     *
     * @param canvas Canvas the plant will be added to
     * @param plant Plant we are working with
     * @author Keelin Saranchuk
     */
    public void drawPlant(Pane canvas, Plant plant) {
        Font buttonFont = new Font("Impact", 20); //Impact
        canvas.setStyle("-fx-background-color: white;");
        Font bigFont = new Font("Impact", 30);
        Font smallFont = new Font("Impact", 20);
        //Defining plant name text:
        name.setText(plant.getName());
        name.setLayoutX(30);
        name.setLayoutY(50);
        name.setFill(Color.rgb(153, 255, 102));
        name.setStroke(Color.rgb(51, 153, 51));
        name.setStrokeWidth(2);
        name.setFont(bigFont);
        //Defining plant info text:
        info.setText(plantTypeInfo[plant.getIndex()]); //global array with info about each plant
        info.setLayoutX(30);
        info.setLayoutY(250);
        info.setFill(Color.rgb(51, 153, 51));
        info.setFont(smallFont);
        //Defining plant species text:
        species.setText("Species: " + plant.getSpecies());
        species.setLayoutX(30);
        species.setLayoutY(90);
        species.setFill(Color.rgb(51, 153, 51));
        species.setFont(smallFont);
        //Defining plant type text:
        plantTypeDraw.setText("Type: " + plant.getType());
        plantTypeDraw.setLayoutX(30);
        plantTypeDraw.setLayoutY(115);
        plantTypeDraw.setFill(Color.rgb(51, 153, 51));
        plantTypeDraw.setFont(smallFont);
        //Defining water requirements text:
        waterReqDraw.setText("Water Requirements: " + plant.getWaterReq());
        waterReqDraw.setLayoutX(30);
        waterReqDraw.setLayoutY(150);
        waterReqDraw.setFill(Color.rgb(51, 153, 51));
        waterReqDraw.setFont(smallFont);
        //Getting simulated current water level, defining text:
        waterCurrDraw.setText("Current water level: " + plant.getCurrWaterVal());
        waterCurrDraw.setLayoutX(30);
        waterCurrDraw.setLayoutY(175);
        waterCurrDraw.setFill(Color.rgb(51, 153, 51));
        waterCurrDraw.setFont(smallFont);
        //Calculating the difference between these two water levels, defining text for display:
        waterNeededDraw.setText("Water needed: " + plant.calcWaterNeeded());
        waterNeededDraw.setLayoutX(30);
        waterNeededDraw.setLayoutY(200);
        waterNeededDraw.setFill(Color.rgb(51, 153, 51));
        waterNeededDraw.setFont(smallFont);
        //Defining returnToHome global button:
        returnToHome.setStyle("-fx-background-color: #488940");
        returnToHome.setLayoutX(805);
        returnToHome.setLayoutY(20);
        returnToHome.setTextFill(Color.WHITE);
        returnToHome.setFont(buttonFont);
        //Defining deletePlant global button:
        deletePlant.setStyle("-fx-background-color: #488940");
        deletePlant.setLayoutX(630);
        deletePlant.setLayoutY(20);
        deletePlant.setTextFill(Color.WHITE);
        deletePlant.setFont(buttonFont);
        //Defining editPlant global button:
        editPlant.setStyle("-fx-background-color: #488940");
        editPlant.setLayoutX(460);
        editPlant.setLayoutY(20);
        editPlant.setTextFill(Color.WHITE);
        editPlant.setFont(buttonFont);
        //Adding all elements to canvas:
        canvas.getChildren().addAll(name, species, plantTypeDraw, waterReqDraw, waterCurrDraw, waterNeededDraw, info, returnToHome, deletePlant, editPlant);
    }

    /**
     * The removePlant() method removes all objects from plant scene when called upon
     *
     * @param canvas Canvas the plant will be added to
     * @param plant Plant we are working with
     * @author Keelin Saranchuk
     */
    public void removePlant(Pane canvas, Plant plant) {
        canvas.getChildren().removeAll(name, species, plantTypeDraw, waterReqDraw, waterCurrDraw, waterNeededDraw, info, returnToHome, deletePlant, editPlant);
    }

    /**
     * The getIndex() method returns plant type index
     *
     * @author Laura Delage
     */
    public int getIndex() { return plantIndex;}

    /**
     * The getIndex() method returns plant name
     *
     * @author Laura Delage
     */
    public String getName() {
        return plantName;
    }

    /**
     * The setName() method allows for a new name to be set for the plant
     *
     * @param name new plant name
     * @author Keelin Saranchuk
     */
    public void setName(String name) {
        plantName = name;
    }

    /**
     * The getName() method returns the plant's species
     *
     * @author Laura Delage
     */
    public String getSpecies() {
        return plantSpecies;
    }

    /**
     * The setSpecies() method allows for a new species to be set for the plant
     *
     * @param species new plant species
     * @author Keelin Saranchuk
     */
    public void setSpecies(String species) { plantSpecies = species; }

    /**
     * The getType() method returns the plant's type
     *
     * @author Laura Delage
     */
    public String getType() {
        return plantType;
    }

    /**
     * The setSpecies() method allows for a new plant type index to be set, will adjust plant type accordingly
     *
     * @param plantIndexOfType new plant index
     * @author Keelin Saranchuk
     */
    public void setPlantTypeIndex(int plantIndexOfType) {
        String tempType = Global.plantTypeCompareArray[plantIndexOfType];
        plantType = tempType;
    }

    /**
     * The getWaterReq() method returns the plant's water requirements
     *
     * @author Laura Delage
     */
    public int getWaterReq() {
        return waterReq;
    }

    /**
     * The setWaterReq() allows for new requirements to be set
     *
     * @param water new plant water requirements
     * @author Keelin Saranchuk
     */
    public void setWaterReq(int water) {waterReq = water;}

    /**
     * The setPlantID() allows for a new plant Identity to be set
     *
     * @param identity new plant ID
     * @author Keelin Saranchuk
     */
    public void setPlantID(int identity) {plantID = identity;}

    /**
     * The getCurrWaterVal() returns the plant's current water level
     *
     * @author Laura Delage
     */
    public int getCurrWaterVal() {return currWaterVal;}

    /**
     * The setCurrWaterVal() allows for a new current water level value to be set
     *
     * @param waterVal new current water level of plant
     * @author Keelin Saranchuk
     */
    public void setCurrWaterVal(int waterVal) {currWaterVal = waterVal;}

    /**
     * The calcWaterNeeded() calculates the difference between the plant's current water level and the water needed
     *
     * @author Laura Delage
     */
    public int calcWaterNeeded() {
        waterNeeded = waterReq - currWaterVal;
        return waterNeeded;
    }

    /**
     * The hasBeenWatered() keeps track of the dates the plants were watered
     *
     * @author Laura Delage
     */
    public void hasBeenWatered() {
        //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        //waterDates.add(formatter.format(date));
        waterDates.add(date);
    }

    /**
     * The getWaterDates() returns array list of last watering dates of all plants
     *
     * @author Laura Delage
     */
    public ArrayList<Date> getWaterDates() {
        return waterDates;
    }

}

