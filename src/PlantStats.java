import java.util.ArrayList;
import java.util.Date;

public class PlantStats implements Global {

    PlantStats() {
    }
    public void recordWaterings(Plant plant) {
        if ((plant.getCurrWaterVal() > 10) && (plant.getCurrWaterVal() >= plant.getWaterReq())) {
            plant.hasBeenWatered();
        }
    }

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

    /*


     */
}

