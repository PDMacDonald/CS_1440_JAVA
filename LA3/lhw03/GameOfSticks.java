/*
 * GameOfSticks.java
 *
 * Includes the class GameOfSticks along with its methods.
 *
 * Preston MacDonald
 * last Edit: 7-30-2017
 */

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class GameOfSticks {
    private static int n; // The number of sticks.
    private static final Scanner kb = new Scanner(System.in);
    private static final Random rand = new Random();
    private static int [][] aiNaiveData;		// The AI data that helps in making choices for the naive AI.
    private static int [][] aiTrainedData;	// The AI data that helps in making choices for the trained AI.
    // aiData[i][j] (for either Naive or Trained data) where i is the number of remaining sticks, 
    // and j is the ball type (either 0, 1 or 2 for ball types 1, 2 and 3 resp.)
    private static final int totalSticks = 3;	// Total number of sticks that can be chosen in a single turn.

    /**
      Clear the screen. Used to print the main menu.
      */
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
      Thus funciton prints the main menu, and accepts and returns a valid option.
      */
    private static int printMenu(int n, Scanner kb) {
        System.out.println("Lets play a game of sticks.");
        System.out.println("This is a 2 player game.");
        System.out.println("There are " + n + " sticks.");
        System.out.println("In each turn a player can choose among 1 to 3 sticks.");
        System.out.println("The player who chooses the last stick looses.");
        System.out.println("\nGame Menu:");
        System.out.println("1. Play against another human.");
        System.out.println("2. Play against a naive A.I.");
        System.out.println("3. Play against a trained A.I.");
        System.out.println("4. Exit application.");
        System.out.print("\nWhat do you choose? [1-4]: ");
        int option = kb.nextInt();
        while (option < 1 && option > 4) {
            System.out.println("Please choose options [1-4]: ");
            option = kb.nextInt();
        }
        return option;
    }

    /**
      This funciton can be used to initialize all the aiData (either aiNaiveData or aiTrainedData) to all 1s. 
      This means that all the hats are set to one of each kind, ie. balls 1, 2 or 3.
      */
    private static void initializeAIData(int [][] aiData) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < totalSticks; j++) {
                aiData[i][j] = 1;
            }
        }
    }

    /**
      This function chooses a number of sticks as input from the human player. This takes as argument the number of remaining sticks. It prompts the user to enter either 1, 2 or 3 sticks and ensures that the human player doesn't choose more sticks than there are remaining. It also displays appropriate messages to the player. It always returns a valid choice that the player made.
      */
    private static int humanChoose(int remSticks) {
        int choose = kb.nextInt();
        while (choose < 1 || choose > 3 || choose > remSticks) {
            if (choose > remSticks)
                System.out.print("There are only \033[32m" + remSticks + "\033[39;49m remaining. Please choose [1..3 or remaining sticks]: ");
            else 
                System.out.print("You can only choose 1, 2 or 3 sticks. There are only \033[32m" + remSticks + "\033[39;49m remaining. Please choose [1..3 or remaining sticks]: ");
            choose = kb.nextInt();
        }
        return choose;
    }

    /**
      This function takes in the number of remaining sticks and the ai data as arguments, and returns a choice made by the AI. 
      aiData can either be aiNaiveData or aiTrainedData. This funciton should look into this data, and make a valid choice.
      Specifically, it should look at aiData[remSticks] -- which is an array of size 3 that contains the number of balls of each type.
      Please write a function that returns either 1, 2 or 3 depending on its weight, i.e., based on the probability of the number of balls of each type.	
      */
    private static int aiChoose(int remSticks, int [][] aiData) {
        // TODO: Return a valid choice for the AI based on the number of sticks remaining and the corresponding AI data passed.
        // This function returns 0 currently.
        
        int sum = aiData[remSticks][0];
        int x; //variable to hold random int value

        if(remSticks >= totalSticks) //when 3 or more sticks are remaining
        {
            sum += aiData[remSticks][1] + aiData[remSticks][2];
            x = rand.nextInt(sum) + 1; //range 1 to sum inclusive
            int bound = aiData[remSticks][0] + aiData[remSticks][1];

            if(x <= aiData[remSticks][0])
            {
                return 1;
            }
            else if(x > aiData[remSticks][0] && x <= bound)
            {
                return 2;
            }
            else
            {
                return 3;
            }
        }
        else if(remSticks == 2) //when 2 sticks are remaining
        {
            sum += aiData[remSticks][1];
            x = rand.nextInt(sum) + 1; //range 1 to sum inclusive

            if(x <= aiData[remSticks][0])
            {
                return 1;
            }
            else
            {
                return 2;
            }
        }

        return 1; //when 1 stick is remaining
    }

    /**
      This method simulates the two player human game.
      */
    private static void playHuman() {
        System.out.println("\nHuman game");

        int remSticks = n;	// This is the number of remaining sticks.

        // TODO: Write code that will display appropriate messages to the human players, accept the input sticks from them and updates the remaining sticks.

        // You can display messages using the following statement. playerTurn is either 0 for player 1 or 1 for player 2.
        int playerTurn = 0;
        int winner = 0;

        while(remSticks != 0)
        {
            playerTurn = 0;
            System.out.print("\033[34mplayer " + (playerTurn + 1));
            System.out.print("\033[39;49m: There are \033[32m" + remSticks);
            System.out.print("\033[39;49m sticks remaining. ");
            System.out.print("How many do you choose [1..3 or remaining sticks]: ");
            remSticks -= humanChoose(remSticks);
            
            if(remSticks != 0)
            {
                playerTurn++;
                System.out.print("\033[34mplayer " + (playerTurn + 1));
                System.out.print("\033[39;49m: There are \033[32m" + remSticks);
                System.out.print("\033[39;49m sticks remaining. ");
                System.out.print("How many do you choose [1..3 or remaining sticks]: ");
                remSticks -= humanChoose(remSticks);
            }
        }

        if(playerTurn == 0) //if last turn is p1 then p2 wins
        {
            winner = 2;
        }
        if(playerTurn == 1) //if last turn is p2 then p1 wins.
        {
            winner = 1;
        }

        System.out.println("\n\033[33mPlayer " + winner + " wins.\033[39;49m");	// Displays the final winner.
    }

    /**
      This function simulates the game - human vs ai. The aiOption indicates which AI to use. 0 is the Naive AI and 1 is the Trained AI.
      aiData is set based on the aiOption. From here, both games (human vs Naive AI or human vs Trained AI) go through the same process (and hence no need to write two functions).
      */
    private static void playAI(int aiOption) {
        // Initialize appropriate aiData.
        int [][] aiData;
        if (aiOption == 0) {
            System.out.println("\nNaive AI");
            aiData = aiNaiveData;
        }
        else {
            System.out.println("\nTrained AI");
            aiData = aiTrainedData;
        }

        int remSticks = n;		// The number of sticks remaining.
        int humanPlayer = 1;	// The humman player
        int aiPlayer = 2;			// The AI player
        int choose;						// Holds the choice of either the human or the AI player
        int [] aiChoices = new int[n + 1];	// The choices that the AI makes in one iteration or game.
        int playerWon = humanPlayer; // Player that wins.

        // TODO: Simulate human vs AI. Specifically, your code should call both humanChoose and aiChoose to make the corresponding choices. Please also display appropriate messages.
        // Please also store AI's choices in aiData so that the ai will be able to learn from its choices.
        // Please use the following format to display the messages.
        
        while(remSticks != 0)
        {
            //human Player
            System.out.print("\033[34mplayer " + humanPlayer);
            System.out.print("\033[39;49m: There are \033[32m" + remSticks);
            System.out.print("\033[39;49m sticks remaining. ");
            System.out.print("How many do you choose [1..3 or remaining sticks]: ");
            remSticks -= humanChoose(remSticks);
            playerWon = aiPlayer;
        
            if(remSticks != 0) //ai player
            {
                choose = aiChoose(remSticks, aiData);
                aiChoices[remSticks] = choose; //saves choice made by ai
                remSticks -= choose; //remStick update
                
                //Output for AI
                System.out.print("\033[34mplayer " + aiPlayer);
                System.out.print("\033[39;49m: chooses \033[32m" + choose);
                System.out.println("\033[39;49m sticks.");
                playerWon = humanPlayer;
            }

        }

        System.out.println("\n\033[33mPlayer " + playerWon + " wins.\033[39;49m"); // Displays the final winner.
        

        // System.out.println("\033[34mplayer " + aiPlayer + "\033[39;49m: chooses \033[32m" + choose + "\033[39;49m sticks.");

        // TODO: Once an entire game is simulated, depending on the outcome, update the values of aiData. Specifically, if the AI wins, you need to increment those choices. If the AI loses, those choices will be decremented. Care must be taken so that there is one ball of evrey type (we don't decrement below 1).
        
        if(playerWon == aiPlayer) //ai wins
        {
            for(int i = 1; i < n + 1; i++)
            {
                if(aiChoices[i] != 0)
                {
                    aiData[i][aiChoices[i] - 1] += 1;
                }
            }
        }
        else //ai loses
        {
            for(int i = 1; i < n + 1; i++)
            {
                if(aiChoices[i] != 0 && aiData[i][aiChoices[i] - 1] > 1)
                {
                    aiData[i][aiChoices[i] - 1] -= 1;
                }
            }
        }
    }

    /**
      This function trains the AI for 100000 games.
      */
    private static void trainingAI() {
        int numIterations = 100000;		// Number of games or iterations.
        int [][] aiChoices = new int [2][n + 1];	// The choices that the AI makes. aiChoices[0] as the first player, and aiChoices[1] as the second player.
        int remSticks = n;	// Remaining number of sticks. Note that this needs to be set to n before the start of every iteration or game.
        int choose;					// The choice made by any AI.
        int playerWon;			// The player (or AI) who won.
        int playerLost;			// The player (or AI) who lost.

        // Simulate numIterations number of games.
        for (int i = 0; i < numIterations; i++) 
        {
            // Initialize the ai choices for both players
            for (int j = 0; j <= n; j++) {
                aiChoices[0][j] = 0;
                aiChoices[1][j] = 0;
            }
            // Inititalize remaining number of sticks, and player won.
            remSticks = n;
            playerWon = 0;

            // TODO: Simulate one game between two AI's.
            
            //Game simulation
            while(remSticks != 0)
            {
                //1st aiPlayer
                choose = aiChoose(remSticks, aiTrainedData);
                aiChoices[0][remSticks] = choose;
                remSticks -=  choose;

                if(remSticks != 0) //2nd aiPlayer
                {
                    choose = aiChoose(remSticks, aiTrainedData);
                    aiChoices[1][remSticks] = choose;
                    remSticks -= choose;
                }
            }

            //Set winner and loser
            if(aiChoices[0][1] == 1)
            {
                playerWon = 1;
                playerLost = 0;
            }
            else
            {
                playerWon = 0;
                playerLost = 1;
            }

            // TODO: After simulation. Please update the AI choices. The winning AI's choices are incremented, while the losing AI's choices are decremented (but make sure there is one ball of each type).
            // Both these choices are stored in aiTrainedData (the aiTrainedData can learn from both AI's).			
            
            for(int j = 0; j < n + 1; j++)
            {
                if(aiChoices[playerWon][j] != 0) //winning ai
                {
                    aiTrainedData[j][aiChoices[playerWon][j] - 1] += 1;
                }


                if(aiChoices[playerLost][j] != 0) //Losing ai
                {
                    //Ensures there is one ball of each type
                    if(aiTrainedData[j][aiChoices[playerLost][j] - 1] > 1)
                    {
                        aiTrainedData[j][aiChoices[playerLost][j] - 1] -= 1;
                    }
                }
            }
        }
    }

    public static void main(String [] args) {
        // Accept the number of sticks as command line arguments.
        if (args.length != 1) {
            System.out.println("Wrong arguments. Please execute using");
            System.out.println("$ java GameOfSticks <number of sticks>");
            System.out.println("<number of sticks> should be in [10...100].");
            System.exit(0);
        }
        n = Integer.parseInt(args[0]);
        if (n < 10 || n > 100) {
            System.out.println("Invalid <number of sticks>.");
            System.out.println("You should have at leaset 10 and at most 100 sticks.");
            System.exit(0);
        }

        // Allocate and initialize for ai data.
        aiNaiveData = new int[n + 1][totalSticks];
        aiTrainedData = new int[n + 1][totalSticks];
        initializeAIData(aiNaiveData);
        initializeAIData(aiTrainedData);
        // Calls the training method to train the AI.
        trainingAI();

        // Application begins here.
        int option;
        do {
            clearScreen();	// Clears the screen.
            option = printMenu(n, kb);	// Prints the main menu.
            switch (option) {
                case 1: playHuman();
                        break;
                case 2: playAI(0);
                        break;
                case 3: playAI(1);
                        break;
            }
            if (option != 4) {
                System.out.print("\n\nPress ENTER to get back to the menu.");
                kb.nextLine();
                String key = kb.nextLine();
            }
        } while (option != 4);
        System.out.println("\nThanks for playing the game.");
    }
}
