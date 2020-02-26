/**
 * Mickey.java
 *
 * Includes the class Mickey.
 *
 * Preston MacDonald
 * Last Edit: 07-19-17
 */
import java.util.Random;

public class Mickey {
	
	private static Random rand;		// A random object to sample points.
	private static Circle face;		// The circle that represents the face.
	private static Circle left;		// The circle that represents the left ear.
	private static Circle right;	// The circle that represents the right ear.
	private static double horizontalLength;	// The horizontal length of the rectangle.
	private static double verticalLength;		// The vertival length of the rectangle.
	private static double areaScene;				// The area of the rectangle.
	private static int numIterations;				// Total number of iterations to sample points.

	public static void main(String [] args) {
		// Initializing appropriate data types.
		rand = new Random();
		horizontalLength = 26;
		verticalLength = 24;
		areaScene = horizontalLength * verticalLength;
		face = new Circle(0, 0, 10);
		left = new Circle(-8, 8, 3);
		right = new Circle(8, 8, 3);

		// TODO: Please write code to compute the area of Mickey's face using a sample of 100, 1000, 10000, 100000 and 1000000 points.
		// Please display your results as a table: # points		area (units)
	    
        //Variables
        int n = 100; //Starting count of random points
        double area;

        //Chart Headings
        System.out.printf("%12s\t%20s\n", "# points", "area (units)");

        
        for (int i = 0; i < 5; i++ ) {
            
            //Algorithm
            area = areaIterator(n);       
            
            //Output
            System.out.printf("%12d\t%20.5f\n", n, area);
            
            //Incrementor
            n *= 10;   
        }	         
	}

    /*
         Algorithm to compute area via Monte-Carlo
     */
    private static double Area(int sampleCount) {
        
        int c = 0; // Counter for points contained in circle
        
        for (int k = 0; k < sampleCount; k++) {
               
            double x = (rand.nextDouble() * 26) - 13; 
            double y = (rand.nextDouble() * 24) - 10; 
            
            //Uses the circle method inside to determine if inside
            if(face.inside(x, y) || left.inside(x, y) || right.inside(x, y)) {
                c++;
            }
        }
        double area = ((1.0 * c) / sampleCount) * areaScene;

        return area;
    }
    
    /*
        Method to take the average of the areas computed via the 
        area(int sampleCount) method up to a certain amount of iterations to
        provide better probability of a more accurate result. 
     */
    private static double areaIterator(int samples) {
        
        //Variables
        double averageApproxArea;
        double approxArea;
        int iterations = 100;
        double sum = 0;
        
        //Algorithm to attain a sum of approximate areas
        for(int j = 0; j < iterations; j++) {
            approxArea = Area(samples);
            sum += approxArea;
        } 
        
        //Compute Average Approximate area
        averageApproxArea = sum / iterations;
        
        //output
        return averageApproxArea;         
    }
    
}
