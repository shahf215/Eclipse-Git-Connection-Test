package pSS.OtherAPI;

import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import java.util.Scanner;

/**
 * A driver program for generating a chart of smoothed data using salt and
 * window size parameters.
 */
public class PlotSaltSmoothDriver extends ApplicationFrame {

	/**
	 * Constructor for PlotSaltSmoothDriver.
	 * 
	 * @param title      the title of the chart
	 * @param windowSize the size of the window used for smoothing the data
	 * @param saltRange  the range of the salt added to the data
	 */
	public PlotSaltSmoothDriver(String title, int windowSize, double saltRange) {

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

	/**
	 * Main method for running the PlotSaltSmoothDriver program.
	 */
	public static void main(String[] args) {

		// Create a Scanner object to read input from the user
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the window size: ");
		int windowSize = scanner.nextInt();
		System.out.print("Enter the salt range: ");
		double saltRange = scanner.nextDouble();
		scanner.close();

		// Create a PlotSaltSmoothDriver object with user-provided parameters
		PlotSaltSmoothDriver plotter = new PlotSaltSmoothDriver("Function Plotter", windowSize, saltRange);
		plotter.pack();
		RefineryUtilities.centerFrameOnScreen(plotter);
		plotter.setVisible(true);
	}
}
