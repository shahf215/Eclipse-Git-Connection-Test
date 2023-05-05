package code.pSS.Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * This class provides methods to add salt to the data.
 */
public class SaltData {

    /**
     * Adds salt to the data in the input CSV file and writes the salted data to a new CSV file.
     *
     * @param inputFileName  The name of the input CSV file.
     * @param outputFileName The name of the output CSV file.
     */
    public static void addSalt(String inputFileName, String outputFileName) {

        Scanner scanner = new Scanner(System.in); //the scanner isn't closed in this file because it is used again in SmoothData.java
        System.out.print("Enter the salt range: ");
        double saltRange = scanner.nextDouble();

        List<String[]> data = CSVReader.readCSV(inputFileName);

        String headerRow = data.get(0)[0] + "," + data.get(0)[1] + ",Y (Salted)";
        List<String[]> saltedData = new ArrayList<>();

        // Add a random number to the y value and write the modified data to the new CSV file
        for (int i = 1; i < data.size(); i++) {
            double initialY = Double.parseDouble(data.get(i)[1]);
            double saltedY = initialY + (new Random().nextDouble() * 2 - 1) * saltRange;
            saltedData.add(new String[]{data.get(i)[0], data.get(i)[1], String.valueOf(saltedY)});
        }

        CSVWriter.writeCSV(outputFileName, saltedData, headerRow);
    }
}
