/**
 * Plant class
 * Creates the structure for an individual plant object.
 * @author: Laura Delage
 * */

public class Plant {
    String plantName;
    String plantSpecies;
    String plantType;
    String plantTypeInfo;
    int waterReq;   //plant's water requirements (% moisture of soil)
    int currWaterVal; //current % moisture in soil
    int waterNeeded; //% of water currently required to meet the waterReq

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

    public int getWaterReq() {
        return waterReq;
    }

    public int getCurrWaterVal() {return currWaterVal;}

    public void setCurrWaterVal(int waterVal) {currWaterVal = waterVal;}

    public int calcWaterNeeded() {
        waterNeeded = waterReq - currWaterVal;
        return waterNeeded;
    }

}
