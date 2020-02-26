/**
 * SquareRoot.java
 *
 * the class SquareRoot is defined in this file.
 *
 * Preston MacDonald
 * 06-23-17
 */

import java.util.Scanner;
import java.lang.Math;

/*
 * Class that uses Newton-Raphson's method to calculate square roots of numbers
 * along with the Math.sqrt method to compare the 2 results
 */
public class SquareRoot
{

    public static void main(String [] args)
    {
        
        //variables
        double num;
        double precision;
        double x;
        double prevX;
        double y;
        double yPrime;

        Scanner keyboard = new Scanner(System.in);
        
        //user input
        System.out.print("Please input a positive real number to calculate ");
        System.out.print("its square root: ");
        num = keyboard.nextDouble();
        
        //predefined guess to start at
        x = 1;
        prevX  = 0;

        //Computation with Newton-Raphson's Method
        precision = 1e-15;

        for(int i = 0; Math.abs(x - prevX) > precision; i++)
        {
           
            System.out.println("Iteration " + i + ": " + x);
                        
            y = (x * x) - num;
            yPrime = (2 * x);

            prevX = x;
            x = x - (y / yPrime);

        }
        
        //output of both Newton-Raphson's method and the Math.sqrt method
        System.out.print("The square root (using Newton-Raphson's method) ");
        System.out.println("is: " + x);
                       
        System.out.println("The square root (using Math.sqrt) is: " +
                            Math.sqrt(num));

    }
}
  
 
