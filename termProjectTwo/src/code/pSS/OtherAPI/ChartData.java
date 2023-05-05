/**
 * The ChartData class provides a container for storing and retrieving data for creating an XYLineChart using JFreeChart.
 */

package code.pSS.OtherAPI;

import java.util.ArrayList;
import java.util.List;

public class ChartData {
	// A list to store the data as string arrays
	private List<String[]> data;

	/**
	 * Constructs an instance of ChartData with an empty data list.
	 */
	public ChartData() {
		data = new ArrayList<>();
	}

	/**
	 * Adds data to the list as a string array.
	 *
	 * @param x       The x value to be added to the data.
	 * @param y       The y value to be added to the data.
	 * @param saltedY The salted y value to be added to the data.
	 */
	public void addData(double x, double y, double saltedY) {
		data.add(new String[] { Double.toString(x), Double.toString(y), Double.toString(saltedY) });
	}

	/**
	 * Returns the string array of data at the specified index.
	 *
	 * @param index The index of the data to be retrieved.
	 * @return The string array of data at the specified index.
	 */
	public String[] getData(int index) {
		return data.get(index);
	}

	/**
	 * Returns the number of data items in the list.
	 *
	 * @return The number of data items in the list.
	 */
	public int size() {
		return data.size();
	}
}
