import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Testing class to evaluate the functionality of the PlantSorter class
 * @author Laura Delage
 */

class PlantHelperTest {

    @Test
    /**
     * Tests functionality of the alphaSort() method
     * Prints a list of plant names, sorts the list of plants alphabetically, and re-prints them in sorted order
     */
    void alphaSortTest() {
        ArrayList<Plant> allPlants = new ArrayList<>();
        PlantHelper plantAssistant = new PlantHelper(allPlants);
        Plant anna = new Plant("anna", "coriander", 3, 10,2);
        Plant bean = new Plant("bean", "coriander", 3, 10,2);
        Plant bob = new Plant("bob", "coriander", 3, 10,2);
        Plant craig = new Plant("craig", "coriander", 3, 10,2);
        Plant donut = new Plant("donut", "coriander", 3, 10,2);

        allPlants.add(craig);
        allPlants.add(bob);
        allPlants.add(donut);
        allPlants.add(bean);
        allPlants.add(anna);

        System.out.println("Unsorted:");
        plantAssistant.printNames(allPlants);

        allPlants = plantAssistant.alphaSort(allPlants);

        System.out.println();
        System.out.println("Sorted:");
        plantAssistant.printNames(allPlants);

    }

    @Test
    /**
     * Tests functionality of the waterSort() method
     * Prints a list of plant info, sorts the list of plants by how much water they need, and re-prints their info in sorted order
     */
    void waterSortTest() {
        ArrayList<Plant> allPlants = new ArrayList<>();
        PlantHelper plantAssistant = new PlantHelper(allPlants);
        Plant anna = new Plant("anna", "coriander", 3, 10,2);
        Plant bean = new Plant("bean", "coriander", 3, 10,2);
        Plant bob = new Plant("bob", "coriander", 3, 10,2);
        Plant craig = new Plant("craig", "coriander", 3, 10,2);
        Plant donut = new Plant("donut", "coriander", 3, 10,2);

        craig.setCurrWaterVal(9);
        craig.calcWaterNeeded();

        bob.setCurrWaterVal(5);
        bob.calcWaterNeeded();

        donut.setCurrWaterVal(2);
        donut.calcWaterNeeded();

        bean.setCurrWaterVal(3);
        bean.calcWaterNeeded();

        anna.setCurrWaterVal(7);
        anna.calcWaterNeeded();

        allPlants.add(craig);
        allPlants.add(bob);
        allPlants.add(donut);
        allPlants.add(bean);
        allPlants.add(anna);

        System.out.println("Unsorted:");
        plantAssistant.printWaterInfo(allPlants);

        allPlants = plantAssistant.waterSort(allPlants);

        System.out.println();
        System.out.println("Sorted:");
        plantAssistant.printWaterInfo(allPlants);
    }

    @Test
    /**
     * Tests functionality of the calcWaterNeeded() method within the Plant class
     * Determines and prints the % moisture a plant's soil must increase by to meet their minimum moisture requirements.
     */
    void waterCalcTest() {
        Plant bob = new Plant("bob", "coriander", 3, 10,9);
        bob.setCurrWaterVal(9);
        System.out.println(bob.calcWaterNeeded());
    }
}

