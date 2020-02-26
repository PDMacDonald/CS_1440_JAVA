/*
 * Sieve.java
 *
 * Includes the class Sieve and its methods.
 *
 * Preston MacDonald
 * Last Edit: 7-22-2017
 */

import java.util.Scanner;
import java.io.*;

/* 
 * Class to compute all the primes in a given range by usings the Sieve of
 * Eratosthenes alogrithm. The algorithm utilizes an array where it finds the
 * next prime number by moving to the next non-marked number and marks all
 * multiples of each prime found.
 */
public class Sieve
{

    public static void main(String [] args) throws IOException
    {
        //Variables
        int [] intArray;
        int [] primeArray;        
        int range;
        int firstElement = 2; // Determines the starting element
        Scanner kb = new Scanner(System.in);
        PrintWriter pw = new PrintWriter("primes.txt");
        
        //Input
        System.out.print("Please input a integer to find all primes ");
        System.out.print("between " + firstElement + " and: ");
        range = kb.nextInt();
        
        //Create an Array
        range = range - firstElement + 1; //adjusts to reflect range of values
        intArray = incArrayFill(range, firstElement);

        //Algorithm
        primeArray = findArrayPrimes(intArray);
        
        //Output
        for(int i = 0; i < primeArray.length; i++)
        {
            if(primeArray[i] != 0)
            {
                pw.println(primeArray[i]);
            }
        }
        pw.close();
        System.out.print("The primes in the given range has successfully ");
        System.out.println("printed to primes.txt.");
    }


    /*
         Short for incremental array filler which sets elements in an array to
         integer values starting at a given value (startingelement) and increases
         by 1 through each element in the array till it reaches the end of the
         array.
     */
    private static int [] incArrayFill(int arraySize, int startingElement)
    {
        int [] newArray = new int[arraySize];

        for(int i = 0; i < arraySize; i++)
        {
            newArray[i] = startingElement;
            startingElement++;
        }

        return newArray;
    }

    /* 
         method that uses The Sieve of Eratosthenes algorithm to find prime 
         numbers in a given array. Any multiple of a prime is then marked out
         by making it equal to 0.
     */
    private static int [] findArrayPrimes(int [] array)
    {
        
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] != 0)
            {

                for(int j = i + array[i]; j < array.length; j += array[i])
                {
                    array[j] = 0;
                }       
            }
        }

       return array;
    }
}   
