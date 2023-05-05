package code.pSS.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents smooth data and provides methods to smooth the data.
 */
public class SmoothData {
    private List<Double> xValues;
    private List<Double> yValues;
    private List<Double> saltedYValues;

    /**
     * Constructs a SmoothData object from a list of String arrays.
     *
     * @param data A list of String arrays representing the data.
     */
    public SmoothData(List<String[]> data) {
        xValues = new ArrayList<>();
        yValues = new ArrayList<>();
        saltedYValues = new ArrayList<>();

        // Skip the header row
        for (int rowIndex = 1; rowIndex < data.size(); rowIndex++) {
            String[] row = data.get(rowIndex);
            if (row.length != 3) {
                continue;
            }
            try {
                xValues.add(Double.parseDouble(row[0]));
                yValues.add(Double.parseDouble(row[1]));
                saltedYValues.add(Double.parseDouble(row[2]));
            } catch (NumberFormatException e) {
                System.out.println("Error parsing value: " + Arrays.toString(row));
                continue;
            }
        }
    }

    public List<Double> getXValues() {
        return xValues;
    }

    public List<Double> getYValues() {
        return yValues;
    }

    public List<Double> getSaltedYValues() {
        return saltedYValues;
    }

    /**
     * Calculates smoothed Y values using a given window size.
     *
     * @param windowSize The window size to use for smoothing.
     * @return A list of smoothed Y values.
     */
    public List<Double> calculateSmoothedYValues(int windowSize) {
        List<Double> smoothedYValues = new ArrayList<>();
        for (int i = 0; i < saltedYValues.size(); i++) {
            double sum = 0;
            int count = 0;
            for (int j = Math.max(0, i - windowSize); j <= Math.min(saltedYValues.size() - 1, i + windowSize); j++) {
                sum += saltedYValues.get(j);
                count++;
            }
            double average = sum / count;
            smoothedYValues.add(average);
        }
        return smoothedYValues;
    }

    /**
     * Prompts the user for the window size for smoothing.
     *
     * @return The window size entered by the user.
     */
    public static int getWindowSizeFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the window size: ");
        int windowSize = scanner.nextInt();
        scanner.close();
        return windowSize;
    }
}
