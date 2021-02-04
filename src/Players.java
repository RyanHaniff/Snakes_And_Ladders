public class Players {

    private int playerNumber; //player 2-4 //bc private, can only use get/set
    private int diceRollStartingOrder; //Now deciding which player will start playing;
    private int playerOrder; //after starting dice rolls this is how they will start playing
    private int positionOnBoard;
    private boolean reRoll; //if multiple people have same dice number reroll
    private int diceRoll;
    private boolean landedOnSnake;
    private boolean landedOnLadder;

    //default constructor //where u set the initial variables
    public Players() {
        playerNumber = 0;
        playerOrder = 0;
        positionOnBoard = 0;
        reRoll = false;
        diceRoll = 0;
        landedOnSnake = false;
        landedOnLadder = false;
    }

    public Players(int playerNumber) {
        this(); //it calls the default constructor Players() above and runs all the code inside
        this.playerNumber = playerNumber;
    }

    //copy constructor
    public Players(Players copy) {
        this(copy.getPlayerNumber());
        setDiceRollStartingOrder(copy.getDiceRollStartingOrder());
        setPlayerOrder(copy.getPlayerOrder());
        setPositionOnBoard(copy.getPositionOnBoard());
        setReRoll(copy.isReRoll());
    }

    public boolean checkIfWon() {
        if (getPositionOnBoard() > 100) {
            //we are on 98 and roll a 5: 98+5 = 103 (would be our latest position)
            setPositionOnBoard(100 - (getPositionOnBoard() - 100));
            return false;
        } else if (getPositionOnBoard() == 100 && !isLandedOnLadder()) {
            System.out.println("Player " + getPlayerNumber() + " got dice value of " + getDiceRoll() +
                    "; now on square " + getPositionOnBoard());
            System.out.println("\nCongrats " + getPlayerNumberString()  + ", you have won!");
            return true;
        } else if (getPositionOnBoard() == 100 && isLandedOnLadder()) {
            System.out.println("\nCongrats " + getPlayerNumberString()  + ", you have won!");
            return true;
        } else if (!isLandedOnSnake() && !isLandedOnLadder()) {
            System.out.println("Player " + getPlayerNumber() + " got dice value of " + getDiceRoll() +
                    "; now on square " + getPositionOnBoard());
            return false;
        }
        return false;
    }

    public int getDiceRoll() {
        return diceRoll;
    }

    public void setDiceRoll(int diceRoll) {
        this.diceRoll = diceRoll;
    }

    public boolean isReRoll() {
        return reRoll;
    }

    public void setReRoll(boolean reRoll) {
        this.reRoll = reRoll;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getPlayerNumberString() {
        return "Player " + getPlayerNumber();
    }

    public int getDiceRollStartingOrder() {
        return diceRollStartingOrder;
    }

    public void setDiceRollStartingOrder(int diceRollStartingOrder) {
        this.diceRollStartingOrder = diceRollStartingOrder;
    }

    public int getPlayerOrder() {
        return playerOrder;
    }

    public void setPlayerOrder(int playerOrder) {
        this.playerOrder = playerOrder;
    }

    public int getPositionOnBoard() {
        return positionOnBoard;
    }

    public void setLatestPosition(int flippedDice) {
        setPositionOnBoard(flippedDice + getPositionOnBoard()); //set the player position after they roll the dice
    }

    public void setPositionOnBoard(int positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }

    public boolean isLandedOnSnake() {
        return landedOnSnake;
    }

    public void setLandedOnSnake(boolean landedOnSnake) {
        this.landedOnSnake = landedOnSnake;
    }

    public boolean isLandedOnLadder() {
        return landedOnLadder;
    }

    public void setLandedOnLadder(boolean landedOnLadder) {
        this.landedOnLadder = landedOnLadder;
    }

    public String toString() {
        return "Players{" +
                "playerNumber=" + playerNumber +
                ", diceRollStartingOrder=" + diceRollStartingOrder +
                ", playerOrder=" + playerOrder +
                ", positionOnBoard=" + positionOnBoard +
                ", reRoll=" + reRoll +
                '}';
    }
}
