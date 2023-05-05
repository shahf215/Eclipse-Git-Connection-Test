package code.pSS.Java;

import java.util.ArrayList;
import java.util.List;

/**
 * This class generates an initial data set for the graph.
 */
public class InitialPlot {

    /**
     * Generates a CSV file with the initial data set.
     */
    public static void generateCSV() {
        // User-defined parameters for the graph
        double xMin = 0;
        double xMax = 99;
        int numPoints = 100;

        // Parameters for the line equation
        double m = 2;
        double b = 1;

        // Create data the for CSV file
        List<String[]> data = new ArrayList<>();

        // Write data rows
        double deltaX = (xMax - xMin) / (numPoints - 1);
        for (int i = 0; i < numPoints; i++) {
            double x = xMin + i * deltaX;
            double y = m * x + b;
            data.add(new String[]{String.valueOf(x), String.valueOf(y)});
        }

        // Write CSV file
        String fileName = "initialDataSet.csv";
        String headerRow = "X,Y";
        CSVWriter.writeCSV(fileName, data, headerRow);
    }
}
