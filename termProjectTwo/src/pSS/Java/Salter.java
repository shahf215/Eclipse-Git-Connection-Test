/**
 * This class reads a CSV file containing x and y values.
 * Then it adds a random number to each y value, and writes the modified data to a new CSV file.
 */
package pSS.Java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Salter {

	/**
	 * Reads a CSV file containing x and y values, adds a random number to each y
	 * value, and writes the modified data to a new CSV file.
	 *
	 * @param args The command-line arguments specifying the input and output files
	 *             and the range of the random number to be added. The first
	 *             argument specifies the minimum range of the random number to be
	 *             added to each y value. The second argument specifies the maximum
	 *             range of the random number to be added to each y value.
	 */
	public static void main(String[] args) {

		// Ensure that the correct number of command-line arguments are passed in
		if (args.length != 2) {
			System.err.println("Usage: java Salter <salt_range_min> <salt_range_max>");
			System.exit(1);
		}

		String inputFilename = "initialDataSet.csv";
		String outputFilename = "saltedDataSet.csv";
		double saltRangeMin = Double.parseDouble(args[0]);
		double saltRangeMax = Double.parseDouble(args[1]);

		try (BufferedReader br = new BufferedReader(new FileReader(inputFilename));
				BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilename))) {

			// Write the header row in the output CSV file
			String header = br.readLine();
			bw.write(header + ",Y (Salted)\n");

			String line;
			while ((line = br.readLine()) != null) {

				// Parse x and y values from each line in the input CSV file
				String[] parts = line.split(",");
				double x = Double.parseDouble(parts[0]);
				double y = Double.parseDouble(parts[1]);

				// Add a random number to the y value and write the modified data to the output
				// CSV file
				double salt = Math.random() * (saltRangeMax - saltRangeMin) + saltRangeMin;
				double randomSign = Math.random() < 0.5 ? -1 : 1;
				double saltedY = y + randomSign * salt * Math.random();
				bw.write(String.format("%.2f,%.2f,%.2f\n", x, y, saltedY));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
