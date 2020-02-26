/**
 * Arbitrage.java
 *
 * includes the class Arbitrage and its methods.
 *
 * Preston MacDonald
 * 07-18-2017
 */

import java.util.Scanner;

/*
 * A class that applies Arbitrage which takes advantages of the price 
 * difference of a particular commodity in two different markets for a profit.
 *
 * This will examine US dollars to Indian rupees and back to US dollars. 
 * The following are the exchange rates: 1 USD = 66.86 INR & 1INR = 0.015 USD
 */
public class Arbitrage
{
    
    static final double usdToInr = 64.28;
    static final double inrToUsd = 0.016;

    public static void main(String [] args)
    {
        
        //Variables   
        double amount;
        double profit;
        Scanner kb = new Scanner(System.in);
        
        //Input
        System.out.println("USD to INR conversion rate is: " + usdToInr);
        System.out.println("INR to USD conversion rate is: " + inrToUsd);
        System.out.print("Input a USD amount to convert to INR and back: ");
        amount = kb.nextDouble();
        
        //Computation
        profit = arbitrage(amount) - amount;
        profit = Math.round(profit * 100) / 100.0;

        //Output
        System.out.printf("You can earn $%.2f USD by arbitrage.\n", profit);
        


    }

    /*
         Takes in a double that represents a USD currency amount and uses 
         arbitrage (converting to INR and back to USD) to return a double
         that represents the profit.
     */
    private static double arbitrage(double num)
    {
        num = num * usdToInr; //convert to Indian rupees
        num = num * inrToUsd; //convert to US dollars

        return num;
    }
}
