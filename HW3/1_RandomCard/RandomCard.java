/**
 * RandomCard.java
 *
 * the class RandomCard is defined in this file.
 *
 * Preston MacDonald
 * 06-13-2017
 */

import java.util.Random;

/*
 * A class that randomly displays an integer in the range 0-51 along with its
 * corresponding card.
 *
 * The numbers 0-12 are clubs, 13-25 are diamonds, 26-38 are hearts and
 * 39-51 are spades. In each suit, the first number in the range represents
 * the ace while the last is the king where the numbers between are in order.
 */
public class RandomCard
{

    public static void main(String [] args)
    {

        // Variables Defined
        int number;
        String cardType = " ";
        String cardSuit = " ";
        
        // Random number generator
        Random randomInt = new Random();
        number = randomInt.nextInt(52); // Range of numbers: 0-51
        
        // CardType literal defining
        switch (number % 13)
        {
            case 0: cardType = "Ace"; break;
            case 1: cardType = "Two"; break;
            case 2: cardType = "Three"; break;
            case 3: cardType = "Four"; break;
            case 4: cardType = "Five"; break;
            case 5: cardType = "Six"; break;
            case 6: cardType = "Seven"; break;
            case 7: cardType = "Eight"; break;
            case 8: cardType = "Nine"; break;
            case 9: cardType = "Ten"; break;
            case 10: cardType = "Jack"; break;
            case 11: cardType = "Queen"; break;
            case 12: cardType = "King"; break;
        }

        // CardSuit literal defining
        if (number >= 0 && number <= 12)
        {
            cardSuit = "of Clubs";
        }
        else if (number >= 13 && number <= 25)
        {
            cardSuit = "of Diamonds";
        }
        else if (number >= 26 && number <= 38)
        {
            cardSuit = "of Hearts";
        }
        else if (number >= 39 && number <= 51)
        {
            cardSuit = "of Spades";
        }

        // Output 
        System.out.println("Random Number: " + number);
        System.out.println("This card is: " + cardType + " " + cardSuit); 

    }
}

