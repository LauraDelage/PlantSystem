import java.util.ArrayList;

/**
 * PlantSorter class
 * Allows ArrayLists of Plant objects to be manipulated (i.e., sorted, names printed out)
 * @author: Laura Delage
 * */

public class PlantHelper {
    private Plant[] plantArr;

    public PlantHelper(ArrayList<Plant> plantList) {
        plantArr = new Plant[plantList.size()];

        //converts arrayList to array
        for (int i = 0; i < plantArr.length; i++) {
            plantArr[i] = plantList.get(i);
        }
    }

    private static void plantSwap(Plant[] plantArr, int firstIndex, int secondIndex) {
        Plant temp = plantArr[firstIndex];
        plantArr[firstIndex] = plantArr[secondIndex];
        plantArr[secondIndex] = temp;
    }

    public ArrayList<Plant> alphaSort(ArrayList<Plant> plantList) {
        plantArr = listToArr(plantList);
        for (int i = 0; i < plantArr.length; i++) {
            for (int j = i + 1; j < plantArr.length; j++) {
                //compares two words' letter positions in the alphabet
                //returns positive number if they are out of order
                if (plantArr[i].getName().compareTo(plantArr[j].getName()) > 0) {
                    plantSwap(plantArr, i, j); //swaps two words
                }
            }
        }
        plantList = arrToList(plantArr);
        return plantList;
    }

    public ArrayList<Plant> waterSort (ArrayList<Plant> plantList) {
        plantArr = listToArr(plantList);

        int bubbleCounter = -1;

        while (bubbleCounter != 0) {
            bubbleCounter = 0;
            for(int i = 0; i < plantArr.length - 1; i++) {
                if (plantArr[i].calcWaterNeeded() > plantArr[i + 1].calcWaterNeeded()) {
                    plantSwap(plantArr, i, i + 1);
                    bubbleCounter++;
                }
            }
        }

        plantList = arrToList(plantArr);
        return plantList;
    }


    private Plant[] listToArr(ArrayList<Plant> plantList) {
        plantArr = new Plant[plantList.size()];

        //converts arrayList to array
        for (int i = 0; i < plantArr.length; i++) {
            plantArr[i] = plantList.get(i);
        }
        return plantArr;
    }

    private ArrayList <Plant> arrToList(Plant[] plantArr) {
        ArrayList plantList = new ArrayList();
        for (int i = 0; i < plantArr.length; i++) {
            plantList.add(plantArr[i]);
        }
        return plantList;
    }

    public void printNames(ArrayList<Plant> plantList) {
        for (int i = 0; i < plantList.size(); i++) {
            System.out.println(plantList.get(i).getName());
        }
    }

    public void printWaterInfo(ArrayList<Plant> plantList) {
        for (int i = 0; i < plantList.size(); i++) {
            System.out.println(plantList.get(i).getName());
            System.out.println(plantList.get(i).getWaterReq());
            System.out.println(plantList.get(i).getCurrWaterVal());
            System.out.println(plantList.get(i).calcWaterNeeded());
        }
    }

    /* ignore for now, just an idea
    public ArrayList<Plant> refreshWaterValues(ArrayList<Plant> plantList) {
        for (int i = 0; i < plantList.size(); i++) {
            plantList.get(i).calcWaterNeeded();
        }
        return plantList;
    }
     */

}
