package code.pSS.OtherAPI;

import org.jfree.ui.ApplicationFrame;

/**
 * PlotSaltSmooth class extends ApplicationFrame and is responsible for
 * plotting the salted and smoothed data using the provided parameters.
 */
public class PlotSaltSmooth extends ApplicationFrame {

    /**
     * Constructor for PlotSaltSmooth.
     *
     * @param title      the title of the chart
     * @param windowSize the size of the window used for smoothing the data
     * @param saltRange  the range of the salt added to the data
     */
    public PlotSaltSmooth(String title, int windowSize, double saltRange) {

        super(title);

        // Create a DataProcessor object to generate and smooth the data
        DataProcessor dataProcessor = new DataProcessor(windowSize, saltRange);
        ChartData chartData = dataProcessor.generateData();
        double[] smoothedData = dataProcessor.smoothData(chartData);

        // Print a table of the generated data
        dataProcessor.printTable(chartData, smoothedData); // Add this line to print the table

        // Create a DatasetCreator and ChartCreator object to create the chart
        DatasetCreator datasetCreator = new DatasetCreator();
        ChartCreator chartCreator = new ChartCreator();

        // Set the chart as the content pane of the frame
        setContentPane(chartCreator.createChart(datasetCreator.createDataset(chartData, smoothedData)));
    }
}
