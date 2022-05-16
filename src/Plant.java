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



    Plant(String name, String species, int plantTypeIndex, int waterRequirements, int ID) {
        plantIndex = plantTypeIndex;
        plantID = ID;
        plantName = name;
        plantSpecies = species;
        plantType = Global.plantTypeCompareArray[plantTypeIndex];
        plantTypeInfoString = Global.plantTypeInfo[plantTypeIndex];
        waterReq = waterRequirements;
    }


    public void drawPlant(Pane canvas, Plant plant) {
        canvas.setStyle("-fx-background-color: white;");
        Font bigFont = new Font("Impact", 30);
        Font smallFont = new Font("Impact", 20);
        Text name = new Text();
        name.setText(plant.getName());
        name.setLayoutX(30);
        name.setLayoutY(50);
        name.setFill(Color.rgb(153, 255, 102));
        name.setStroke(Color.rgb(51, 153, 51));
        name.setStrokeWidth(2);
        name.setFont(bigFont);

        Text info = new Text();
        info.setText(plantTypeInfo[plant.getIndex()]);
        info.setLayoutX(30);
        info.setLayoutY(250);
        info.setFill(Color.rgb(51, 153, 51));
        info.setFont(smallFont);

        Text species = new Text();
        species.setText("Species: " + plant.getSpecies());
        species.setLayoutX(30);
        species.setLayoutY(90);
        species.setFill(Color.rgb(51, 153, 51));
        species.setFont(smallFont);

        Text plantType = new Text();
        plantType.setText("Type: " + plant.getType());
        plantType.setLayoutX(30);
        plantType.setLayoutY(115);
        plantType.setFill(Color.rgb(51, 153, 51));
        plantType.setFont(smallFont);

        Text waterReq = new Text();
        waterReq.setText("Water Requirements: " + plant.getWaterReq());
        waterReq.setLayoutX(30);
        waterReq.setLayoutY(150);
        waterReq.setFill(Color.rgb(51, 153, 51));
        waterReq.setFont(smallFont);

        Text waterCurr = new Text();
        waterCurr.setText("Current water level: " + plant.getCurrWaterVal());
        waterCurr.setLayoutX(30);
        waterCurr.setLayoutY(175);
        waterCurr.setFill(Color.rgb(51, 153, 51));
        waterCurr.setFont(smallFont);

        Text waterNeeded = new Text();
        waterNeeded.setText("Water needed: " + plant.calcWaterNeeded());
        waterNeeded.setLayoutX(30);
        waterNeeded.setLayoutY(200);
        waterNeeded.setFill(Color.rgb(51, 153, 51));
        waterNeeded.setFont(smallFont);

        canvas.getChildren().addAll(name, species, plantType, waterReq, waterCurr, waterNeeded, info);
    }

    public int getIndex() { return plantIndex;}

    public int getPlantID() {
        return plantID;
    }

    public String getName() {
        return plantName;
    }

    public String getSpecies() {
        return plantSpecies;
    }

    public String getType() {
        return plantType;
    }

    public String getInfo() {
        return plantTypeInfoString;
    }

    public int getWaterReq() {
        return waterReq;
    }

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
