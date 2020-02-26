/*
 * PrimeNumberTheory.java
 *
 * Includes the class PrimeNumberTheory and its methods.
 *
 * Preston MacDonald
 * Last Edit: 07-19-17
 */

import java.util.Random;

public class PrimeNumberTheory {
	private static Random rand;	// To sample random numbers.
	private static int numIterations;	// Number of iterations to perform the experiment.
	private static int numTries;			// Number of samples or tries taken until a prime numbe is found.
	private static long primeNumber;	// Stores a generated prime number in the desired range.
    private static long n;   // Stores the range of randomly generated numbers

	public static void main(String [] args) {

		rand = new Random();
		numIterations = 10000;
        n = 1000000; // Determines starting range

		System.out.printf("%14s\t%12s\t%24s\t%16s\n", "range (0 to n)", "Prime Number", "Expected number", "Natural log");
		System.out.printf("%14s\t%12s\t%16s\t%16s\n", "", "", "of tries", "of n");

		// TODO: Write code to fill the table for values of n = 10^6 and multiplicatively increasing by 10 up to 10^10.
	 	// For each of the ranges 1...n, compute the expected number of tries (over 10000 iterations given by numIterations) needed to find a prime number in the range.
		// Also print the prime number found (during any iteration) and the value of the natural log of n.
 
        for(int i = 0; i < 5; i++) {

            System.out.printf("%14d\t%12d\t%24f\t%16f\n", n, getPrimeNum(n), primeIterator(n), Math.log(n));
            n *= 10;
        }
   }	



    /*
         Method to detect whether a given integer is prime or not by checking
         divisibility by any number in its range.
     */
    private static boolean isPrime(long num) {
        
        //check if even
        if((num > 2 && num % 2 == 0)) {
         
            return false;
        }
        
        //Final check
        for(int i = 3;  i <= Math.sqrt(num); i += 2) {
            if((num % i) == 0 || num <= 1) {
                
                return false;
            }
        }

        return true;    
    }

    /*
         Method to obtain a prime number by utilizing the method isPrime()
     */
    private static long getPrimeNum(long range) {
        
        numTries = 0;

        do {

            numTries++;
            primeNumber =(long)(rand.nextDouble() * range);
        }
        while(isPrime(primeNumber) == false);

        return primeNumber;
    }

    /*
         Method to run multiple iterations of generating a prime number to 
         calculate the avg or expected values of tries before a prime number
         is returned.
     */
    private static double primeIterator(long range) {
        double sum = 0;

        // Iteration loop
        for(int i = 0; i < numIterations; i++) {

            getPrimeNum(range);
            sum += numTries;
        }

        //Output of Average or expect value of tries.
        return sum / numIterations;      
    }   
 }
