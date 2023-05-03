/**
 * The ChartCreator class provides a method to create a JFreeChart panel that displays an XYLineChart with a given dataset.
*/

package pSS.OtherAPI;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeriesCollection;

public class ChartCreator {

	/**
	 * Creates a JFreeChart panel that displays an XYLineChart with the given
	 * dataset.
	 *
	 * @param dataset The XYSeriesCollection dataset used to create the chart.
	 * @return A ChartPanel object containing the created chart.
	 */
	public ChartPanel createChart(XYSeriesCollection dataset) {

		// Create an XY line chart
		JFreeChart chart = ChartFactory.createXYLineChart("Salted & Smoothed Line Using Y = m * X + b", // chart title
				"X", // x axis label
				"Y", // y axis label
				dataset, // dataset to be displayed in the chart
				org.jfree.chart.plot.PlotOrientation.VERTICAL, // chart orientation
				true, // include a legend
				true, // include tooltips
				false); // do not include URLs

		// Create a chart panel with the created chart
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(800, 600)); // Set the dimensions of the chart panel
		return chartPanel;
	}
}
