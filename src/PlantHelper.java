import java.util.ArrayList;

/**
 * PlantSorter class
 * Allows ArrayLists of Plant objects to be manipulated (i.e., sorted, names printed out)
 * @author: Laura Delage
 * */

public class PlantHelper {
    private Plant[] plantArr;

    /**
     * Constructor method
     * @param plantList the ArrayList of plants to be converted to an array, so that it is useable in other methods
     */
    public PlantHelper(ArrayList<Plant> plantList) {
        plantArr = new Plant[plantList.size()];

        //converts arrayList to array
        for (int i = 0; i < plantArr.length; i++) {
            plantArr[i] = plantList.get(i);
        }
    }

    /**
     * Helper method
     * Swaps the positions of two plants within an Array of plants
     * @param plantArr
     * @param firstIndex
     * @param secondIndex
     */
    private static void plantSwap(Plant[] plantArr, int firstIndex, int secondIndex) {
        Plant temp = plantArr[firstIndex];
        plantArr[firstIndex] = plantArr[secondIndex];
        plantArr[secondIndex] = temp;
    }

    /**
     * Sorts an ArrayList of plants alphabetically by name.
     * @param plantList an arrayList of plants to be sorted
     * @return the sorted ArrayList
     */
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

    /**
     * Sorts an ArrayList of plants by the amount of water they need. Sorts from highest to lowest need for water.
     * @param plantList an arrayList of plants to be sorted
     * @return the sorted ArrayList
     */
    public ArrayList<Plant> waterSort (ArrayList<Plant> plantList) {
        plantArr = listToArr(plantList);

        int bubbleCounter = -1;

        while (bubbleCounter != 0) {
            bubbleCounter = 0;
            for(int i = 0; i < plantArr.length - 1; i++) {
                if (plantArr[i].calcWaterNeeded() < plantArr[i + 1].calcWaterNeeded()) {
                    plantSwap(plantArr, i, i + 1);
                    bubbleCounter++;
                }
            }
        }

        plantList = arrToList(plantArr);
        return plantList;
    }

    /**
     * Helper method
     * Converts an ArrayList of plants into an Array of plants
     * @param plantList the ArrayList of plants to be converted
     * @return an Array of all plants within the ArrayList
     */
    private Plant[] listToArr(ArrayList<Plant> plantList) {
        plantArr = new Plant[plantList.size()];

        //converts arrayList to array
        for (int i = 0; i < plantArr.length; i++) {
            plantArr[i] = plantList.get(i);
        }
        return plantArr;
    }

    /**
     * Helper method
     * Converts an Array of plants into an ArrayList of plants
     * @param plantArr the array of plants to be converted
     * @return an ArrayList of all plants within the Array
     */
    private ArrayList <Plant> arrToList(Plant[] plantArr) {
        ArrayList plantList = new ArrayList();
        for (int i = 0; i < plantArr.length; i++) {
            plantList.add(plantArr[i]);
        }
        return plantList;
    }

    /**
     * Prints out the names of all plants in an arrayList.
     * @param plantList list of plants whose names are printed
     */
    public void printNames(ArrayList<Plant> plantList) {
        for (int i = 0; i < plantList.size(); i++) {
            System.out.println(plantList.get(i).getName());
        }
    }

    /**
     * Prints out multiple values (name, water requirements, current water value, water needed) for all plants in an ArrayList
     * @param plantList list of plants whose info is printed
     */
    public void printWaterInfo(ArrayList<Plant> plantList) {
        for (int i = 0; i < plantList.size(); i++) {
            System.out.println(plantList.get(i).getName());
            System.out.println(plantList.get(i).getWaterReq());
            System.out.println(plantList.get(i).getCurrWaterVal());
            System.out.println(plantList.get(i).calcWaterNeeded());
        }
    }

}
