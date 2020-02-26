/**
 *  CodeMaker.java
 *
 *  Includes the class CodeMaker and its methods.
 *
 *  Preston MacDonald
 *  07-11-2017
 *  --updated and created new methods for the CodeMaker class.
 */

import java.util.Random;

/**
	This class implements the code maker.
*/
public class CodeMaker {
	private String code;		// Stores the codeword
	private Random rand;		// Random object used to generate a random codeword.
    private int guessCount;     // Stores number of valid responses
    private boolean gameWon;   // Stores boolean to show if the game is won or not.
	private final String colors = "ROYGBV";		// A list of possible colors.
	private final int numColors = 6;		// The total numbe of colors
	private final int codeLength = 4;		// The total length of the codeword.
	/**
		Constructor: creates a random codeword.
	*/
	public CodeMaker() {
		// TODO: Create a random codeword of length 4 (codeLength) from the possible list of colors (colors) and store the codeword in code.
        
        code = "";
        rand = new Random();
        guessCount = 0;

        //Random Code Generator
        for(int i = 0; i < codeLength; i++)
        {
            switch(rand.nextInt(numColors))
            {
                case 0: code += "R"; break;
                case 1: code += "O"; break;
                case 2: code += "Y"; break;
                case 3: code += "G"; break;
                case 4: code += "B"; break;
                case 5: code += "V"; break;
            }
        }
	}

	/**
		Returns the codeword.
	*/
	public String getCode() {
		return code;
	}
	
	/**
		Returns the length of the code.
	*/
	public int getCodeLength() {
		return codeLength;
	}

    /**
        Returns the number of valid responses made.
    */
    public int getGuessCount() 
    {
        return guessCount;
    }
    /**
        Returns if the game has been won (true) or not (false)
    */
    public boolean isGameWon()
    {
        return gameWon;
    }

	/**
		Takes a guess as argument, and returns the feedback for the guess.	
	*/
	public String response(String guess) {
		// TODO: Store the response in resp. This is returned as the feedback.
		String resp = ""; // The response that is returned.
        int bulls = 0;
        int cows = 0;
        String tempCode = code;
        
        guess = guess.toUpperCase();

         if(validInput(guess))
         {
             StringBuilder codeB = new StringBuilder(tempCode);
             StringBuilder guessB = new StringBuilder(guess);
             guessCount++;
             
             //Bulls counter
             for(int i = 0; i < codeLength; i++)
             {
                 if(tempCode.charAt(i) == guess.charAt(i))
                 {
                     codeB.setCharAt(i, 'x');
                     guessB.setCharAt(i, '*');
                     tempCode = codeB.toString();
                     guess = guessB.toString();
                     bulls++;
                 }
             }
             //Cows counter
             for(int i = 0; i < codeLength; i++)
             {
                 for(int j = 0; j < codeLength; j++)
                 {
                     if(tempCode.charAt(i) == guess.charAt(j))
                     {
                         codeB.setCharAt(i, 'x');
                         guessB.setCharAt(j, '*');
                         tempCode = codeB.toString();
                         guess = guessB.toString();
                         cows++;
                     }
                 }
             }
             resp = bulls + "B" + cows + "C";
             if(bulls == 4)
             {
                 gameWon = true;
             }
         }
         else
         {
             resp = "Invalid Input!";    
         }
		
		return resp; 
	}

    /**
        Checks for proper input for responses and returns either true or false
    */
    private boolean validInput(String input)
    {
        if(input.length() == codeLength)
        {       
            for(int i = 0; i < codeLength; i++)
            {
                switch(input.charAt(i))
                {
                    case 'R': break;
                    case 'O': break;
                    case 'Y': break;
                    case 'G': break;
                    case 'B': break;
                    case 'V': break;
                    default: return false;
                }                
            }           
            return true;
        }
        else
        {
        return false;
        }
    }


}
