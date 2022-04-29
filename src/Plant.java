/**
 * Plant class
 * Creates the structure for an individual plant object.
 * @author: Keelin Saranchuk, Laura Delage
 * */

public class Plant {
    String plantName;
    String plantSpecies;
    //int plantTypeIndex;
    String plantType;
    String plantTypeInfo;
    int waterReq;

    Plant(int plantTypeIndex) {
      plantType = Global.plantType[plantTypeIndex];
      plantTypeInfo = Global.plantTypeInfo[plantTypeIndex];
    }

    public String getName() {
        return plantName;
    }

    public int getWaterReq() {
        return waterReq;
    }


}
