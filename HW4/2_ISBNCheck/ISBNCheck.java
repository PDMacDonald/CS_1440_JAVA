/**
 * ISBNCheck.java
 *
 * The class ISBNCheck is define in this file.
 *
 * Preston MacDonald
 * 06-23-2017
 */

import java.util.Scanner;

/*
 * A class that will take a input from user and check if it is a valid ISBN-10
 * input.
 *
 * ISBN or International standard book number consists of 10 digits of numbers.
 * The digits of a ISBN must satisfy a special property that the sum of these
 * digits must always be divisible by 11 with no remainder. Another special 
 * property is that the last digit in each ISBN number can range from 0-9 and X
 * A capital X refers to the value 10. The last digit is called the check digit
 * This class will check if a ISBN-10 number is valid based on its ability to 
 * be divided by 11.
 * 
 */
public class ISBNCheck
{

    public static void main(String[] args)
    {
        //Variables
        String ISBN;
        boolean isValid;
        int sum;
        int multiplier;

        Scanner keyboard = new Scanner(System.in);

       
        //Input
        do
        {

            isValid = true;

            // User Input
            System.out.print("Enter an ISBN number: ");
            ISBN = keyboard.nextLine();


            //input length check
            if(ISBN.length() != 10)
            {
                System.out.println("Invalid ISBN length!");
                isValid = false;
            }

            //Character check
            for(int i = 0; i < ISBN.length(); i++)
            {

                if(ISBN.charAt(i) >= 48 && ISBN.charAt(i) <= 57) //48-57 is 0-9
                {
                    continue;
                }
                else if(i == 9 && ISBN.charAt(i) == 'X')
                {
                    continue;
                }
                else
                {
                    System.out.println("Invalid character in ISBN!");
                    isValid = false;
                    break;
                }
            }
        }
        while(isValid == false);


        //check for valid ISBN
        multiplier = 10; 
        sum = 0;

        for(int i = 0; i < ISBN.length(); i++)
        {

             if(ISBN.charAt(i) == 'X')
             {
                 sum += 10;
             }
             else
             {
                 //-48 in unicode brings digits 0-9
                 sum += (ISBN.charAt(i) - 48) * multiplier; 
             }

             --multiplier;

        }


        //output
        if(sum % 11 == 0)
        {
            System.out.println("Your ISBN number is accepted.");
        }
        else
        {
            System.out.println("Invalid ISBN number.");
        }

    }
}
