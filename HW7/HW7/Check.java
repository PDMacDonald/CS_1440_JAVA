/*
 * Check.java
 *
 * Includes the class Check and its methods.
 *
 * Preston MacDonald
 * last Edit: 07-25-17
 */

import java.util.Scanner;
import java.io.*;

/*
 * Class that takes a input from a .txt file which simulates any arrangement of
 * chess pieces and than check if the black king is in check or not.
 *
 * NOTE: Any loop that is used to navigate an array will use the variable i for
 * the rows and j for the columns.
 */

public class Check
{
    
    private static final int n = 8; //determines square dimensions of array
    

    public static void main(String [] args) throws IOException
    {
        //Variables
        char [][] board = new char[n][n];
        
        //Populate array
        fileFillA(board, "chess.txt"); 
        
        //Display Array
        printChessBoard(board);

        //Algorithm + Output
        if(isBlackInCheck(board) == true)
        {
            System.out.println("Black king is in check. ");
        }
        else
        {
            System.out.println("Black king is not in check. ");
        }

    }  
    
    /*
         method to write a file into an array
     */
    private static void fileFillA(char [][] a, String fName) throws IOException
    {
        File fp = new File(fName);
        Scanner input = new Scanner(fp);

        while(input.hasNext())
        {
            for(int i = 0; i < n; i++) //rows
            {
                String text = input.nextLine(); //txt lines = row

                for(int j = 0; j < n; j++) //columns
                {
                    a[j][i] = text.charAt(j);
                }
            }
        }
    }

    /*
         Method to print out the chess board array
     */
    private static void printChessBoard(char [][] array)
    { 
        for(int i = 0; i < n; i++)// rows
        {
            for(int j = 0; j < n; j++)// columns
            {
                System.out.print(array[j][i] + " ");
            }

            System.out.println("\n");
        }
    }
    
    /*
         Method to take a chess board with pieces and see if the black king
         is in check. black colored pieces are all lowercase therefore this
         method only check if a white piece is holding the black king in 
         check. White pieces are uppercase.
     */
    private static boolean isBlackInCheck(char [][] array)
    {
        boolean isCheck = false;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                switch (array[j][i])
                {
                    case 'P': isCheck = pawnMove(array, j, i); break;
                    case 'R': isCheck = rookMove(array, j, i); break;
                    case 'B': isCheck = bishopMove(array, j, i); break;
                    case 'Q': isCheck = queenMove(array, j, i); break;
                    case 'N': isCheck = knightMove(array, j, i); break;
                }
                if(isCheck == true)
                {
                    return true;
                }
            }
        }

        return isCheck;
    }

    /*
         Method that represents a Queen and its appropriate moves
     */
    private static boolean queenMove(char [][] array, int col, int row)
    {
        if(fwDCheck(array, col, row) == true)
            return true;
        else if(bkDCheck(array, col, row) == true)
            return true;
        else if(vCheck(array, col, row) == true)
            return true;
        else if(hCheck(array, col, row) == true)
            return true;
        else
            return false;
    }
    
    /*
         Method that represents a Bishop and its appropriate moves
     */
    private static boolean bishopMove(char [][] array, int col, int row)
    {
        if(fwDCheck(array, col, row) == true)
            return true;
        else if(bkDCheck(array, col, row) == true)
            return true;
        else
            return false;
    }
    
    /*
         Method that represents a rook and its appropriate moves
    */
    private static boolean rookMove(char [][] array, int col, int row)
    {
        if(vCheck(array, col, row) == true)
            return true;
        else if(hCheck(array, col, row) == true)
            return true;
        else
            return false;
    }
    
    /*
         Method that represents a Knight and its appropriate moves
     */
    private static boolean knightMove(char[][] array, int col, int row)
    {
        if(checks(array, col - 1, row - 2) == 1)
            return true;
        else if(checks(array, col - 1, row + 2) == 1)
            return true;
        else if(checks(array, col - 2, row + 1) == 1)
            return true;
        else if(checks(array, col - 2, row - 1) == 1)
            return true;
        else if(checks(array, col + 1, row - 2) == 1)
            return true;
        else if(checks(array, col + 1, row + 2) == 1)
            return true;
        else if(checks(array, col + 2, row - 1) == 1)
            return true;
        else if(checks(array, col + 2, row + 1) == 1)
            return true;
        else
            return false;
    }
         
    /*
        Method that represents a pawn and its appropriate moves
    */
    private static boolean pawnMove(char [][] array, int col, int row)
    {
        if(checks(array, col + 1, row - 1) == 1)
            return true;
        else if(checks(array, col -1, row -1) == 1)
            return true;
        else
            return false;
    }
    
    
    /*
         Algorithm to take a index and check bounds, check if in check,
         and check if blocked
     */
    private static int checks(char [][] array, int c, int r)
    {
        if(r >= 0 && r < n && c >= 0 && c < n) // check for bounds
        {
            if( array[c][r] == 'k') //check for check
            {
                return 1;
            }
            else if(array[c][r] != '.') //check if blocked
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
        else
        {
            return -1;
        }
    }

    /*
         Method to check if the king is in check vertically
     */
    private static boolean vCheck(char [][] array, int col, int row)
    {
        //up
        for(int i = row - 1; i > col - n; i--)
        {
            if(checks(array, col, i) == 1)
            {
                return true;
            }
            else if(checks(array, col, i) == -1)
            {
                break;
            }
        }
        
        //down   
        for(int i = row + 1; i < col + n; i++)
        {
            if(checks(array, col, i) == 1)
            {
                return true;
            }
            else if(checks(array, col, i) == -1)
            {
                break;
            } 
        }

        return false;
    }

    /*
         Method to check if the king is in check horizontally from index
     */
    private static boolean hCheck(char [][] array, int col, int row)
    {

        //Right
        for(int j = col + 1; j < col + n; j++)
        {
            if(checks(array, j, row) == 1)
            {
                return true;
            }
            else if(checks(array, j, row) == -1)
            {
                break;
            }         
        }

         //Left
         for(int j = col - 1; j > col - n; j--)
         {
             if(checks(array, j, row) == 1)
             {
                 return true;
             }
             else if(checks(array, j, row) == -1)
             {
                 break;
             }
         }

         return false;
    }
    
    /*
         Method to check if king is in check in a forward diagonal from index
     */
    private static boolean fwDCheck(char [][] array, int col, int row)
    {
        int j = col;

        //lower half of diagonal
        for(int i = row + 1; i < row + n; i++)
        {
            j--;

            if(checks(array, j, i) == 1)
            {
                return true;
            } 
            else if(checks(array, j, i) == -1)
            {
                break;
            }
        }

        //upper half of diagonal
        j = col;

        for(int i = row - 1; i > row - n; i--)
        {
            j++;

            if(checks(array, j, i) == 1)
            {
                return true;
            }
            else if(checks(array, j, i) == -1)
            {
                break;
            }
        }        

        return false;       
    }
    
    /*
         Method to check if king is in check in a backward diagonal from index
     */
    private static boolean bkDCheck(char [][] array, int col, int row)
    {
        int j = col;
        
        //lower half of diagonal
        for(int i = row + 1; i < row + n; i++)
        {
            j++;

            if(checks(array, j, i) == 1)
            {
                return true;
            }
            else if(checks(array, j, i) == -1)
            {
                break;
            }
        } 

        //upper half of diagonal
        j = col;

        for(int i = row -1; i > row - n; i--)
        {
            j--;
            
            if(checks(array, j, i) == 1)
            {
                return true;
            }
            else if(checks(array, j, i) == -1)
            {
                break;
            }
        }

        return false;
    }   
    
    
}
