//---------------------------------------------------------------
//Assignment 1
//Question: Part I
//Written by: Ryan Haniff (27069421) Véronique Deveaux (40170464)
//---------------------------------------------------------------

/**
 * @author Ryan Haniff (27069421)
 * @author Veronique Deveaux (40170464)
 *
 * <p>COMP 249</p>
 * <p>Assigment #1</p>
 * <p>Due Date: February 8th, 2021</p>
 * <p>Part I</p>
 *
 * The Players class is used in Part I to store values of a player. It stores basic information like the player order,
 * their position on the board, player colour, and others. A checkIfWon method is used to determine if a player has
 * reached 100 and if not outputs the necessary comments to the user.
 */

public class Players {

    /**
     * Numbers of player between 2-4.
     */
    private int playerNumber;
    /**
     * Deciding which player will start playing.
     */
    private int diceRollStartingOrder;
    /**
     * After deciding the order of players this is how they will start playing.
     */
    private int playerOrder;
    /**
     * The players position on the board.
     */
    private int positionOnBoard;
    /**
     * The the dice roll the player got.
     */
    private int diceRoll;
    /**
     * If the player landed on a snake.
     */
    private boolean landedOnSnake;
    /**
     * If the player landed on ladder.
     */
    private boolean landedOnLadder;
    /**
     * Each players colour.
     */
    private String playerColour;
    /**
     * Reset the text colour back to normal.
     */
    public static final String TEXT_RESET = "\u001B[0m";

    /**
     * Default constructor where the initial variables are set.
     */
    public Players() {
        playerNumber = 0;
        playerOrder = 0;
        positionOnBoard = 0;
        diceRoll = 0;
        landedOnSnake = false;
        landedOnLadder = false;
    }

    /**
     * Constructor to set the position of the player on the board.
     *
     * @param playerNumber an integer value between 1 and 100.
     */
    public Players(int playerNumber) {
        this(); //it calls the default constructor Players() above and runs all the code inside
        this.playerNumber = playerNumber;
    }

    /**
     * Copy constructor.
     *
     * @param copy a Players object to copy from.
     */
    public Players(Players copy) {
        this(copy.getPlayerNumber());
        setDiceRollStartingOrder(copy.getDiceRollStartingOrder());
        setPlayerOrder(copy.getPlayerOrder());
        setPositionOnBoard(copy.getPositionOnBoard());
    }

    /**
     * Output the player position to the user and determine if they won.
     *
     * @return a boolean value depending on if they won or not.
     */
    public boolean checkIfWon() {
        if (getPositionOnBoard() > 100) {
            //we are on 98 and roll a 5: 98+5 = 103 (would be our latest position)
            setPositionOnBoard(100 - (getPositionOnBoard() - 100));
            return false;
        } else if (getPositionOnBoard() == 100 && !isLandedOnLadder()) {
            System.out.println("Player " + getPlayerNumber() + " got dice value of " + getDiceRoll() +
                    "; now on square " + getPositionOnBoard());
            System.out.println("\nCongrats " + getPlayerNumberString() + ", you have won!");
            return true;
        } else if (getPositionOnBoard() == 100 && isLandedOnLadder()) {
            System.out.println("\nCongrats " + getPlayerNumberString() + ", you have won!");
            return true;
        } else if (!isLandedOnSnake() && !isLandedOnLadder()) {
            System.out.println("Player " + getPlayerNumber() + " got dice value of " + getDiceRoll() +
                    "; now on square " + getPositionOnBoard());
            return false;
        }
        return false;
    }

    /**
     * Setting each players assigned colour.
     *
     * @param colour a string of ANSI escape code colours.
     */
    public void setPlayerColour(String colour) {
        this.playerColour = colour;
    }

    /**
     * Gets each players assigned colour.
     *
     * @return a string of the player with its corresponding colour.
     */
    public String getPlayerColour() {
        return (playerColour + "P" + getPlayerNumber() + TEXT_RESET);
    }

    /**
     * Gets the players dice roll value.
     *
     * @return an integer value between 1 and 6.
     */
    public int getDiceRoll() {
        return diceRoll;
    }

    /**
     * Sets the players dice roll value.
     *
     * @param diceRoll an integer value between 1 and 6.
     */
    public void setDiceRoll(int diceRoll) {
        this.diceRoll = diceRoll;
    }

    /**
     * Gets a number between 2 and 4 inclusively to assign to players.
     *
     * @return an integer between 2 and 4 inclusively to assign to players.
     */
    public int getPlayerNumber() {
        return playerNumber;
    }

    /**
     * Makes a string of the player number.
     *
     * @return a string of the player number.
     */
    public String getPlayerNumberString() {
        return "Player " + getPlayerNumber();
    }

    /**
     * Gets the starting order of the players dice roll.
     *
     * @return an integer of the players dice roll.
     */
    public int getDiceRollStartingOrder() {
        return diceRollStartingOrder;
    }

    /**
     * Sets the dice roll for each player at the start of the game.
     *
     * @param diceRollStartingOrder an integer value between 1 and 6 to set initial dice roll.
     */
    public void setDiceRollStartingOrder(int diceRollStartingOrder) {
        this.diceRollStartingOrder = diceRollStartingOrder;
    }

    /**
     * Gets player oder.
     *
     * @return an integer of the players order.
     */
    public int getPlayerOrder() {
        return playerOrder;
    }

    /**
     * Sets player order.
     *
     * @param playerOrder is an integer to set the player on the board.
     */
    public void setPlayerOrder(int playerOrder) {
        this.playerOrder = playerOrder;
    }

    /**
     * Gets the players position on the board.
     *
     * @return an integer of where the player is on the board.
     */
    public int getPositionOnBoard() {
        return positionOnBoard;
    }

    /**
     * Sets the player position after they roll the dice.
     *
     * @param flippedDice is an integer of the random dice roll value.
     */
    public void setLatestPosition(int flippedDice) {
        setPositionOnBoard(flippedDice + getPositionOnBoard());
    }

    /**
     * Sets the player to the position on the board.
     *
     * @param positionOnBoard is an integer to set the position of the player on the board.
     */
    public void setPositionOnBoard(int positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }

    /**
     * Check to see if player landed on snake.
     *
     * @return a boolean value if they landed on a snake.
     */
    public boolean isLandedOnSnake() {
        return landedOnSnake;
    }

    /**
     * Sets the player position to land on a snake.
     *
     * @param landedOnSnake is a boolean to set if a player has landed on a snake.
     */
    public void setLandedOnSnake(boolean landedOnSnake) {
        this.landedOnSnake = landedOnSnake;
    }

    /**
     * Checks to see if the player landed on a ladder.
     *
     * @return a boolean to see if the player landed on a ladder.
     */
    public boolean isLandedOnLadder() {
        return landedOnLadder;
    }

    /**
     * Sets the players state depending on if they landed on a ladder.
     *
     * @param landedOnLadder is a boolean depending on if they landed on a ladder.
     */
    public void setLandedOnLadder(boolean landedOnLadder) {
        this.landedOnLadder = landedOnLadder;
    }

    /**
     * Override toString method to display Player information.
     *
     * @return a string of all the players values.
     */
    public String toString() {
        return "Players{" +
                "playerNumber=" + playerNumber +
                ", diceRollStartingOrder=" + diceRollStartingOrder +
                ", playerOrder=" + playerOrder +
                ", positionOnBoard=" + positionOnBoard + " }";
    }
}
