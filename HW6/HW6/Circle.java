/**
 * Circle.java
 *
 * includes the class Circle and its methods.
 *
 * Preston MacDonald
 * last Edit: 7-15-17
 */
 
public class Circle {
	private double x; // The centre of the circle is at the point (x, y)
	private double y;
	private double r; // The radius of the circle.
	private static final double prec = 1e-12; // Precision to make comparisons.

	public Circle(double x, double y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}

	/**
		This method tests if the point (px, py) is inside or outside the circle. 
	*/
	public boolean inside(double px, double py) {
		// TODO: Please return true if the point (px, py) is inside the circle (upto prec amounts of precision).

        double d;
        
        d = Math.sqrt(Math.pow((px - x), 2) + Math.pow((py - y), 2));

        if(d < (r + prec))
        {
            return true;
        }
        else
        {
            return false;
        }
	
	}
}
