import java.util.Scanner;

public class LadderAndSnake {

    private final static int DICE = 6;
    private int gridSlotNumber; //store grid numbers into this object
    private int[][] snakes; //8 sneks
    private int[][] ladders; //9 ladders
    private final int SNAKE_NUMBERS = 8; //# of snakes
    private final int LADDER_NUMBERS = 9; //# of ladders

    //default constructor
    public LadderAndSnake() {
        gridSlotNumber = 0;
    }

    static public int flipDice() {
        return (int) (Math.random() * DICE + 1); //generates a random value between 1 and 6
    }

    public void play() {
        // create an array that holds Player Class
        Players[] players = new Players[inputedNumPlayers()]; //hold 2-4 players

        for (int i = 0; i < players.length; i++) {
            players[i] = new Players(i + 1); //add a player to the array with a player number
        }

        playerOrderCalc(players, 0, players.length);

        //output toString
        System.out.println("back from playerOrderCalc");
        System.out.print("Reached final decision on order of playing: Player ");
        for (int i = players.length - 1; i >= 0; i--) {
            if (i != 0) {
                System.out.print(players[i].getPlayerNumber() + ", Player ");
            } else {
                System.out.println(players[i].getPlayerNumber() + ".");

            }
        }

        boolean won = false;
        int test = 0;
        while (test < 8) { //looping the players until someone reach 100

            movePlayer(players);
//            for (int i = players.length - 1; i >= 0; i--) {
//                //System.out.println("Player " + players[i].playerNumber + " moved to " + players[i].getPositionOnBoard());
//                System.out.println("Player " + players[i].getPlayerNumber() + " got dice value of " + players[i].getPositionOnBoard() + "; now in square " + players[i].getPositionOnBoard());
//
//            }
            test++;

            System.out.println("Game not over; flipping again");
        }
    }

    // TODO: 2021-01-31 We must always check to see if a player won, use a while loop and while(!won) they continue to play.
    // TODO: 2021-01-31 If we roll past 100 we have to decrement the remaining numbers back on the grid.
    // TODO: 2021-01-31 Comments and javadoc

    /**
     * Move the players on the grid
     *
     * @param players the players on the board
     */
    public void movePlayer(Players[] players) {
        snakePosition();
        ladderPosition();

        for (int playerOrder = players.length - 1; playerOrder >= 0; playerOrder--) { //our players are in ascending order, so we start from last array position
            players[playerOrder].setDiceRoll(flipDice()); //bc we're flipping the dice and need to assign it to the correct player (to add to their position on the board)
            players[playerOrder].setLatestPosition(players[playerOrder].getDiceRoll());
            players[playerOrder].setLandedOnSnake(false);
            players[playerOrder].setLandedOnLadder(false);

            //if the player landed on a snake
            for (int snakePosition = 0; snakePosition < SNAKE_NUMBERS; snakePosition++) {
                if (players[playerOrder].getPositionOnBoard() == snakes[snakePosition][0]) { //if player position on board = position of head of a snake
                    players[playerOrder].setPositionOnBoard(snakes[snakePosition][1]); //player moves to the tail of the snake
                    players[playerOrder].setLandedOnSnake(true);
                    System.out.println("Player " + players[playerOrder].getPlayerNumber() + " got dice value of " + players[playerOrder].getDiceRoll() +
                            "; They landed on a snake head on square " + snakes[snakePosition][0] + " and have been moved down to square " + players[playerOrder].getPositionOnBoard());
                    //System.out.println("They landed on a snake head and have been moved down to square " + players[playerOrder].getPositionOnBoard());
                }
            }

            //if the player landed on a ladder
            for (int ladderPosition = 0; ladderPosition < LADDER_NUMBERS; ladderPosition++) {
                if (players[playerOrder].getPositionOnBoard() == ladders[ladderPosition][0]) {
                    players[playerOrder].setPositionOnBoard(ladders[ladderPosition][1]);
                    players[playerOrder].setLandedOnLadder(true);
                    System.out.println("Player " + players[playerOrder].getPlayerNumber() + " got dice value of " + players[playerOrder].getDiceRoll() +
                            "; They landed at the bottom of a ladder on square " + ladders[ladderPosition][0] + " and have been moved up to square " + players[playerOrder].getPositionOnBoard());
                    // System.out.println("They landed at the bottom of a ladder and have been moved up to square " + players[playerOrder].getPositionOnBoard());
                }
            }
            if (!players[playerOrder].isLandedOnSnake() && !players[playerOrder].isLandedOnLadder()) {
                System.out.println("Player " + players[playerOrder].getPlayerNumber() + " got dice value of " + players[playerOrder].getDiceRoll() +
                        "; now in square " + players[playerOrder].getPositionOnBoard());
            }
        }
        System.out.println("------------------");
    }

