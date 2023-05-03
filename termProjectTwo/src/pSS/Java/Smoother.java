/**
 * This class provides methods to read a CSV file containing data, smooth the values in the third column
 * of the data (the salted Y values), and write the smoothed data to a new CSV file.
 */
package pSS.Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Smoother {

	/**
	 * The main method reads an input CSV file, calculates the smoothed values of
	 * the third column of the data using a sliding window of a specified size, and
	 * writes the data and the smoothed values to an output CSV file.
	 *
	 * @param args The command-line arguments. The first argument specifies the size
	 *             of the window. Must be a positive integer. Example: java Smoother
	 *             3 This sets the window size to 3.
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println(
					"To run the code open a terminal window at this files location and enter the following command: java Smoother <window_size>");
			System.exit(1);
		}
		String inputFile = "saltedDataSet.csv";
		String outputFile = "smoothedDataSet.csv";
		int windowSize = Integer.parseInt(args[0]);

		// Read CSV file that is given as the input (the same CSV file created by
		// Salter.java)
		List<String[]> data = readCsv("saltedDataSet.csv");
		List<Double> smoothedYValues = calculateSmoothedYValues(data, windowSize);
		writeCsv("smoothedDataSet.csv", data, smoothedYValues);
	}

	/**
	 * Reads a CSV file and returns a list of its rows as string arrays. The first
	 * row (headers) is skipped.
	 *
	 * @param fileName The name of the input CSV file.
	 * @return A list of string arrays representing the rows of the CSV file.
	 */
	private static List<String[]> readCsv(String fileName) {
		List<String[]> data = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			boolean firstLine = true;
			while ((line = br.readLine()) != null) {
				if (firstLine) {
					firstLine = false;
					continue; // Skip the first row which is the headers such as x and y
				}
				String[] values = line.split(",");
				data.add(values);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * Calculates the smoothed values of the third column of the data using a
	 * sliding window of a given size.
	 *
	 * @param data       The data as a list of string arrays.
	 * @param windowSize The size of the sliding window.
	 * @return A list of the smoothed values of the third column of the data.
	 */
	private static List<Double> calculateSmoothedYValues(List<String[]> data, int windowSize) {
		List<Double> smoothedYValues = new ArrayList<>();
		for (int i = 0; i < data.size(); i++) {
			double sum = 0;
			int count = 0;
			for (int j = Math.max(0, i - windowSize); j <= Math.min(data.size() - 1, i + windowSize); j++) {
				double y = Double.parseDouble(data.get(j)[2]);
				sum += y;
				count++;
			}
			double average = sum / count;
			smoothedYValues.add(average);
		}
		return smoothedYValues;
	}

	/**
	 * Writes the data and the corresponding smoothed values to a new CSV file. Rows
	 * with an incorrect number of columns are skipped.
	 * 
	 * @param fileName        The name of the output CSV file.
	 * @param data            The original data as a list of string arrays.
	 * @param smoothedYValues The smoothed values of the third column of the data.
	 * @throws IOException If there's an issue with reading or writing the file.
	 */
	private static void writeCsv(String fileName, List<String[]> data, List<Double> smoothedYValues) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
			bw.write("X,Y,Y (Salted),Y (Smoothed)\n");
			for (int i = 0; i < data.size(); i++) {
				String[] row = data.get(i);
				if (row.length != 3) { // Check the number of columns
					System.out.println("Invalid row: " + Arrays.toString(row));
					continue;
				}
				double smoothedY = smoothedYValues.get(i);
				bw.write(row[0] + "," + row[1] + "," + row[2] + "," + smoothedY + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
