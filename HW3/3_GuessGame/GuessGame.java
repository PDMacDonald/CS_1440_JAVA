/**
 * GuessGame.java
 *
 * the class GuessGame is defined in this file.
 *
 * Preston MacDonald
 * 06-14-2017
 */

import java.util.Scanner;

/*
 * A class that allows the user to guess a mystery number held by the computer.
 *
 * Guesses are obtained from the keyboard via a Scanner object. Based on input
 * the program will return messages that provides hints to the user such as
 * "guess higher", "guess lower" and "out of guesses." Interaction with the
 * MysteryNumber class is limited through the method guessNum(x) which is
 * its only public method.
 */
public class GuessGame
{
    
    public static void main(String [] args)
    {

        // Variables Declared
        int userGuess;
        int answerEval;

        Scanner keyboard = new Scanner(System.in);
        MysteryNumber answer = new MysteryNumber();
 
        for(int guessCount = 0; guessCount <= 9; guessCount++)
        {
           
            //Remaining Guesses Indicator
            System.out.println("You have " + (10 - guessCount) +
                               " guesses remaining.\n");

            // User Input within nested do-while to check for appropriate input
            do
            {
                System.out.print("Make an appropriate guess: ");
                userGuess = keyboard.nextInt();
            }
            while(!(userGuess >= 1 && userGuess <= 1000));

            answerEval = answer.guessNum(userGuess);
            
            // output
            if(answerEval == 0)
            {
                System.out.println("You got it!");
                break;
            }
            else if(answerEval == (-1) && guessCount < 9)
            {
                System.out.println("Guess Lower");
            }
            else if(answerEval == 1 && guessCount < 9)
            {
                System.out.println("Guess Higher");
            }
            else if(answerEval == (-2) || guessCount == 9)
            {
                System.out.println("You have no more guesses.");
            }
        }

        
    }
}