    public void playerOrderCalc(Players[] players, int start, int end) { //start is the starting position of array, and end is ending.
        int first = 0; //for player order
        System.out.println();
        System.out.println("Entered playerOrderCalc");
        //if(end == players.length) {
        for (int i = start; i < end; i++) {
            players[i].setDiceRollStartingOrder(flipDice()); //add a player to the array with a player number
            //players[i].setDiceRollStartingOrder(6); //add a player to the array with a player number
        }
        //players[3].setDiceRollStartingOrder(3); //add a player to the array with a player number
        // players[1].setDiceRollStartingOrder(3); //add a player to the array with a player number

//        } else{
//            for (int i = start; i < end; i++) {
//                players[i].setDiceRollStartingOrder(flipDice()); //add a player to the array with a player number
//            }
//        }

        //output each players dice value:
        for (int i = start; i < end; i++) {
            System.out.println("Player " + players[i].getPlayerNumber() + " rolled a " + players[i].getDiceRollStartingOrder());
        }
        System.out.println("before sorting");

        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i]);
        }

        int min; //smallest guy in the array
        Players temp; //move around the 'min' inside the array
        //sorting the players by dice roll
        for (int i = start; i < end - 1; i++) { //looping through positions in array
            min = i; //current min
            for (int j = i + 1; j < end; j++) { //going to the next position in array   //current item = j
                if (players[j].getDiceRollStartingOrder() < players[min].getDiceRollStartingOrder()) {
                    min = j;
                }
            }
            temp = players[min]; //store min value to temp   // temp is a Players class
            players[min] = new Players(players[i]); //store the higher value where min used to be using copy constructor
            players[i] = new Players(temp); //place smaller value where i is.
        } //at this point, the whole array is sorted

        System.out.println("after sorting");
        for (int i = 0; i < players.length; i++) {
            players[i].setPlayerOrder(players.length - i); //update playerOrder variable
            System.out.println(players[i]);
        }

        //Look for players who roll the same number
        int i = start; //starting at 0 on first non method loop (recursion)
        while (i < end) { //end is the array size
            //try to find a run of players with the same number
            int runStart = i; //position in array
            int diceNumberRolled = players[runStart].getDiceRollStartingOrder(); //get the dice number
            ++i; //increment to go to next player
            while (i < end && players[i].getDiceRollStartingOrder() == diceNumberRolled) { //if the player dice roll is the same
                ++i; //increment until we no longer have a dice roll of the same value
            }

            if (i - runStart > 1) { //there are two or more consecutive dice rolls that had the same dice roll
                System.out.print("A tie was achieved between " + players[runStart].getPlayerNumberString());
                for (int j = runStart + 1; j < i; j++) {
                    System.out.print(" and " + players[j].getPlayerNumberString());
                }
                // We have found more than one player with the same dice number.
                // Get all of the players with that dice number to roll again.
                System.out.println("\nRecursion into playerOrderCalc: runStart=" + runStart + ", i=" + i);
                playerOrderCalc(players, runStart, i);
            }
        }
    }

    public void reRoll(Players pl) {
        if (pl.isReRoll()) {
            pl.setDiceRollStartingOrder(flipDice());
            pl.setReRoll(false);
        }
    }

    public int inputedNumPlayers() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the # of players for your game – Number must be between 2 and 4 inclusively: ");
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
        return numPlayers;
    }

    public int getGridSlotNumber() {
        return gridSlotNumber;
    }

    public void setGridSlotNumber(int gridSlotNumber) {
        this.gridSlotNumber = gridSlotNumber;
    }

    public void snakePosition() {
        snakes = new int[SNAKE_NUMBERS][2];

        snakes[0][0] = 16;
        snakes[0][1] = 6;

        snakes[1][0] = 48;
        snakes[1][1] = 30;

        snakes[2][0] = 64;
        snakes[2][1] = 60;

        snakes[3][0] = 79;
        snakes[3][1] = 19;

        snakes[4][0] = 93;
        snakes[4][1] = 68;

        snakes[5][0] = 95;
        snakes[5][1] = 24;

        snakes[6][0] = 97;
        snakes[6][1] = 76;

        snakes[7][0] = 98;
        snakes[7][1] = 78;
    }

    public void ladderPosition() {

        ladders = new int[LADDER_NUMBERS][2];

        ladders[0][0] = 1;
        ladders[0][1] = 38;

        ladders[1][0] = 4;
        ladders[1][1] = 14;

        ladders[2][0] = 9;
        ladders[2][1] = 31;

        ladders[3][0] = 21;
        ladders[3][1] = 42;

        ladders[4][0] = 28;
        ladders[4][1] = 84;

        ladders[5][0] = 36;
        ladders[5][1] = 44;

        ladders[6][0] = 51;
        ladders[6][1] = 67;

        ladders[7][0] = 71;
        ladders[7][1] = 91;

        ladders[8][0] = 80;
        ladders[8][1] = 100;
    }
}

