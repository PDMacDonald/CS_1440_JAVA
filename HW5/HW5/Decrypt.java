/*
 * Decrypt.java
 *
 * the class Decrpty is defined in this file.
 *
 * Preston MacDonald
 * 07-03-2017
 */

import java.util.Scanner;
import java.io.*;

/*
 * a class that takes in a decrypted text file that was encrypted via Caesar's
 * cipher and translates it back to normal or plain text.
 *
 * Caesar's method encrypts by replacing characters in a message with another
 * character that is three spaces forward in the alphabetic sequence. This 
 * class decrypts and prints a new .txt file that shows the appropriate plain
 * text. 
 *
 * ACII values for characters 65-90 for A-Z  and 97-122 for a-z. Symbols do
 * not translate such as . , : etc...
 */
public class Decrypt
{

    public static void main(String [] args) throws IOException
    {
        
        //Variables
        String line;
        int lineLength;

        File fp = new File("ORWU - Wkh Ihoorzkls ri wkh Ulqj.txt");
        Scanner input = new Scanner(fp);

        PrintWriter pw = new PrintWriter("LOTR - The Fellowship of the Ring.txt");
            
        //Decrypter 
        while(input.hasNext())
        {

            line = input.nextLine();            
            lineLength = line.length();
            StringBuilder newLine = new StringBuilder(line);
            
            //Per character decryption
            for(int i = 0; i < lineLength; i++)
            {
                //temp variable     
                char x;
                x = line.charAt(i);

                if( (x >= 65 && x <= 90) || (x >= 97 && x <= 122) )
                {
                    if((x >= 97 && x <= 99) || (x >= 65 && x <= 67))
                    {
                        x += 23;
                    }
                    else
                    {
                        x -= 3;
                    }
                }
                
                //New String Setup    
                newLine.setCharAt(i, x);

            }
            
            pw.println(newLine.toString());
                            
        }

        pw.close();
        System.out.println("Decryption of file is complete.");

    }
}
