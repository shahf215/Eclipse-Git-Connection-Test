package code.pSS.Java;

import java.util.List;

/**
 * This class is the main driver for the (Java only) Plotter, Salter, Smoother application
 */
public class PSSDriver {

    public static void main(String[] args) {

        // Generate the initial data set
        InitialPlot.generateCSV();

        // Create the salted data set
        SaltData.addSalt("initialDataSet.csv", "saltedDataSet.csv");

        // Read the salted data and create a SmoothData object
        List<String[]> saltedData = CSVReader.readCSV("saltedDataSet.csv");
        SmoothData smoothData = new SmoothData(saltedData);

        // Get the window size from the user and calculate smoothed Y values
        int windowSize = SmoothData.getWindowSizeFromUser();
        List<Double> smoothedYValues = smoothData.calculateSmoothedYValues(windowSize);

        // Write the smoothed data to a CSV file
        CSVWriter.writeSmoothedCSV("smoothedDataSet.csv", saltedData, smoothedYValues);
    }
}
