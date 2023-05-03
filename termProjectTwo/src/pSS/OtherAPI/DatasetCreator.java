/**
 * The DatasetCreator class provides a method to create a JFreeChart dataset 
 * from ChartData and a corresponding array of smoothed data.
 */

package pSS.OtherAPI;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class DatasetCreator {
	/**
	 * Creates an XYSeriesCollection dataset from ChartData and a corresponding
	 * array of smoothed data.
	 *
	 * @param chartData    The ChartData containing the data to be displayed in the
	 *                     chart.
	 * @param smoothedData The smoothed data to be displayed in the chart.
	 * @return An XYSeriesCollection object containing the original, salted, and
	 *         smoothed Y values.
	 */
	public XYSeriesCollection createDataset(ChartData chartData, double[] smoothedData) {

		// Create empty XYSeriesCollection
		XYSeriesCollection dataset = new XYSeriesCollection();

		// Create new XYSeries objects to hold original, salted, and smoothed Y values
		XYSeries originalSeries = new XYSeries("Y");
		XYSeries saltedSeries = new XYSeries("Y (Salted)");
		XYSeries smoothedSeries = new XYSeries("Y (Smoothed)");

		// Add data to the XYSeries objects
		for (int i = 0; i < chartData.size(); i++) {
			String[] data = chartData.getData(i);
			double x = Double.parseDouble(data[0]);
			double y = Double.parseDouble(data[1]);
			double saltedY = Double.parseDouble(data[2]);
			double smoothedY = smoothedData[i];

			originalSeries.add(x, y);
			saltedSeries.add(x, saltedY);
			smoothedSeries.add(x, smoothedY);
		}

		// Add the XYSeries objects to the dataset and return it
		dataset.addSeries(originalSeries);
		dataset.addSeries(saltedSeries);
		dataset.addSeries(smoothedSeries);
		return dataset;
	}

}
