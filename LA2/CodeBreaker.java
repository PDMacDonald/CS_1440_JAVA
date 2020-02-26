/**
 * CodeBreaker.java
 *
 * Includes the class CodeBreaker which serves as a driver for the
 * CodeMaker() class.
 *
 * Preston MacDonald
 * 07-11-2017
 * -- added methods from the CodeMaker class to finish implementation of the
 *    Mastermind or "cows and bulls" game.
 */

import java.util.Scanner;

/**
	Implements the game. Contains the main method to execute
*/
public class CodeBreaker {
	public static void main(String [] args) {
		CodeMaker cm = new CodeMaker();
		Scanner kb = new Scanner(System.in);
        String codeGuess;
        final int guessLimit = 12; //Set guess limit here

		System.out.println("Code Maker: I have a code, can you crack it? You have 12 guesses.");
		System.out.println("The code consists of the following colors. R(Red), O(Orange), Y(Yellow), G(Green), B(Blue), V(Violet).");
		System.out.println("The length of the code is 4. An example code is OGYG.");
		
		// TODO: Implement the game here. Accept at most 12 guesses from the codebreaker (user). Use the response method in the CodeMaker to display feedback to the codebreaker.
		// Write your code here.
		
        int i = guessLimit; //Variable to limit loop

        while(i > 1)
        {
            i = guessLimit - cm.getGuessCount();
            
            //Guess counter and prompt for User Input
            System.out.println("Guesses remaining: " + i);
            System.out.print("Make a guess(type:(quit) to give up): ");
            codeGuess = kb.nextLine();
            
            //Check if user would like to quit
            if(codeGuess.compareTo("quit") == 0)
            {
                break;
            }
            
            //Outputs response to input
            System.out.println(cm.response(codeGuess));
            if(cm.isGameWon())
            {
                System.out.println("Congratulations you won! ");
                break;
            }
            else if(i == 1)
            {
                System.out.println("Out of guesses. ");
            }
        }
        System.out.println("The code was: " + cm.getCode());
		System.out.println("Thanks for playing.");
	}
}
