import javafx.scene.control.Button;

import java.util.ArrayList;

/**
 Global interface
 @author: Laura Delage, Keelin Saranchuk
 Sets the values of important variables that can be accessed from any class.
 */

public interface Global {
    Button returnToHome = new Button("Go Home"); //global button, used in multiple classes
    Button deletePlant = new Button("Delete This Plant"); //global button, used in multiple classes
    Button editPlant = new Button("Edit Information"); //global button, used in multiple classes


    /*
    String[] plantTypeCompareArray = {"Flower", "Succulent", "Herb", "Fruit", "Tree", "Fern", "Other"}; //Array of plant types
    String[] plantTypeInfo = { //This array corresponds to plant type array, has information to be displayed according tp plant type
            "In general, flowers need consistent watering and bright but indirect sunlight.",
            "Succulents are easy beginner plants. They require direct sunlight, but do not need frequent watering.",
            "Herbs are easy and useful beginner plants. They do best when receiving 6-8 hours of direct sunlight per day.",
            "Care for fruit plants varies depending on the fruit, and can be challenging but very rewarding to grow.", // It's best to do research on your individual fruit plant.
            "Tree type plants are generally easy to grow and can become several feet high.", // For a shorter plant, make sure you are pruning your tree.
            "Ferns do best in humid conditions, cooler temperatures with little fluctuation, and moist soil.",
            "Unusual plant types can be challenging to care for. Be sure to do external research on your individual plant.",
    };
     */

    //ArrayList <Integer> waterLevelsSim = new ArrayList<>();
    //int firstWaterLevelSim = 60;

}
