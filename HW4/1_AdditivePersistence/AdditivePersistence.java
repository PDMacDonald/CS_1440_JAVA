/**
 *
 * AdditivePersistance.java
 *
 * the class AdditivePersistence is defined in this file.
 *
 * Preston MacDonald
 * 6-23-2017
 */

import java.util.Scanner;

/*
 * A class that finds the additive persistence and additive root of a positive
 * integer given by the user.
 *
 * The number of times we find a sum of digits is called the additive
 * persistance. The final single digit sum we obtain is called the
 * additive root of the given number.
 *
 */
public class AdditivePersistence
{

    public static void main(String[] args)
    {
        
        //Variables defined
        int userNumber;
        int sum;
        int addPersis;
        int addRoot;

        Scanner keyboard = new Scanner(System.in);
        
        //User Input
        System.out.print("Please input a positive integer to compute its ");
        System.out.print("additive persistence and additive root: " );
        userNumber = keyboard.nextInt();


        //Computation for loop that counts additive persistence 
        for(addPersis = 0; (userNumber / 10) != 0; addPersis++)
        {

            sum = 0;

            //sum of digits 
            while((userNumber / 10) != 0)
            {
                sum += (userNumber % 10);
                userNumber = (userNumber / 10);
            }
            
            //adds the remaining digit to sum
            sum += userNumber;

            userNumber = sum;

        }

        //After Computation remaining digit in userNumber will be additive Root
        addRoot = userNumber;
        
        //Output
        System.out.println("The additive persistence is: " + addPersis);
        System.out.println("The additive root is: " + addRoot);
        
    }
}
