/**
 *  Sine.java
 *
 *  The class Sine is defined in this file
 *
 *  Preston MacDonald
 *  06-23-2017
 */

import java.lang.Math;

/*
 * A class to compute sine of pi/4  via 10 terms of the taylor series expansion
 *
 * The formula of the taylor series used is the summation starting from i = 0
 * up to inifity of  ((-1)^i) * (1 / (2i+1)!) * x^(2i + 1) which is all equal
 * to sin(x); We approach this problem only using simple arithmetic where in 
 * the end we compare the results to the actual sin function built into Math.
 */
public class Sine
{

    public static void main(String [] args)
    {
        
        //Variables
        int y; 
        double approx;
        double sign;
        double denominator;
        double xPower;
        

        approx = 0;

        //loop for iterations or number of terms for expansion of taylor series
        for(int i = 0; i < 10; i++)
        {
            
            //used to increase readability
            y = (2 * i) + 1;   


            //alternator or numerator portion = (-1)^i
            if((i % 2) == 0)
            {
                sign = 1;
            }
            else
            {
                sign = -1;
            }

            //denominator portion = (2i+1)!
            denominator = 1;   

            for(int j = y; j > 0; --j)
            {
                denominator *= j;    
            }

            //x to a power of portion = x^(2i +1)
            xPower = 1;

            for(int k = y; k > 0; --k)
            {
                xPower *= (Math.PI / 4);
            }
            
            //Final calculation
            approx += (sign * (1 / denominator) * xPower);

            //output of Iteration
            System.out.println("Iteration " + (i+1) + ": " + approx);
                  
        }

        //Output of the Taylor Series of Sin
        System.out.print("Final value of Sine(pi/4) computed using ");
        System.out.println("Taylor series: " + approx);
 
        //Output of Math.sin function
        System.out.print("Value of Sine(pi/4) using Math.sin: ");
        System.out.println( Math.sin(Math.PI / 4) );

    }
}
