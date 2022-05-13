import java.util.ArrayList;

/**
 Global interface
 @author: Laura Delage
 Sets the values of important variables that can be accessed from any class.
 */

public interface Global {
    String[] plantType = {"FLOWER", "SUCCULENT", "HERB", "FRUIT", "TREE", "FERN", "OTHER"};
    String[] plantTypeInfo = {
            "In general, flowers need consistent watering and bright but indirect sunlight. However, there are many types of flowering plants with differing care requirements.",
            "Succulents are easy beginner plants. They require direct sunlight, but do not need frequent watering.",
            "Herbs are easy and useful beginner plants. They do best when receiving 6-8 hours of direct sunlight per day.",
            "Care for fruit plants varies depending on the fruit, and can be challenging but very rewarding to grow. It's best to do research on your individual fruit plant.",
            "Tree type plants are generally easy to grow and can become several feet high. For a shorter plant, make sure you are pruning your tree.",
            "Ferns thrive with proper care. They do best in humid conditions, cooler temperatures with little fluctuation, and moist soil with easy drainage.",
            "Unusual plant types can be challenging to care for. Be sure to do external research on your individual plant.",
    };

    int fakePastWaterVal = 60;

    ArrayList<Integer> allWaterLevels = new ArrayList<>();

}
