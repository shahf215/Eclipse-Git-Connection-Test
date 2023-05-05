package code.pSS.Java;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * This class provides methods to write data to CSV files.
 */
public class CSVWriter {

    /**
     * Writes a list of String arrays to a CSV file.
     *
     * @param fileName  The name of the CSV file.
     * @param data      A list of String arrays, where each array represents a row in the CSV file.
     * @param headerRow The header row to be written to the CSV file.
     */
    public static void writeCSV(String fileName, List<String[]> data, String headerRow) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(headerRow + "\n");
            for (String[] row : data) {
                bw.write(String.join(",", row) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes a list of String arrays and smoothed Y values to a CSV file.
     *
     * @param fileName       The name of the CSV file.
     * @param data           A list of String arrays, where each array represents a row in the CSV file.
     * @param smoothedYValues A list of smoothed Y values.
     */
    public static void writeSmoothedCSV(String fileName, List<String[]> data, List<Double> smoothedYValues) {
        String headerRow = data.get(0)[0] + "," + data.get(0)[1] + "," + data.get(0)[2] + ",Y (Smoothed)";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(headerRow + "\n");
            for (int i = 1; i < data.size(); i++) {
                String[] row = data.get(i);
                bw.write(String.join(",", row) + "," + smoothedYValues.get(i - 1) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
