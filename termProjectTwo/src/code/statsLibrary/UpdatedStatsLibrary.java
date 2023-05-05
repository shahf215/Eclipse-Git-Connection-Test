/*
 * This class contains methods for calculating statistical measures, such as mean, median, mode, and standard deviation.
 * It also includes methods for calculating factorials, combinations, and permutations.
 */

package code.statsLibrary;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class UpdatedStatsLibrary {

	/**
	 * Returns the average of an ArrayList
	 *
	 * @param inputNumbers : the list integers that will later be created and used
	 *                     to calculate the average.
	 * @return Average of the ArrayList
	 */

	public double findMean(ArrayList<Integer> inputNumbers) {

		double sum = 0;

		// sum of all the individual numbers in the ArrayList "inputNumbers"
		for (int singleElement : inputNumbers) {
			sum += singleElement;
		}

		double result = sum / inputNumbers.size();

		System.out.println("The average is : " + result);
		return result;
	}

	/**
	 * Returns the median of the ArrayList
	 *
	 * @param inputNumbers: the list integers that will later be created and used to
	 *                      calculate the median number in the ArrayList.
	 * @return Median of the ArrayList
	 */

	public double findMedian(ArrayList<Integer> inputNumbers) {

		double median;

		// sort the ArrayList from least to greatest
		Collections.sort(inputNumbers);

		// this if-else statement takes the size of the ArrayList and checking to see if
		// it is odd or even and using that information to find the median
		if (inputNumbers.size() % 2 == 1) {
			return inputNumbers.get((inputNumbers.size() + 1) / 2 - 1);
		}

		else {
			double lowerHalf = inputNumbers.get(inputNumbers.size() / 2 - 1);
			double upperHalf = inputNumbers.get(inputNumbers.size() / 2);

			return median = (lowerHalf + upperHalf) / 2.0;
		}

	}

	/**
	 * Returns the mode of the ArrayList
	 *
	 * @param inputNumbers: the list integers that will later be created and used to
	 *                      find which number in the ArrayList occurs the most
	 *                      times.
	 * @return Mode of ArrayList
	 */

	public String findMode(ArrayList<Integer> inputNumbers) {

		int maxValue = 0;
		int maxCount = 0;
		int i;
		int j;

		for (i = 0; i < inputNumbers.size(); i++) {
			int count = 0;

			for (j = 0; j < inputNumbers.size(); j++) {
				if (inputNumbers.get(j) == inputNumbers.get(i))
					count++;
			}

			if (count > maxCount) {
				maxCount = count;
				maxValue = inputNumbers.get(i);
			}
		}

		int numOfModes = 0;

		// for loop to check if there is more than one mode
		for (i = 0; i < inputNumbers.size(); i++) {
			int count = 0;

			for (j = 0; j < inputNumbers.size(); j++) {
				if (inputNumbers.get(j) == inputNumbers.get(i))
					count++;
			}

			if (count == maxCount && inputNumbers.get(i) != maxValue) {
				numOfModes++;
				break;
			}
		}

		// if statement to check two or more numbers occur the same amount of times. If
		// so it returns an error message and continues to parse the rest of the code.
		if (numOfModes > 0) {
			return "Due to two or more numbers occuring the same amount of times, no mode could be determined";
		} else {
			return String.valueOf(maxValue);
		}
	}

	/**
	 * Returns the standard deviation of the ArrayList
	 *
	 * @param inputNumbers: the list integers that will later be created and used to
	 *                      find which number in the ArrayList occurs the most
	 *                      times.
	 * @return Standard Deviation of ArrayList
	 */
	public double findSD(ArrayList<Integer> inputNumbers) {

		double stdDev = 0.0;
		double mean = findMean(inputNumbers); // we already have a way to calculate the mean so we call that method.

		for (double temp : inputNumbers) {
			stdDev += (Math.pow(temp - mean, 2));
		}

		return Math.sqrt(stdDev / inputNumbers.size());
	}

	/**
	 * Returns the factorial of an integer as a BigInteger. If we cast to int there
	 * would be overflow at the higher ranges.
	 *
	 * @param n : the number for which we want to calculate the factorial of
	 * @return the factorial of an integer
	 */
	public BigInteger calculateFactorial(int n) {

		BigInteger fact = BigInteger.valueOf(1);

		for (int i = 1; i <= n; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}

		return fact;
	}

	/**
	 * Calculates the number of combinations of selecting r number of items from a
	 * group of n number of items.
	 *
	 * @param n the total number of items in the group
	 * @param r the number of items to be selected
	 * @return the number of combinations of selecting r number of items from a
	 *         group of n number of items
	 */
	public BigInteger calculateCombinations(int n, int r) {

		// we call our previous method to calculate the factorials for us
		BigInteger factN = calculateFactorial(n);
		BigInteger factR = calculateFactorial(r);
		BigInteger factNSubR = calculateFactorial(n - r);

		return factN.divide(factR.multiply(factNSubR));
	}

	/**
	 * Calculates the number of permutations of r number of items from a group of n
	 * number of items, where order matters.
	 *
	 * @param n the total number of distinct items
	 * @param r the number of items to be chosen
	 * @return the number of permutations of r items chosen from n distinct items
	 */
	public BigInteger calculatePermutations(int n, int r) {

		BigInteger factN = calculateFactorial(n);
		BigInteger factNSubR = calculateFactorial(n - r);

		return factN.divide(factNSubR);
	}

	/**
	 * Returns the union of two ArrayLists of Integers
	 *
	 * @param SetA the first ArrayList of Integers to be used for the union.
	 * @param SetB the second ArrayList of Integers to be used for the union.
	 * @return an ArrayList of Integers that contains all unique elements from SetA
	 *         and SetB.
	 */
	public ArrayList<Integer> Union(ArrayList<Integer> SetA, ArrayList<Integer> SetB) {

		ArrayList<Integer> newSet = new ArrayList<>(SetA.size() + SetB.size());

		for (int singleElement : SetA) {
			if (newSet.indexOf(singleElement) == -1) {
				newSet.add(singleElement);
			}
		}

		for (int singleElement : SetB) {
			if (newSet.indexOf(singleElement) == -1) {
				newSet.add(singleElement);
			}
		}

		Collections.sort(newSet);
		return newSet;
	}

	/**
	 * Returns the intersection of two ArrayLists of Integers The resulting
	 * ArrayList contains all unique elements from SetA and SetB.
	 *
	 * @param SetA the first ArrayList of Integers
	 * @param SetB the second ArrayList of Integers
	 * @return an ArrayList of integers containing the elements that are present in
	 *         both sets
	 */
	public ArrayList<Integer> Intersection(ArrayList<Integer> SetA, ArrayList<Integer> SetB) {

		ArrayList<Integer> newSet = new ArrayList<>();

		for (int singleElement : SetA) {
			if (SetB.contains(singleElement)) {
				newSet.add(singleElement);
			}
		}

		Collections.sort(newSet);
		return newSet;
	}

	/**
	 * Returns the Complement of two ArrayLists of Integers The resulting ArrayList
	 * contains all elements in SetB that are not in SetA.
	 *
	 * @param SetA the first ArrayList of Integers
	 * @param SetB the second ArrayList of Integers
	 * @return an ArrayList of integers representing the complement of SetA with
	 *         respect to SetB
	 */
	public ArrayList<Integer> Complement(ArrayList<Integer> SetA, ArrayList<Integer> SetB) {

		ArrayList<Integer> newSet = new ArrayList<>();

		for (int singleElement : SetB) {
			newSet.add(singleElement);

			if (SetB.contains(singleElement)) {
				newSet.removeAll(SetA);
			}
		}

		Collections.sort(newSet);
		return newSet;
	}

	/**
	 * Calculates the difference between two sets The resulting ArrayList contains
	 * all elements in SetB that are not in SetA.
	 *
	 * @param SetA the first ArrayList of Integers
	 * @param SetB the second ArrayList of Integers
	 * @return an ArrayList of integers that represents the difference between SetA
	 *         and SetB
	 */
	public ArrayList<Integer> Difference(ArrayList<Integer> SetA, ArrayList<Integer> SetB) {

		ArrayList<Integer> newSet = new ArrayList<>();

		for (int singleElement : SetA) {
			newSet.add(singleElement);

			if (SetA.contains(singleElement)) {
				newSet.removeAll(SetB);
			}

		}

		Collections.sort(newSet);
		return newSet;
	}

	/**
	 * Calculates the probability mass function of the binomial distribution.
	 *
	 * @param numOfTrials   the number of trials
	 * @param numOfSuccess  the number of successful trials
	 * @param probOfSuccess the probability of success in each trial
	 * @return he probability mass function of the binomial distribution
	 */
	public BigDecimal binomialDist(int numOfTrials, int numOfSuccess, double probOfSuccess) {

		// Calculates the number of combinations
		BigInteger comb = calculateCombinations(numOfTrials, numOfSuccess);

		// Calculates the probability of failure
		BigDecimal probOfFail = BigDecimal.ONE.subtract(BigDecimal.valueOf(probOfSuccess));
		BigDecimal binomDist;

		// Calculates the binomial distribution
		binomDist = BigDecimal.valueOf(Math.pow(probOfSuccess, numOfSuccess))
				.multiply(BigDecimal.valueOf(Math.pow(probOfFail.doubleValue(), numOfTrials - numOfSuccess)));
		binomDist = binomDist.multiply(new BigDecimal(comb));

		// Calculates the mean, variance, and standard deviation
		double mean = numOfTrials * probOfSuccess;
		double vari = mean * (1 - probOfSuccess);
		double stdDev = Math.sqrt(mean * (1 - probOfSuccess));

		System.out.println("The mean of the binomial distribution is : " + mean);
		System.out.println("The variance of the binomial distribution is : " + vari);
		System.out.println("The standard deviation of the binomial distribution is : " + stdDev);

		return binomDist;
	}

	/**
	 * Calculates the probability mass function (PMF) of a geometric distribution.
	 *
	 * @param numOfTrials   the number of trials
	 * @param numOfSuccess  the number of successful trials
	 * @param probOfSuccess the probability of success in each trial
	 * @return the probability mass function of the geometric distribution
	 */
	public double geometricPMF(int numOfTrials, double probOfSuccess) {

		// Calculates the probability mass function
		double geoPMF = probOfSuccess * (Math.pow((1 - probOfSuccess), (numOfTrials - 1)));

		// Calculates the mean, variance, and standard deviation
		double mean = 1 / probOfSuccess;
		double vari = (1 - probOfSuccess) / Math.pow(probOfSuccess, 2);
		double stdDev = Math.sqrt(vari);

		System.out.println("The mean of the geometric distribution is : " + mean);
		System.out.println("The variance of the geometric distribution is : " + vari);
		System.out.println("The standard deviation of the geometric distribution is : " + stdDev);

		return geoPMF;
	}

	/**
	 * Calculates the cumulative distribution function (CDF) of a geometric
	 * distribution.
	 *
	 * @param numOfTrials   the number of trials
	 * @param probOfSuccess the probability of success in each trial
	 * @return the CDF of a geometric distribution as a double
	 */
	public double geometricCDF(double numOfTrials, double probOfSuccess) {

		double probOfFail = 1 - probOfSuccess;
		double geoCDF = 0.0;

		for (double i = 1.0; i <= numOfTrials; i++) {
			geoCDF = Math.pow((probOfFail), (numOfTrials - 1));
		}

		return geoCDF;
	}

	/**
	 * Calculates the Poisson distribution of an event happening k times given the
	 * average rate of occurrence lambda.
	 *
	 * @param lambda the average rate of occurrence
	 * @param k      the number of times the event occurred
	 * @return the Poisson distribution
	 */
	public double poissonDist(double lambda, int k) {
		double e = Math.exp(-lambda);
		double numerator = Math.pow(lambda, k);
		double denominator = calculateFactorial(k).doubleValue();
		return (numerator * e) / denominator;
	}

	/**
	 * Calculates the hypergeometric probability distribution of obtaining k
	 * successes in n draws without replacement from a population of size N
	 * containing K successes.
	 *
	 * @param N the population size
	 * @param K the number of successes in the population
	 * @param n the number of draws
	 * @param k the number of successes in the sample
	 * @return the hypergeometric probability distribution
	 */
	public double hypergeometricProbDist(int N, int K, int n, int k) {
		double numerator = calculateCombinations(K, k).doubleValue()
				* calculateCombinations(N - K, n - k).doubleValue();
		double denominator = calculateCombinations(N, n).doubleValue();
		return numerator / denominator;
	}

	/**
	 * Calculates the uniform probability distribution for a given range and x
	 * value.
	 *
	 * @param a the lower bound of the range
	 * @param b the upper bound of the range
	 * @param x the value for which to calculate the probability density
	 * @return the uniform probability density
	 */
	public double uniformProbDist(double a, double b, double x) {
		if (x < a || x > b) {
			return 0.0;
		}
		return 1.0 / (b - a);
	}

	/**
	 * Calculates the normal probability density function for a given mean, standard
	 * deviation, and x value.
	 *
	 * @param mean   the mean of the distribution
	 * @param stdDev the standard deviation of the distribution
	 * @param x      the value for which to calculate the probability density
	 * @return the normal probability density
	 */
	public double normalProbDist(double mean, double stdDev, double x) {
		double numerator = Math.exp(-1.0 * Math.pow(x - mean, 2) / (2 * Math.pow(stdDev, 2)));
		double denominator = stdDev * Math.sqrt(2 * Math.PI);
		return numerator / denominator;
	}

	public double[][] jointBivariateDist(int[] dataX, int[] dataY) {

		int lengthX = dataX.length;
		int lengthY = dataY.length;
		double[][] jointDist = new double[lengthX][lengthY];

		double sumX = 0;
		double sumY = 0;

		// calculate the sum of all values in dataX and dataY
		for (int i = 0; i < lengthX; i++) {
			sumX += dataX[i];
		}
		for (int i = 0; i < lengthY; i++) {
			sumY += dataY[i];
		}

		// calculate the means of dataX and dataY
		double meanX = sumX / lengthX;
		double meanY = sumY / lengthY;

		// calculate the variances of dataX and dataY
		double varX = 0;
		double varY = 0;
		for (int i = 0; i < lengthX; i++) {
			varX += Math.pow((dataX[i] - meanX), 2);
		}
		for (int i = 0; i < lengthY; i++) {
			varY += Math.pow((dataY[i] - meanY), 2);
		}
		varX /= lengthX;
		varY /= lengthY;

		double coVar = 0;
		for (int i = 0; i < lengthX; i++) {
			for (int j = 0; j < lengthY; j++) {
				coVar += (dataX[i] - meanX) * (dataY[j] - meanY);
			}
		}
		coVar /= (lengthX * lengthY);

		// calculate the Joint (Bivariate) Distribution Function
		double stdDevX = Math.sqrt(varX);
		double stdDevY = Math.sqrt(varY);
		double rho = coVar / (stdDevX * stdDevY);
		for (int i = 0; i < lengthX; i++) {
			for (int j = 0; j < lengthY; j++) {
				double x = dataX[i];
				double y = dataY[j];
				jointDist[i][j] = cumulativeProbDist(dataX, x) * cumulativeProbDist(dataY, y);
			}
		}

		return jointDist;
	}

	/**
	 * Calculates the cumulative probability distribution for a given array of
	 * integers and x value.
	 *
	 * @param data the array of integers
	 * @param x    the value for which to calculate the cumulative probability
	 *             distribution
	 * @return the cumulative probability distribution
	 */
	private double cumulativeProbDist(int[] data, double x) {
		int count = 0;
		for (int element : data) {
			if (element <= x) {
				count++;
			}
		}
		return (double) count / data.length;
	}

	/**
	 * Returns the marginal probability function of a joint distribution.
	 *
	 * @param jointDist a 2D array of the joint distribution
	 * @param variable  the variable whose marginal probability function is to be
	 *                  calculated
	 * @return an array of the marginal probabilities for the specified variable
	 */
	public double[] marginalProbabilityFunction(double[][] jointDist, int variable) {

		int numVariables = jointDist[0].length;
		double[] marginalDist = new double[jointDist.length];

		for (int i = 0; i < jointDist.length; i++) {
			marginalDist[i] = jointDist[i][variable];
			for (int j = 0; j < numVariables; j++) {
				if (j != variable) {
					marginalDist[i] += jointDist[i][j];
				}
			}
		}

		return marginalDist;
	}

	/**
	 * Returns the marginal density function of a joint distribution.
	 *
	 * @param jointDist a 2D array of the joint distribution
	 * @param variable  the variable whose marginal density function is to be
	 *                  calculated
	 * @param interval  the interval to compute the density over
	 * @return an array of the marginal density function for the specified variable
	 *         over the given interval
	 */
	public double[] marginalDensityFunction(double[][] jointDist, int variable, double[] interval) {

		int numVariables = jointDist[0].length;
		int numIntervals = interval.length - 1;
		double[] marginalDist = new double[numIntervals];

		for (int i = 0; i < numIntervals; i++) {
			double lowerBound = interval[i];
			double upperBound = interval[i + 1];
			for (double[] element : jointDist) {
				double value = element[variable];
				boolean withinBounds = true;

				for (int k = 0; k < numVariables; k++) {
					if (k != variable) {
						double currValue = element[k];
						if (currValue < lowerBound || currValue > upperBound) {
							withinBounds = false;
							break;
						}
					}
				}

				if (withinBounds) {
					marginalDist[i] += value;
				}
			}
		}

		return marginalDist;
	}
}
