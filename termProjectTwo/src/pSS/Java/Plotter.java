/**
 * The Plotter class generates a CSV file for a line graph with the line equation y = mx + b.
 * The user can set the range and number of data points for the graph.
 * The resulting CSV file is opened with the default application to view the graph, in our case this is excel.
 */
package pSS.Java;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Plotter {

	/**
	 * Generates a CSV file containing data for a line graph with the equation y =
	 * mx + b. The user can set the range and number of data points for the graph.
	 * The resulting CSV file is opened with the default application to view the
	 * graph.
	 *
	 * @param args The command-line arguments.
	 */
	public static void main(String[] args) {
		// User-defined parameters for the graph
		double xMin = 0;
		double xMax = 99;
		int numPoints = 100;

		// Parameters for the line equation
		double m = 2;
		double b = 1;

		// Create CSV file for data
		String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "pSS" + File.separator
				+ "Java" + File.separator + "initialDataSet.csv";
		File csvFile = new File(path);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
			// Write header row
			bw.write("x,y\n");

			// Write data rows
			double deltaX = (xMax - xMin) / (numPoints - 1);
			for (int i = 0; i < numPoints; i++) {
				double x = xMin + i * deltaX;
				double y = m * x + b;
				bw.write(x + "," + y + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Open file with default application
		try {
			Desktop.getDesktop().open(csvFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
