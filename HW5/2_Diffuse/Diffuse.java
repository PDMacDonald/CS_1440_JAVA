/**
 * Diffuse.java
 *
 * the class Diffuse is defined in this file.
 *
 * Preston Macdonald
 * 7-01-17
 */

/*
 * class to methodically diffuse the Bomb.class provided by the assignment.
 */
public class Diffuse
{
    
    public static void main(String [] args)
    {
        
        

        Bomb theBomb = new Bomb("diffuse"); // Argument is the password

        theBomb.getGreen();
        theBomb.cutGreen("no");

        theBomb.getBlue();
        theBomb.cutBlue(); //will prompt user for input, do not cut Blue wire

        theBomb.getRed();
        theBomb.cutRed("no", "no", "no");

        // will prompt for password which remains the same
        // you want to cut the red wire
    }
}
