/*
 * CyclicShift.java
 *
 * Includes the class cyclicShift and its methods.
 *
 * Preston MacDonald
 * Last Edit: 7-22-17
 */

import java.util.Scanner;

/* Creates an array with the elements 1-100 and accepts an integer to shift the
 * the elements in the array forward by the amount.
 */
public class CyclicShift
{

    public static void main(String [] args)
    {
        //Variables
        int shiftLength;
        int arraySize  = 100; //Sets the size of the array to be shifted.
        Scanner kb = new Scanner(System.in);
        
        //Input
        int [] intArray = incArrayFill(arraySize, 1);

        //User input for shift length
        System.out.print("Please input an integer value to shift the ");
        System.out.println("elements of an array: ");
        shiftLength = kb.nextInt();

        //Output
        System.out.println("Original Array: ");
        printArray(intArray);
       
        System.out.println("Shifted Array: "); 
        printArray(shiftArray(intArray, shiftLength));       
        
    }

    /*
         Short for Incremental Array Filler which sets elements in an array to
         int values starting at a given value (startingelement)and increases 
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
         Method to print out an array element by element in a row.
     */
    private static void printArray(int [] array)
    {
        for (int i: array)
        {
            System.out.print(i + " ");
        }
        System.out.println();   
    }

    /*
         Shifts elements in an array to the right by a given argument and wraps
         end values to the beginning.
     */
    private static int [] shiftArray(int [] array, int shift)
    {
        int [] newArray = new int[array.length];
        shift = shift % array.length;
        
        for(int i = 0; i < array.length; i++)
        {
            if((i - shift) >= 0)
            {
                newArray[i] = array[i - shift];
            }
            else
            {
                newArray[i] = array[(i - shift) + array.length];
            }
        }

        return newArray;
    }

}
