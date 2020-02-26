/*
 * Circle.java
 *
 * includes the class Circle which is inherited from Shapes.
 *
 * Preston MacDonald
 * last edit: 08-05-17
 */

public class Circle implements Shape
{
    private double radius;

    //Constructor
    public Circle(double r)
    {
        radius = r;
    }

    //Method to return the radius of the circle.
    public double getRadius()
    {
        return radius;
    }

    //Method to set the radius of the circle.
    public void setRadius(double r)
    {
        radius = r;
    }

    /*
    Method to override the toString method in order to display appropriate
    String results.
    */
    public String toString()
    {
        return "Circle with radius " + radius;
    }
    
    //Method to calculate and return the area of the circle
    public double getArea()
    {
        return Math.pow(radius, 2) * Math.PI;
    }

    //Method to return the name of the object
    public String shapeName()
    {
        return "circle";
    }
}
