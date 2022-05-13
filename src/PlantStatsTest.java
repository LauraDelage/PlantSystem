import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Testing class to evaluate the functionality of the PlantStats class
 * @author Laura Delage
 */

public class PlantStatsTest {
    @Test
    void recordWateringsTest() {
        //ArrayList<String> waterDates = new ArrayList<>();
        Plant bob = new Plant("bob", "coriander", 3, 80);
        bob.setCurrWaterVal(90);
        //bob.hasBeenWatered();
        PlantStats bobStats = new PlantStats();
        bobStats.recordWaterings(bob);
        bob.setCurrWaterVal(40);
        bobStats.recordWaterings(bob);
        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bob.setCurrWaterVal(99);
        bobStats.recordWaterings(bob);
        System.out.println(bob.getWaterDates());
    }

    @Test
    void calcWateringsTest() {
        Plant bob = new Plant("bob", "coriander", 3, 80);
        PlantStats bobStats = new PlantStats();
        Date date = new Date();

        for (int i = 0; i < 5; i++) {
            bob.setCurrWaterVal(90);
            bobStats.recordWaterings(bob);
            try {
                Thread.currentThread().sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Date date = new Date();
        bobStats.calcWaterings(bob,date);
        //System.out.println(bob.getWaterDates());
    }

    @Test
    void waterValTest() {
        System.out.println(Global.allWaterLevels);
    }

}
