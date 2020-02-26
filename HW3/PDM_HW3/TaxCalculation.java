/**
 * TaxCalculation.java
 *
 * The class TaxCalculation is defined in this file.
 *
 * Preston MacDonald
 * 06-07-2017
 */

import java.util.Scanner;

/**
 * A class that will accept the taxable income from the user who files single
 * and determine his/her total tax. 
 *
 * Displays the tax brackets for the year 2017 as a table, accepts the total
 * taxable income from the user and displays the total tax owed. The total
 * tax owed to only 2 places of decimal.
 */
public class TaxCalculation
{

    public static void main(String[] args)
    {
     
        //Variables defined
        double taxableInc;
        double taxOwed;

        Scanner keyboard = new Scanner(System.in);

        // Formatted Tax bracket chart
        System.out.println("\nSingle Taxable Income Tax Brackets and Rates, ");
        System.out.println("For the Year 2017\n");

        System.out.printf("%-6s | %-24s | %-80s\n",
                          "Rate",
                          "Taxable Income Bracket",
                          "Tax Owed");
        System.out.println("-------------------------------------------------");
        System.out.printf("%-6s | %-24s | %-80s\n",
                          "10%",
                          "$0 to $9,325",
                          "10% of Taxable Income");
        System.out.printf("%-6s | %-24s | %-80s\n",
                          "15%",
                          "$9,325 to $37,958",
                          "$932.50 plus 15% of the excess over $9,325");
        System.out.printf("%-6s | %-24s | %-80s\n",
                          "25%",
                          "$37,958 to $91,900",
                          "$5226.25 plus 25% of the excess over $37,950");
        System.out.printf("%-6s | %-24s | %-80s\n",
                          "28%",
                          "$91,900 to $191,650",
                          "$18,713.75 plus 28% of the excess over $91,900");
        System.out.printf("%-6s | %-24s | %-80s\n",
                          "33%",
                          "$191,650 to $416,700",
                          "$46,643.75 plus 33% of the excess over $191,650");
        System.out.printf("%-6s | %-24s | %-80s\n",
                          "35%",
                          "$416,700 to $418,400",
                          "$120,910.25 plus 35% of the excess over $416,700");
        System.out.printf("%-6s | %-24s | %-80s\n",
                          "39.6%",
                          "$418,400+",
                          "$121,505.25 plus 39.6% of the excess over $418,400");
                          
        //User Input
        System.out.print("\nEnter the taxable income (in $): ");
        taxableInc = keyboard.nextDouble();
        
        // Tax Owed calculation based on bracket charted above
        if(taxableInc >= 0 && taxableInc < 9325)
        {
            taxOwed = (taxableInc * 0.10);
        }
        else if(taxableInc >= 9325 && taxableInc < 37958)
        {
            taxOwed = 932.50 + ((taxableInc - 9325) * 0.15);
        }
        else if(taxableInc >= 37958 && taxableInc < 91900)
        {
            taxOwed = 5226.25 + ((taxableInc - 37950) * 0.25);
        }
        else if(taxableInc >= 91900 && taxableInc < 191650)
        {
            taxOwed = 18713.75 + ((taxableInc - 91900) * 0.28);
        }
        else if(taxableInc >= 191650 && taxableInc < 416700)
        {
            taxOwed = 46643.75 + ((taxableInc - 191650) * 0.33);
        }
        else if(taxableInc >= 416700 && taxableInc < 418400)
        {
            taxOwed = 120910.25 + ((taxableInc - 416700) * 0.35);
        }
        else
        {
            taxOwed = 121505.25 + ((taxableInc - 418400) * 0.396);
        }
        
        //Output of taxed owed
        System.out.printf("\nTotal tax owed: $%,.2f\n", taxOwed);
 
    }
}
