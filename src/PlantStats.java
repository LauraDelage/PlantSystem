import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * PlantStats class
 * Generates and calculates data that represents a user's performance in caring for their plant.
 * @author: Laura Delage
 * */
public class PlantStats implements Global {

    /**
     * Constructor method
     */
    PlantStats() {
    }

    /**
     * recordWaterngs method
     * Checks to determine whether or not a plant has been watered based on two conditions;
     *      Plant's water level must be greater than minimum requirements
     *      Plant's current water level must be significantly greater than past water levels
     * @param plant the plant object that may have been watered
     */
    public void recordWaterings(Plant plant) {
        int prevWaterVal = 10; //this value would have been retrieved from the circuit board if it was functional
        if ((plant.getCurrWaterVal() > 10) && (plant.getCurrWaterVal() >= plant.getWaterReq())) {
            plant.hasBeenWatered();
        }
    }

    /**
     * calcWaterings method
     * Determines how many times a plant has been watered since a certain date
     * @param plant the plant object involved in the calculation
     * @param startDate the date from which waterings can start to be counted
     */
    public void calcWaterings(Plant plant, Date startDate) {
        ArrayList<Date> waterSince = new ArrayList<>();
        int numWaterings = 0;

        for (int i = 0; i < plant.getWaterDates().size(); i++) {
            if (plant.getWaterDates().get(i).compareTo(startDate) >= 0) {
                waterSince.add(plant.getWaterDates().get(i));
                numWaterings++;
            }
        }
        System.out.println("Since " + startDate
                + ", you have watered your plant " + plant.getName() + " "
                + numWaterings + " times. Congratulations!");
        System.out.println("Watering history:");
        System.out.println(waterSince);
    }

    /**
     * calcWaterStreak method
     * Calculates the current streak and maximum streak of consecutive days in a row that plant object has been watered
     * @param plant the plant whose streak is being calculated
     * @return The all-time best streak and the current streak, in String format
     */
    public String calcWaterStreak(Plant plant) {
        int currStreak = 0;
        int maxStreak = 0;
        SimpleDateFormat sdformatter = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList <Date> waterDates = plant.getWaterDates();
        Date currDate;
        String currString;
        int currDateNum;
        Date nextDate;
        String nextString;
        int nextDateNum;
        for (int i = 0; i < (waterDates.size() - 1); i++) {
            currDate = waterDates.get(i);
            currString = sdformatter.format(currDate);
            nextDate = waterDates.get(i + 1);
            nextString = sdformatter.format(nextDate);
            currDateNum = Integer.parseInt(currString.substring(8,9));
            nextDateNum = Integer.parseInt(nextString.substring(8,9));
            if (currDateNum == (nextDateNum - 1)) {
                currStreak++;
                if (currStreak > maxStreak) {
                    maxStreak = currStreak;
                }
            }
            else {
                currStreak = 0;
            }
        }
        return ("Current streak: " + currStreak + "  All-time best streak: " + maxStreak);
    }
}

