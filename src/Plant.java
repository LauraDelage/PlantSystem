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
    private String plantName;
    private String plantSpecies;
    private String plantType;
    private String plantTypeInfoString;
    int waterReq;   //plant's water requirements (% moisture of soil)
    int currWaterVal; //current % moisture in soil
    int waterNeeded; //% of water currently required to meet the waterReq
    int plantID;
    int plantIndex;
    ArrayList<Date> waterDates = new ArrayList<>();
    ArrayList<Integer> waterLevels = new ArrayList<>();
    Text name = new Text();
    Text species = new Text();
    Text info = new Text();
    Text plantTypeDraw = new Text();
    Text waterReqDraw = new Text();
    Text waterCurrDraw = new Text();
    Text waterNeededDraw = new Text();
    CircuitBoardConnection board = new CircuitBoardConnection();


    Plant(String name, String species, int plantTypeIndex, int waterRequirements, int ID) {
        plantIndex = plantTypeIndex;
        plantID = ID;
        plantName = name;
        plantSpecies = species;
        plantType = Global.plantTypeCompareArray[plantTypeIndex];
        plantTypeInfoString = Global.plantTypeInfo[plantTypeIndex];
        waterReq = waterRequirements;
        board.generate();
        board.read();
        waterLevels = board.getArray();
        currWaterVal = waterLevels.get(waterLevels.size() - 1);
    }


    public void drawPlant(Pane canvas, Plant plant) {
        Font buttonFont = new Font("Impact", 20); //Impact

        canvas.setStyle("-fx-background-color: white;");
        Font bigFont = new Font("Impact", 30);
        Font smallFont = new Font("Impact", 20);
        name.setText(plant.getName());
        name.setLayoutX(30);
        name.setLayoutY(50);
        name.setFill(Color.rgb(153, 255, 102));
        name.setStroke(Color.rgb(51, 153, 51));
        name.setStrokeWidth(2);
        name.setFont(bigFont);

        info.setText(plantTypeInfo[plant.getIndex()]);
        info.setLayoutX(30);
        info.setLayoutY(250);
        info.setFill(Color.rgb(51, 153, 51));
        info.setFont(smallFont);

        species.setText("Species: " + plant.getSpecies());
        species.setLayoutX(30);
        species.setLayoutY(90);
        species.setFill(Color.rgb(51, 153, 51));
        species.setFont(smallFont);

        plantTypeDraw.setText("Type: " + plant.getType());
        plantTypeDraw.setLayoutX(30);
        plantTypeDraw.setLayoutY(115);
        plantTypeDraw.setFill(Color.rgb(51, 153, 51));
        plantTypeDraw.setFont(smallFont);

        waterReqDraw.setText("Water Requirements: " + plant.getWaterReq());
        waterReqDraw.setLayoutX(30);
        waterReqDraw.setLayoutY(150);
        waterReqDraw.setFill(Color.rgb(51, 153, 51));
        waterReqDraw.setFont(smallFont);

        waterCurrDraw.setText("Current water level: " + plant.getCurrWaterVal());
        waterCurrDraw.setLayoutX(30);
        waterCurrDraw.setLayoutY(175);
        waterCurrDraw.setFill(Color.rgb(51, 153, 51));
        waterCurrDraw.setFont(smallFont);

        waterNeededDraw.setText("Water needed: " + plant.calcWaterNeeded());
        waterNeededDraw.setLayoutX(30);
        waterNeededDraw.setLayoutY(200);
        waterNeededDraw.setFill(Color.rgb(51, 153, 51));
        waterNeededDraw.setFont(smallFont);

        returnToHome.setStyle("-fx-background-color: #488940");
        returnToHome.setLayoutX(805);
        returnToHome.setLayoutY(20);
        returnToHome.setTextFill(Color.WHITE);
        returnToHome.setFont(buttonFont);

        deletePlant.setStyle("-fx-background-color: #488940");
        deletePlant.setLayoutX(630);
        deletePlant.setLayoutY(20);
        deletePlant.setTextFill(Color.WHITE);
        deletePlant.setFont(buttonFont);

        editPlant.setStyle("-fx-background-color: #488940");
        editPlant.setLayoutX(460);
        editPlant.setLayoutY(20);
        editPlant.setTextFill(Color.WHITE);
        editPlant.setFont(buttonFont);

        canvas.getChildren().addAll(name, species, plantTypeDraw, waterReqDraw, waterCurrDraw, waterNeededDraw, info, returnToHome, deletePlant, editPlant);
    }

    public void removePlant(Pane canvas, Plant plant) {
        canvas.getChildren().removeAll(name, species, plantTypeDraw, waterReqDraw, waterCurrDraw, waterNeededDraw, info, returnToHome, deletePlant, editPlant);
    }

    public int getIndex() { return plantIndex;}

    public int getPlantID() {
        return plantID;
    }

    public String getName() {
        return plantName;
    }

    public void setName(String name) {
        plantName = name;
    }

    public String getSpecies() {
        return plantSpecies;
    }

    public void setSpecies(String species) { plantSpecies = species; }

    public String getType() {
        return plantType;
    }

    public void setPlantTypeIndex(int plantIndexOfType) {
        String tempType = Global.plantTypeCompareArray[plantIndexOfType];
        plantType = tempType;
    }

    public String getInfo() {
        return plantTypeInfoString;
    }

    public int getWaterReq() {
        return waterReq;
    }

    public void setWaterReq(int water) {waterReq = water;}

    public void setPlantID(int identity) {plantID = identity;}

    public int getCurrWaterVal() {return currWaterVal;}

    public void setCurrWaterVal(int waterVal) {currWaterVal = waterVal;}

    public int calcWaterNeeded() {
        waterNeeded = waterReq - currWaterVal;
        return waterNeeded;
    }

    public void hasBeenWatered() {
        //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        //waterDates.add(formatter.format(date));
        waterDates.add(date);
    }

    public ArrayList<Date> getWaterDates() {
        return waterDates;
    }

}


// remove plant
// sort plant