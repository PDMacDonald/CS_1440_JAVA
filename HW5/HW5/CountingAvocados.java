/*
 * CountingAvocados.java
 *
 * you will find the CountingAvocados class in this file
 *
 * Preston MacDonald
 * 7-3-2017
 */

import java.util.Scanner;
import java.io.*;

/*
 * a class that will take in a fruits.txt file and count the times the word
 * avocado appears.
 */
public class CountingAvocados
{

    public static void main(String [] args) throws IOException
    {

        //Variables 
        int avocadoCount;
        String line;

        File  fp = new File("fruits.txt"); //fp short for file pointer 
        Scanner input = new Scanner(fp);
       
        //Avocado counter
        avocadoCount = 0; 

        while(input.hasNext())
        {
            line = input.nextLine();

            if(line.compareToIgnoreCase("avocado") == 0)
            {
                avocadoCount++;
            }

        }

        //Output
        System.out.println("The total amount of Avocados: " + avocadoCount);
       
    }

}
