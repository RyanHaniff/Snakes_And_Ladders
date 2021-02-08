import java.util.Scanner;
//---------------------------------------------------------------
//Assignment 1
//Question: Part II
//Written by: Ryan Haniff (27069421) Véronique Deveaux (40170464)
//---------------------------------------------------------------

// General explanation:
// This is a board game of Ladder and Snake. Two to four players start by establishing the player order.
// Once this has been established, they start playing. Their initial position is off the board. After they each
// roll the die, they start moving on the board. If they hit the bottom of a ladder, they go up to the top of it,
// and if they hit the head of a snake, they slide down to its tail. The game ends when a player reaches exactly 100.
// If a player passes 100, they move back with the excessive amount. Everytime all players roll the die, the board is
// printed out so that they can keep track of everyone's progress. Every player has their own colour to make is easier
// to differentiate them from their opponents.

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
