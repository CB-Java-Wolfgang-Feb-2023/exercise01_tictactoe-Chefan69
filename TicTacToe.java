import java.util.*;

public class TicTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList <Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList <Integer>();


    public static void main(String[] args) {

        //TicTacToe GameBoard (2 dimensional Array with 3 rows)

        char [][] gameBoard = { {' ','|',' ','|',' '},
                                {'-','+','-','+','-'},
                                {' ','|',' ','|',' '},
                                {'-','+','-','+','-'},
                                {' ','|',' ','|',' '}};


        printGameBoard(gameBoard);


        while(true) {
            Scanner scan = new Scanner(System.in); // import java.util.Scanner

            System.out.println("Enter your placement (1-9)");
            int playerPos = scan.nextInt(); // User-Input gets saved on variable position
            while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions)) {
                  System.out.println("Position taken!");
                  playerPos = scan.nextInt();

            }
            userInput(gameBoard, playerPos, "player");
            String result = checkWinner();
            if(result.length() > 0)
            {
                System.out.println(result);
                break;
            }



            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {

                cpuPos = rand.nextInt(9) + 1;

            }

            userInput(gameBoard, cpuPos, "cpu");


            printGameBoard(gameBoard);

            result = checkWinner();
            if(result.length() > 0)
            {
                System.out.println(result);
                break;
            }

            System.out.println(result);

        }
    }

    public static void printGameBoard(char [][] gameBoard) {
        for (char[] row : gameBoard) {// for each row in a gameBoard

            for(char c : row) { // for each symbol in a row
                System.out.print(c);// print each char in a row without line
            }
            System.out.println(); // after each row print line
        }
    }

    public static void userInput (char [][] gameBoard, int position, String user) {

        char symbol =' ';// default Symbol
        if(user.equals("player")){//String therefor use .equals instead of ==
            symbol = 'X';
            playerPositions.add(position);
        } else if (user.equals("cpu")) {
            symbol = '0';
            cpuPositions.add(position);
        }

        switch (position) {
            case 1:
                gameBoard [0][0] = symbol;
                break;
            case 2:
                gameBoard [0][2] = symbol;
                break;
            case 3:
                gameBoard [0][4] = symbol;
                break;
            case 4:
                gameBoard [2][0] = symbol;
                break;
            case 5:
                gameBoard [2][2] = symbol;
                break;
            case 6:
                gameBoard [2][4] = symbol;
                break;
            case 7:
                gameBoard [4][0] = symbol;
                break;
            case 8:
                gameBoard [4][2] = symbol;
                break;
            case 9:
                gameBoard [4][4] = symbol;
                break;

            default:
                break;
        }
    }

    public static String checkWinner() {
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);

        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);

        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for(List l : winning) {
            if(playerPositions.containsAll(l)) {
                return "Well done, you won!";
            }else if(cpuPositions.contains(l)) {
                return "Sorry, cpu won!";
            } else if(playerPositions.size() + cpuPositions.size() == 9) {
                return "A Tie Game!";
            }
        }



        return "";
    }

}
