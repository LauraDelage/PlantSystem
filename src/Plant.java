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
    int waterReq;

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


}
