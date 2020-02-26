/*
 * Square.java
 *
 * Includes the class Square which is inherited from the interface Shape
 *
 * Preston MacDonald
 * 08-04-17
 */

public class Square implements Shape
{
    private double edge;

    //Constructor
    public Square(double e)
    {
        edge = e;
    }

    //Method to obtain the value of edge.
    public double getEdge()
    {
        return edge;
    }

    //Method to set the value of edge.
    public void setEdge(double e)
    {
        edge = e;
    }
    /*
      Method that overrides the default toString to display an appropriate
      String representation.
     */
    public String toString()
    {
        return "Square with edge " + edge;
    }

    //Method to get the Area of the square.
    public double getArea()
    {
        return edge * edge;
    }

    //Method to return the name of the shape.
    public String shapeName()
    {
        return "square";
    }
}
