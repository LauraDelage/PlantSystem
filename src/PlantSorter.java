import java.util.ArrayList;

public class PlantSorter {
    private Plant[] plantArr;

    public PlantSorter(ArrayList<Plant> plantList) {
        plantArr = new Plant[plantList.size()];

        //converts arrayList to array
        for (int i = 0; i < plantArr.length; i++) {
            plantArr[i] = plantList.get(i);
        }

    }

}
