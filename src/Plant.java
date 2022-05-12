import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Plant class
 * Creates the structure for an individual plant object.
 * @author: Laura Delage, Keelin Saranchuk
 * */

public class Plant {
    private String plantName;
    private String plantSpecies;
    private String plantType;
    private String plantTypeInfo;
    int waterReq;   //plant's water requirements (% moisture of soil)
    int currWaterVal; //current % moisture in soil
    int waterNeeded; //% of water currently required to meet the waterReq
    ArrayList<Date> waterDates = new ArrayList<>();


    Plant(String name, String species, int plantTypeIndex, int waterRequirements) {
        plantName = name;
        plantSpecies = species;
        plantType = Global.plantType[plantTypeIndex];
        plantTypeInfo = Global.plantTypeInfo[plantTypeIndex];
        waterReq = waterRequirements;
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
        return plantTypeInfo;
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
