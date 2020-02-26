/*
 * ShapesDemo.java
 *
 * Includes the class ShapesDemo which serves as a driver class for Shapes and 
 * its inherited classes, Square, and Circle.
 *
 * Preston MacDonald
 * 08-04-17
 */

import java.util.Scanner;
import java.io.*;

public class ShapesDemo
{

    private static double totalSqArea = 0;
    private static double totalCrArea = 0;
    private static double totalTrArea = 0;

    public static void main(String [] args) throws IOException
    {
        int maxSqI; //Holds index of max square
        int maxCrI; //Holds index of max circle
        int maxTrI; //Holds index of max triangle

        Shape [] shapeA = new Shape[1000];

        //Input
        fileFillA(shapeA, "shapes.txt");

        maxSqI = max(shapeA, "square");
        maxCrI = max(shapeA, "circle");
        maxTrI = max(shapeA, "triangle");

        //Print Info for Squares
        System.out.print("Square with maximum area: ");
        System.out.println(shapeA[maxSqI]);
        System.out.print("Maximum area of square: ");
        System.out.printf("%10.4f\n", shapeA[maxSqI].getArea());

        //Print info for Circles
        System.out.print("Circle with maximum area: ");
        System.out.println(shapeA[maxCrI]);
        System.out.print("Maximum area of Circle: ");
        System.out.printf("%10.4f\n", shapeA[maxCrI].getArea());

        //Print info for Triangles
        System.out.print("Isosceles Triangle with the maximum area: ");
        System.out.println(shapeA[maxTrI]);
        System.out.print("Maximum area of Isosceles Triangle: ");
        System.out.printf("%10.4f\n", shapeA[maxTrI].getArea());

        //Total areas
        System.out.print("Total area covered by the squares: ");
        System.out.printf("%10.4f\n", totalSqArea);
        System.out.print("Total area covered by the circles: ");
        System.out.printf("%10.4f\n", totalCrArea);
        System.out.print("Total area covered by the triangles: ");
        System.out.printf("%10.4f\n", totalTrArea);


    }



    /*
       Method to take in an appropriate file as input and build an array of 
       shape objects which includes circles and squares. The array is limited
       to 1000 elements. In the process the calculation of the total area 
       coverage of each type is also handled.
     */
    private static void fileFillA(Shape [] a, String fName) throws IOException
    {
        File fp = new File(fName);
        Scanner input = new Scanner(fp);
        int i = 0;

        while(input.hasNext())
        {
            String word = input.next();
            double field = input.nextDouble();
            double fieldTwo;

            if(word.equals("square"))
            {
                a[i] = new Square(field);

                //Sums total area of squares
                totalSqArea += a[i].getArea();
            }
            else if(word.equals("circle"))
            {
                a[i] = new Circle(field);

                //Sums total area of circles
                totalCrArea += a[i].getArea(); //sum of total area covered
            }
            else if(word.equals("triangle"))
            {
                fieldTwo = input.nextDouble();

                a[i] = new IsoscelesTriangle(field, fieldTwo);

                //Sums total area of triangles
                totalTrArea += a[i].getArea();
            }

            i++;
        }
    }

    /*
       Method to search within an array of Shapes to find the index of the
       chosen shape with the max area of its kind.
     */
    private static int max(Shape [] a, String shapeType)
    {
        int maxI = 0;
        double x = 0;
        double y = 0;

        for(int i = 0; i < a.length; i++)
        {
            String text = a[i].shapeName();

            if(text.equals(shapeType))
            {
                y = a[i].getArea();

                if(x < y) //Check for new max
                {
                    maxI = i;
                    x = a[maxI].getArea();
                }
            }
        }

        return maxI;
    }

}

