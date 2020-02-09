import java.*;
import java.util.Scanner;

public class Tictactoe{

  private String[][] board;
  private String currentPlayer;
  private char currentPlayerMark;


    

    public Tictactoe(){
        this.board = new String[3][3];
        this.currentPlayerMark = 'X';
        this.currentPlayer = "X";
    }

    public String getCurrentPlayer() {
        return this.currentPlayer;
    }
    public void createBoard() {
        for(int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                board[i][j] = "[ ]";
            }
        }
    }
    public void printBoard() {

        System.out.println("--------------");
        for (int	 i = 0; i<3; i++) {
            //System.out.print("[  ]");
            for (int j = 0; j<3; j++) {
                System.out.print(board[i][j]);

            }
            System.out.println();
        }
        System.out.println("--------------");
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[i][j].equals("[ ]")){
                    return false;
                }
            }
        }
        return true;
    }


    public boolean threeInARow(String spot1, String spot2, String spot3) {
        if (((spot1.equals("[X]")) && (spot1.equals(spot2)) && (spot2.equals(spot3)) || (spot1.equals("[O]") && (spot1.equals(spot2)) && (spot2.equals(spot3))))) {
            return true;
        }else{
            return false;
        }
    }

    public boolean rowWin() {
        for (int i = 0; i<3; i++) {
            if (threeInARow(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }

    public boolean colWin() {
        for (int j = 0; j < 3; j++) {
            if (threeInARow(board[0][j], board[1][j], board[2][j])) {
                return true;
            }
        }
        return false;
    }

    public boolean diaWin() {
        if (threeInARow(board[0][0], board[1][1], board[2][2]) || threeInARow(board[0][2], board[1][1], board[2][0])) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean hasWon() {
        if (rowWin() || colWin() || diaWin()) {
            return true;
        }
        else {
            return false;
        }
    }



    public boolean placeTile(int pos, char currMark) {
        if (pos == 1) {
            if (board[0][0].equals("[ ]")) {

                board[0][0] = "[" + currMark + "]";
                return true;
            }

        }
        else if (pos == 2) {
            if (board[0][1].equals("[ ]")) {
                board[0][1] = "[" + currMark + "]";
                return true;
            }
        }
        else if (pos == 3) {
            if (board[0][2].equals("[ ]")) {
                board[0][2] = "[" + currMark + "]";
                return true;
            }
        }
        else if (pos == 4) {
            if (board[1][0].equals("[ ]")) {
                board[1][0] = "[" + currMark + "]";
                return true;
            }
        }
        else if (pos == 5) {
            if (board[1][1].equals("[ ]")) {
                board[1][1] = "[" + currMark + "]";
                return true;
            }
        }
        else if (pos == 6) {
            if (board[1][2].equals("[ ]")) {
                board[1][2] = "[" + currMark + "]";
                return true;
            }
        }
        else if (pos == 7) {
            if (board[2][0].equals("[ ]")) {
                board[2][0] = "[" + currMark + "]";
                return true;
            }
        }
        else if (pos == 8) {
            if (board[2][1].equals("[ ]")) {
                board[2][1] = "[" + currMark + "]";
                return true;
            }
        }
        else if (pos == 9) {
            if (board[2][2].equals("[ ]")) {
                board[2][2] = "[" + currMark + "]";
                return true;
            }
        }
        else {
            return false;

        }

        return false;
    }


    public static void play(String currentPlayer, char currentPlayerMark, Tictactoe game){

        Scanner s = new Scanner(System.in);

        //String input = s.next();
        boolean cont = false;
        do{
            game.printBoard();
            System.out.println("Player: " + currentPlayer + ", enter a tile (1-9): ");

            int pos;
            pos = s.nextInt();
            if (pos < 0 || pos > 9){
                System.out.println("That is not a valid number, try again!");
            }
            else{
                cont = game.placeTile(pos, currentPlayerMark);
                if (cont == false){
                    System.out.println("That spot is occupied, try another one!");
                }
            }
        } while(!cont);
    }

    public static void main(String [] args) {
        Tictactoe game = new Tictactoe();
        game.createBoard();
        Scanner s = new Scanner(System.in);

        System.out.println("Player 1, what is your name? ");
        String player1 = s.next();
        System.out.println("Player 2, what is your name? ");
        String player2 = s.next();
        String currPlayer = player1;
        char currMark = 'X';
        do {
            play(currPlayer, currMark, game);


            if (game.hasWon()){
                game.printBoard();
                System.out.println("Player " + currPlayer + " has won! ");
                break;
            }
            if (currPlayer.equals(player1)){
                currPlayer = player2;

                currMark = 'O';
            }
            else if (currPlayer.equals(player2)){
                currPlayer = player1;

                currMark = 'X';
            }

            if (game.isFull()){
                game.printBoard();
                System.out.println("The board is full, it is a tie!" + '\n' + " Better luck next time!");
                break;
            }

        } while (!game.hasWon() && !game.isFull());
    }
}
