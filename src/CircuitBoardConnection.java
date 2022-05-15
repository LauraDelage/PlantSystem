/**
 Initializes file, simulates connection to circuit board
 @author: Keelin Saranchuk
 */

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class CircuitBoardConnection {
    static boolean beginGeneratingWaterLevels = true;
    static ArrayList<Integer> waterLevelsArray;

    public static void main(String[] args) {
        while(beginGeneratingWaterLevels) {
            generate();
            read();
        }
    }

    public static ArrayList<Integer> getArray() {
        if (waterLevelsArray == null) {
            waterLevelsArray = new ArrayList<>();
        }
        return waterLevelsArray;
    }

    public static void generate() {
        //beginGeneratingWaterLevels = true;
        Random waterPercentageGenerator = new Random();
        String waterFile = "WaterLevels.txt";
        try{
            FileWriter fw = new FileWriter(waterFile, false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter output = new PrintWriter(bw);
            System.out.println("Outputting to file...");
            for(int count = 0; count < 10 ;count++ ) {
                int value = waterPercentageGenerator.nextInt(100);
                output.println(value);
                System.out.println(value);
                sleep(2000); //every 10 seconds data is simulated
            }
            output.flush();
            output.close();

        } catch(Exception e){
            System.err.println("Error");
        }
    }

    public static void read() {
        File waterLevelsTxt;
        Scanner fileInput = null;
        try{
            waterLevelsTxt = new File("WaterLevels.txt");
            fileInput = new Scanner(waterLevelsTxt);
            System.out.println("Reading file...");
            while (fileInput.hasNext()) {
                try{
                    int value = fileInput.nextInt();
                    waterLevelsArray.add(value);
                    System.out.println(value);
                }
                catch(InputMismatchException ime){
                    System.out.println("Error");
                    fileInput.nextLine();
                }
            }
            fileInput.close();
        }
        catch (IOException e) {
            System.out.println("Did not find file");
            System.exit(-1);
        }
    }


    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("Thread is interrupted");
            Thread.currentThread().interrupt();
        }
    }



}
