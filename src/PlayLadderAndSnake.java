import java.util.Scanner;
//---------------------------------------------------------------
//Assignment 1
//Question: Part II
//Written by: Ryan Haniff (27069421) Véronique Deveaux (40170464)
//---------------------------------------------------------------

/**
 * @author Ryan Haniff (27069421)
 * @author Veronique Deveaux (40170464)
 *
 * <p>COMP 249</p>
 * <p>Assigment #1</p>
 * <p>Due Date: February 8th, 2021</p>
 * <p>Part II</p>
 *
 * In part II, the main method is invoked. It requests the user to input a number from 2-4 inclusively. The user has
 * four chances to input the correct number otherwise the program will end. The play method is called and the number
 * of players is passed in as a parameter.
 */

public class PlayLadderAndSnake {

    public static void main(String[] args) {

        System.out.println("\\--------------------------------------------------\\");
        System.out.println("/           Let's play Ladder and Snake            /");
        System.out.println("\\                    created by                    \\");
        System.out.println("/        Ryan Haniff and Véronique Deveaux         /");
        System.out.println("\\--------------------------------------------------\\\n");

        //Scanner
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the # of players for your game – Number must be between 2 and 4 inclusively: "); // Prompt the user to enter number of players
        int numPlayers = input.nextInt();

        //Attempts to add valid # of players (first input not counted)
        for (int i = 0; i < 3; i++) {
            if (numPlayers < 2 || numPlayers > 4) { //verifying if # of players i out of bounds
                System.out.print("Bad Attempt " + (i + 1) + " - Invalid # of players. Please enter a # between 2 and 4 inclusively: ");
                numPlayers = input.nextInt();

                if (i == 2) { //4 attempts have been exhausted
                    System.out.println("Bad Attempt " + (i + 2) + " You have exhausted all your chances. Program will terminate!");
                    System.exit(69); //will terminate program with exit code 0
                }
            }
        }
        System.out.println("Game is played by " + numPlayers + " players.");

        LadderAndSnake LadderAndSnakeObject = new LadderAndSnake();

        LadderAndSnakeObject.play(numPlayers); //call the play method to start playing the game

        input.close(); //close scanner

    }
}
