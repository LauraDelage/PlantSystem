import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Testing class to evaluate the functionality of the PlantSorter class
 * @author Laura Delage
 */

class PlantSorterTest {

    @Test
    void sort() {
        ArrayList<Plant> allPlants = new ArrayList<>();
        PlantHelper plantAssistant = new PlantHelper(allPlants);
        Plant anna = new Plant("anna", "coriander", 3, 10);
        Plant bean = new Plant("bean", "coriander", 3, 10);
        Plant bob = new Plant("bob", "coriander", 3, 10);
        Plant craig = new Plant("craig", "coriander", 3, 10);
        Plant donut = new Plant("donut", "coriander", 3, 10);

        allPlants.add(craig);
        allPlants.add(bob);
        allPlants.add(donut);
        allPlants.add(bean);
        allPlants.add(anna);

        System.out.println("Unsorted:");
        plantAssistant.printNames(allPlants);

        allPlants = plantAssistant.alphaSort(allPlants);

        System.out.println("");
        System.out.println("Sorted:");
        plantAssistant.printNames(allPlants);

    }
}
