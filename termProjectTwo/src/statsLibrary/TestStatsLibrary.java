package statsLibrary;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class TestStatsLibrary {

	public static void main(String[] args) {

		UpdatedStatsLibrary test = new UpdatedStatsLibrary();
		ArrayList<Integer> someNumbers = new ArrayList<>();
		someNumbers.add(1);
		someNumbers.add(2);
		someNumbers.add(3);
		someNumbers.add(4);
		someNumbers.add(5);
		someNumbers.add(5);
		someNumbers.add(3);

		double mean = test.findMean(someNumbers);
		double median = test.findMedian(someNumbers);
		String mode = test.findMode(someNumbers);
		double sd = test.findSD(someNumbers);

		printMean(mean);
		printMedian(median);
		printMode(mode);
		printSD(sd);

		// test calculateFactorial method
		int n = 5;
		BigInteger factorial = test.calculateFactorial(n);
		printFactorial(factorial, n);

		// test calculateCombinations method
		int r = 3;
		BigInteger combinations = test.calculateCombinations(n, r);
		printCombinations(combinations, n, r);

		// test calculatePermutations method
		BigInteger permutations = test.calculatePermutations(n, r);
		printPermutations(permutations, n, r);

		// test Union method
		ArrayList<Integer> setA = new ArrayList<Integer>();
		setA.add(1);
		setA.add(2);
		setA.add(3);

		ArrayList<Integer> setB = new ArrayList<Integer>();
		setB.add(2);
		setB.add(3);
		setB.add(4);

		ArrayList<Integer> unionSet = test.Union(setA, setB);
		printUnion(unionSet, setA, setB);

		ArrayList<Integer> intersection = test.Intersection(setA, setB);
		printIntersection(intersection, setA, setB);

		ArrayList<Integer> complement = test.Complement(setA, setB);
		printComplement(complement, setA, setB);

		ArrayList<Integer> difference = test.Difference(setA, setB);
		printDifference(difference, setA, setB);

		// test binomialDist method
		int numOfTrials = 10;
		int numOfSuccess = 3;
		double probOfSuccess = 0.5;
		BigDecimal binomialDist = test.binomialDist(numOfTrials, numOfSuccess, probOfSuccess);
		printBinomialDist(binomialDist);

		// test geometricPMF method
		int numOfGeoTrials = 5;
		double geoProbOfSuccess = 0.2;
		double geoPMF = test.geometricPMF(numOfGeoTrials, geoProbOfSuccess);
		printGeometricPMF(geoPMF);

		// test geometricCDF method
		double geoCDF = test.geometricCDF(numOfGeoTrials, geoProbOfSuccess);
		printGeometricCDF(geoCDF);

		// Test poissonDist method
		double lambda = 4.0;
		int k = 3;
		double poissonDist = test.poissonDist(lambda, k);
		printPoissonDist(poissonDist);

		// Test hypergeometricProbDist method
		int Nhyper = 50;
		int Khyper = 10;
		int nHyper = 20;
		int kHyper = 3;
		double hypergeometricProbDist = test.hypergeometricProbDist(Nhyper, Khyper, nHyper, kHyper);
		printHypergeometricProbDist(hypergeometricProbDist);

		// Test uniform probability distribution
		double a = 1.0;
		double b = 5.0;
		double x = 1.0;
		double uniformProb = test.uniformProbDist(a, b, x);
		printUniformProbDist(uniformProb, a, b, x);

		// Test normal probability distribution
		double meanNDist = 10.0;
		double stdDevNDist = 2.0;
		double normalProbNDist = test.normalProbDist(meanNDist, stdDevNDist, x);
		printNormalProbDist(normalProbNDist, mean, stdDevNDist, x);

		// test the joint bivariate distribution
		int[] dataX = { 1, 2, 3, 4 };
		int[] dataY = { 2, 4, 6, 8 };
		double[][] jointDist = test.jointBivariateDist(dataX, dataY);
		System.out.println("Joint (Bivariate) Distribution Function:");
		printMatrix(jointDist);

		// test the marginal probability function
		double[] marginalPDist = test.marginalProbabilityFunction(jointDist, 0);
		System.out.println("Marginal Probability Function of Variable X:");
		printArray(marginalPDist);

		double[] interval = { 0, 2, 4, 6, 8, 10 };
		double[] marginalDDist = test.marginalDensityFunction(jointDist, 0, interval);
		System.out.println("Marginal Density Function of Variable X:");
		printArray(marginalDDist);
	}

	private static void printMean(double mean) {
		System.out.println("The mean is: " + mean);
	}

	private static void printMedian(double median) {
		System.out.println("The median is: " + median);
	}

	private static void printMode(String mode) {
		System.out.println("The mode is: " + mode);
	}

	private static void printSD(double sd) {
		System.out.println("The standard deviation is: " + sd);
	}

	private static void printFactorial(BigInteger factorial, int n) {
		System.out.println("The factorial of " + n + " is: " + factorial);
	}

	private static void printCombinations(BigInteger combinations, int n, int r) {
		System.out.println("The number of combinations of selecting " + r + " items from a group of " + n
				+ " items is: " + combinations);
	}

	private static void printPermutations(BigInteger permutations, int n, int r) {
		System.out.println(
				"The number of permutations of " + r + " items from a group of " + n + " items is: " + permutations);
	}

	private static void printUnion(ArrayList<Integer> unionSet, ArrayList<Integer> setA, ArrayList<Integer> setB) {
		System.out.println("The union of " + setA + " and " + setB + " is: " + unionSet);
	}

	private static void printIntersection(ArrayList<Integer> intersection, ArrayList<Integer> setA,
			ArrayList<Integer> setB) {
		System.out.println("The intersection of " + setA + " and " + setB + " is: " + intersection);
	}

	private static void printComplement(ArrayList<Integer> complement, ArrayList<Integer> setA,
			ArrayList<Integer> setB) {
		System.out.println("The complement of " + setA + " with respect to " + setB + " is: " + complement);
	}

	private static void printDifference(ArrayList<Integer> difference, ArrayList<Integer> setA,
			ArrayList<Integer> setB) {
		System.out.println("The difference between " + setA + " and " + setB + " is: " + difference);
	}

	private static void printBinomialDist(BigDecimal binomialDist) {
		System.out.println("The probability mass function of the binomial distribution is: " + binomialDist);
	}

	private static void printGeometricPMF(double geoPMF) {
		System.out.println("The probability mass function of the geometric distribution is: " + geoPMF);
	}

	private static void printGeometricCDF(double geoCDF) {
		System.out.println("The cumulative distribution function of the geometric distribution is: " + geoCDF);
	}

	private static void printPoissonDist(double poissonDist) {
		System.out.println("The Poisson distribution is: " + poissonDist);
	}

	private static void printHypergeometricProbDist(double hypergeometricProbDist) {
		System.out.println("The hypergeometric probability distribution is: " + hypergeometricProbDist);
	}

	private static void printUniformProbDist(double uniformProb, double a, double b, double x) {
		System.out.println("The uniform probability density for x = " + x + " with range [" + a + ", " + b + "] is: "
				+ uniformProb);
	}

	private static void printNormalProbDist(double normalProb, double mean, double stdDev, double x) {
		System.out.println("The normal probability density for x = " + x + " with mean " + mean
				+ " and standard deviation " + stdDev + " is: " + normalProb);
	}

	public static void printMatrix(double[][] matrix) {
		for (double[] row : matrix) {
			for (double value : row) {
				System.out.print(value + "\t");
			}
			System.out.println();
		}
	}

	public static void printArray(double[] array) {
		for (double value : array) {
			System.out.print(value + "\t");
		}
		System.out.println();
	}

}
