import java.util.Scanner;

public class PlayLadderAndSnake {

    public static void main(String[] args) {


//        int size = 10;
//        int firstRow = 9;
//        int lastColumn = 9;
//        int count = 1;
//
//        LadderAndSnake[][] grid = new LadderAndSnake[size][size];
//
//        for (int row = 0; row < grid.length; row++) { //row
//            for (int column = 0; column < grid[row].length; column++) { //column
//                grid[row][column] = new LadderAndSnake(); //anonymous object added to each position
//            }
//        }
//        //how pieces move on board
//        for (int i = firstRow; i >= 0; i--) { //odd # rows go from left right //even # rows go from right to left
//            if (i % 2 != 0) { //if row odd
//                for (int j = 0; j < size; j++) { //increment columns
//                    grid[i][j].setGridSlotNumber(count++);
//                }
//            } else { //if row even
//                for (int k = lastColumn; k >= 0; k--) {
//                    grid[i][k].setGridSlotNumber(count++);
//                }
//            }
//        }
//
//        //display grid to user
//        for (int row = 0; row < size; row++) { //looping through rows
//            for (int column = 0; column < size; column++) {
//                System.out.print(grid[row][column].getGridSlotNumber() + "\t\t");
//            }
//            System.out.println();
//            System.out.println();
//        }

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


        LadderAndSnake LadderAndSnakeObject = new LadderAndSnake();

        LadderAndSnakeObject.play(numPlayers);

        //int numPlayers = LadderAndSnake.numberOfPlayers();//Call static method to get number of players


//        int[] diceValue = new int[numPlayers]; //creating array to store each players value
//        for (int i = 0; i < numPlayers; i++) { //loop through each player to store the value of random die in array
//            diceValue[i] = LadderAndSnake.flipDice();
//            System.out.print(diceValue[i] + ", ");
//            //diceValueList.add(LadderAndSnake.flipDice());
//        }
//
//        int largest = 0;


//        System.out.println();
//        System.out.println("Player " + (largest + 1) + " got the highest dice value which is " + (diceValue[largest]));
        //[4,4,4,3]
        // 1 2 3 4 player
        // 0 1 2 3 position of array
        //{ {4,0},{4,1},{4,2},{3,3} }
        //run through sort:
        //{ {3,3},{4,0},{4,1},{4,2} }
        //if arr[i][j] == arr[i][k]


        // TODO: 2021-01-25 Program what happens when two players have same dice value
    }
}
