package code.pSS.Java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides methods to read CSV files.
 */
public class CSVReader {

    /**
     * Reads a CSV file and returns the data as a list of String arrays.
     *
     * @param fileName The name of the CSV file.
     * @return A list of String arrays, where each array represents a row in the CSV file.
     */
    public static List<String[]> readCSV(String fileName) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    
    /**
     * Reads a CSV file containing smooth data and returns a SmoothData object.
     *
     * @param fileName The name of the CSV file.
     * @return A SmoothData object containing the data from the CSV file.
     */
    public static SmoothData readSmoothDataCsv(String fileName) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // Skip the header row
                }
                String[] values = line.split(",");
                data.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new SmoothData(data);
    }
}
