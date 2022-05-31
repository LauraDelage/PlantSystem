/**
 Initializes file, simulates connection to circuit board
 @author: Keelin Saranchuk
 */

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class CircuitBoardConnection implements Global {

    static ArrayList<Integer> waterLevelsArrayList = new ArrayList<>(); //arrayList, returns data in groups when called

    /**
     * The getArray() method returns waterLevelsArrayList
     * @author Keelin Saranchuk
     */
    public static ArrayList<Integer> getArray() {
        return waterLevelsArrayList;
    }

    /**
     * The generate() method outputs integers to a file and closes file
     * @author Keelin Saranchuk
     */
    public static void generate() {
        Random waterPercentageGenerator = new Random(); //allows random integers to be generated
        String waterFile = "WaterLevels.txt"; //file outputted to
        try{
            //Allows for file writing:
            FileWriter fw = new FileWriter(waterFile, false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter output = new PrintWriter(bw);
            for(int count = 0; count < 3 ;count++ ) { //loops, outputs 3 random integers
                int value = waterPercentageGenerator.nextInt(100);
                output.println(value);
                sleep(2000); //every 2 seconds data is simulated
            }
            //close file
            output.flush();
            output.close();

        } catch(Exception e){
            System.err.println("Error");
        }
    }

    /**
     * The read() method reads integers from the file
     * @author Keelin Saranchuk
     */
    public static void read() {
        File waterLevelsTxt; //file we are working with
        Scanner fileInput = null;
        try{
            waterLevelsTxt = new File("WaterLevels.txt");
            fileInput = new Scanner(waterLevelsTxt);
            //System.out.println("Reading file...");
            while (fileInput.hasNext()) { //while there are integers to be read
                try{
                    int value = fileInput.nextInt(); //save as value
                    waterLevelsArrayList.add(value); //add this value to arrayList
                    //System.out.println(value);
                }
                catch(InputMismatchException ime){
                    System.out.println("Error");
                    fileInput.nextLine();
                }
            }
            fileInput.close(); //close file
        }
        catch (IOException e) {
            System.out.println("Did not find file");
            System.exit(-1);
        }
    }

    /**
     * The sleep() method creates a pause in the thread, so that we have time to process integers and output them
     *
     * @param time time for thread to pause
     * @author Keelin Saranchuk
     */
    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("Thread is interrupted");
            Thread.currentThread().interrupt();
        }
    }

}
