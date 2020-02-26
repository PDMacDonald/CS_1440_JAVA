/*
 * Mines.java
 *
 * Includes the class Mines and its methods.
 *
 * Preston MacDonald
 * Last Edit: 7-23-2017
 */

import java.util.Scanner;
import java.io.*;

/*
 * A class that reads in a mines.txt into a 16x16 array grid and displays the
 * final configuration of the values stored in all non-mine locations.
 */
public class Mines
{
    static final int rows = 16;
    static final int columns = 16;


    public static void main(String [] args) throws IOException
    {
        //Variables
        char [][] field = new char[columns][rows];
         
        //Populate Array
        fileFillA(field, "mines.txt");

        //Algorithm
        field = sweeperArray(field);

        //output
        printMineField(field); 
           
    }
    
    /*
         Method to write a file into an array
     */
    private static void fileFillA(char [][] a, String fName) throws IOException
    {
        File fp = new File(fName);
        Scanner input = new Scanner(fp);

        while(input.hasNext())
        {
            for(int i = 0; i < rows; i++) // rows
            {
                String text = input.nextLine(); //txt lines = row

                for(int j = 0; j < columns; j++) //columns
                {
                    a[j][i] = text.charAt(j);
                }
            }
        }
    }
    /*
         Method to fill out the array with numbers representing the count of
         bombs surround the position in the array.
     */
    private static char [][] sweeperArray(char [][] mArray)
    {
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                if(mArray[j][i] != '*') //skips bomb spots
                {
                    int temp = countBombs(mArray, j, i);// checks for bombs
                    
                    if(temp > 0) //if there is a bomb
                    {
                        mArray[j][i] = (char)(48 + temp);
                    }   
                }
            }
        }
        return mArray;

    }


    /*
         A method that takes in a multi dimensional array representing a mine
         field along with a set of indexes to check if there are any mines 
         around the index. Mines are identified by the character *.
         Note** method only checks around 1 point in the array not including
         the point itself.
     */
    private static int countBombs(char [][] mArray, int col, int row)
    {
        int bombCount = 0;

        for(int i = row - 1; i < row + 2; i++) //rows
        {   
            for(int j = col -1; j < col + 2; j++) //columns
            {
                //Checks if in bounds of array
                if(i >= 0 && i < rows && j >= 0 && j < columns)
                {
                    if(i == row && j == col) //ignores center point
                    {
                        continue;
                    }
                    else if(mArray[j][i] == '*')
                    {
                        bombCount++;
                    }
                }             
            }
        }       
        return bombCount;
           
    }
    
    
    /*
         Method to print out a multi-dimensional array.
     */
    private static void printMineField(char [][] mArray)
    {
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                System.out.print(mArray[j][i] + " ");
            }
            
            System.out.println("\n");  
        }
    }
   
    
}
