/*
 * ExtendedEuclid.java
 *
 * Includes the class ExtendedEuclid along with it's methods.
 *
 * Preston MacDonald
 * Last Edit: 08-07-17
 */

import java.util.Scanner;

public class ExtendedEuclid
{
    
    static int memA;
    static int memB;

    public static void main(String [] args)
    {
        int firNum;
        int secNum;
        
        Scanner kb = new Scanner(System.in);

        //Input
        System.out.print("Enter the first number: ");
        firNum = kb.nextInt();
        System.out.print("Enter the second number: ");
        secNum = kb.nextInt();
        
        memA = firNum;
        memB = secNum;
        extendedEuclid(firNum, secNum, 1, 0, 0, 1);
    }

    
    private static void extendedEuclid(int a, int b, int px, int py, int x, int y)
    {
        if(b == 0)
        {
            System.out.print("The gcd of " + memA + " and " + memB + " is ");
            System.out.println(a);
            System.out.print(a + " = " + px + " * " + memA + " + " + py);
            System.out.println(" * " + memB);
            return;
        }

        int q = a / b;
        int tempx = x;
        int tempy = y;
        x = -x * q + px;
        y = -y * q + py;
        py = tempy;
       px = tempx;
        extendedEuclid(b, a % b, px, py, x, y);
    }
    
}
