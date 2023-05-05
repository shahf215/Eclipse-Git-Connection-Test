package code.pSS.OtherAPI;

import java.util.Scanner;

import org.jfree.ui.RefineryUtilities;

/**
 * A driver program for generating a chart of smoothed data using salt and
 * window size parameters.
 */
public class PSSDriver {

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
		PlotSaltSmooth plotter = new PlotSaltSmooth("Function Plotter", windowSize, saltRange);
		plotter.pack();
		RefineryUtilities.centerFrameOnScreen(plotter);
		plotter.setVisible(true);
	}
}
