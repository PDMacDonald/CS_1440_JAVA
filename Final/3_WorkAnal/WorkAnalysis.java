/*
 * WorkAnalysis.java
 *
 * Includes the class Work Analysis along with it's methods
 *
 * Preston MacDonald
 * Last Edit: 08-05-17
 */

import java.util.Scanner;
import java.io.*;

public class WorkAnalysis
{
    //Arrays to store a single year's results.
    private static String date [] = new String [365];
    private static int hrWorked [] = new int [365];

    
    public static void main(String [] args) throws IOException
    {
    
    fileFillA("daily-hours.txt");

    System.out.println("Top 10 hours worked: ");
    printTopHr(10);
     
    }
    
    /*
     Method to take in file input that includes a date format and a integer
     and places the values into two different arrays keeping the same index
     */
    private static void fileFillA(String fName) throws IOException
    {
        File fp = new File(fName);
        Scanner input = new Scanner(fp);
        
        int i = 0;
        
        while(input.hasNext())
        {
            date[i] = input.next();
            hrWorked[i] = input.nextInt();

            i++;
        }
    }

    /*
     Method that simply takes in an argument that determines how many top 
     entries need to be found such as top 10 top 20... and prints them out
     in ascending order.
     */
    private static void printTopHr(int num)
    {
        int maxI;//holds the index of the maximum hours for the iteration
        String [] a = new String[num];
        
        for(int i = 0; i < num; i++)
        {
            maxI = 0;

            for(int j = 0; j < 365; j++)//Search for max hours
            {
                if(hrWorked[maxI] < hrWorked[j])
                {
                    maxI = j;
                }   
            }

            a[i] = date[maxI] + " " + hrWorked[maxI]; //saves results in array
            hrWorked[maxI] = 0;// "crosses out" the found max
        }

        //Prints small to large
        for(int i = a.length - 1; i >= 0; i--)
        {
            System.out.println(a[i]);
        }
    }      
}
