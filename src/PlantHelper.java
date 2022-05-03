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

    private static void plantSwap(Plant[] plantArr, int firstIndex, int secondIndex) {
        Plant temp = plantArr[firstIndex];
        plantArr[firstIndex] = plantArr[secondIndex];
        plantArr[secondIndex] = temp;
    }

    public void printNames(ArrayList<Plant> plantList) {
        for (int i = 0; i < plantList.size(); i++) {
            System.out.println(plantList.get(i).getName());
        }
    }

}
