/*
 * IsoscelesTriangle.java
 *
 * Includes the class IsoscelesTriangle which implements the interface Shape.
 *
 * Preston MacDonald
 * Last edit: 08-05-17
 */

public class IsoscelesTriangle implements Shape
{
    //Attributes
    private double base;
    private double height;

    //Argument Constructor
    public IsoscelesTriangle(double b, double h)
    {
        base = b;
        height =  h;
    }

    //Method to return the value base.
    public double getBase()
    {
        return base;
    }

    //Method to return the value of height.
    public double getHeight()
    {
        return height;
    }

    //Method to set the value of base.
    public void setBase(double b)
    {
        base = b;
    }

    //Method to set the value of height.
    public void setHeight(double h)
    {
        height = h;
    }
    /*
       Method to overide the default toString() to display the appropriate 
       String representation.
     */
    public String toString()
    {
        return "Isosceles Triangle with base " + base + 
            " and height " + height;
    }

    //Method to get the area of the Isosceles Triangle
    public double getArea()
    {
        return (1.0/2) * base * height;
    }

    //Method to return the name of the shape.
    public String shapeName()
    {
        return "triangle";
    }

}

