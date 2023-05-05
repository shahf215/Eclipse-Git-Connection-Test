/**
 * The DataProcessor class provides methods to generate and process data for a chart.
 */

package code.pSS.OtherAPI;

import java.util.Random;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class DataProcessor {

	private static final double m = 2.0;
	private static final double b = 1.0;
	private static final int dataPoints = 100;

	private final int windowSize; // size of window used to smooth data
	private final double saltRange; // range of values added to Y values to create the salted data

	/**
	 * Creates a new DataProcessor object with a given window size and salt range.
	 *
	 * @param windowSize The size of the sliding window used to smooth the data.
	 * @param saltRange  The range of values added to the Y values to create the
	 *                   salted data.
	 */
	public DataProcessor(int windowSize, double saltRange) {
		this.windowSize = windowSize;
		this.saltRange = saltRange;
	}

	/**
	 * Generates chart data with linear Y values and adds salt to the data to create
	 * "salted" data.
	 *
	 * @return ChartData object representing the generated and salted data.
	 */
	public ChartData generateData() {
		ChartData chartData = new ChartData();
		Random random = new Random();

		for (int i = 0; i < dataPoints; i++) {
			double x = i;
			double y = m * x + b;
			double saltedY = y + saltRange * (random.nextDouble() * 2 - 1); // add random values to Y value to salt them
			chartData.addData(x, y, saltedY);
		}

		return chartData;
	}

	/**
	 * Smooths the salted Y values in the ChartData object using a sliding window
	 * and returns the smoothed data.
	 *
	 * @param chartData ChartData object containing the salted data.
	 * @return Array of the smoothed Y values.
	 */
	public double[] smoothData(ChartData chartData) {
		double[] smoothedData = new double[chartData.size()]; // array to hold smoothed data

		for (int i = 0; i < chartData.size(); i++) {
			DescriptiveStatistics stats = new DescriptiveStatistics(); // object for calculating statistics from the
																		// Apache commons math library
			int startIndex = Math.max(0, i - windowSize); // determine start and end index for window
			int endIndex = Math.min(chartData.size() - 1, i + windowSize);

			for (int j = startIndex; j <= endIndex; j++) {
				stats.addValue(Double.parseDouble(chartData.getData(j)[2]));
			}

			smoothedData[i] = stats.getMean(); // calculate and store mean value
		}

		return smoothedData;
	}

	/**
	 * Prints a table of the initial Y values and the corresponding salted and
	 * smoothed data.
	 *
	 * @param chartData    ChartData object containing the original and salted data.
	 * @param smoothedData Array of the smoothed Y values.
	 */
	public void printTable(ChartData chartData, double[] smoothedData) {
		StringBuilder table = new StringBuilder();

		// Add headers to the table and format them
		table.append(String.format("%-5s%-10s%-12s%s%n", "X", "Y", "Salted Y", "Smoothed Y"));

		// Add data to the table row by row using a for loop
		for (int i = 0; i < chartData.size(); i++) {
			String[] data = chartData.getData(i);
			double y = Double.parseDouble(data[1]);
			double saltedY = Double.parseDouble(data[2]);
			double smoothedY = smoothedData[i];

			// Add a row to the table with the X value, original Y value, the salted Y
			// value, and the smoothed Y value
			table.append(String.format("%-5d%-10.2f%-12.2f%.2f%n", i, y, saltedY, smoothedY));
		}

		System.out.println(table.toString());
	}
}
