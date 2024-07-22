// package org.aptechph;
import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            char player = 'X';
            boolean gameWon = false;
            
            for (int i = 0; i < 9; i++) { // Remove the semicolon at the end of the for loop
                printBoard();
                System.out.println("Player " + player + ", enter your move (row [1 - 3] and column [1 - 3]): ");
                int row = scanner.nextInt() - 1;
                int column = scanner.nextInt() - 1;
                
                if (board[row][column] == ' ') {
                    board[row][column] = player;
                    gameWon = checkWin(player);
                    if (gameWon) {
                        printBoard();
                        System.out.println("Player " + player + " wins!");
                        break; // Exit the loop when the game is won
                    }
                    player = (player == 'X') ? 'O' : 'X';
                } else {
                    System.out.println("This move is not valid");
                    i--; // Decrement i to retry this move
                }
                
                if (i == 8 && !gameWon) { // Check for a draw after 9 moves
                    printBoard();
                    System.out.println("The game is a draw!");
                    break; // Exit the loop when the game is a draw
                }
            }
        }
    }

    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean checkWin(char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        // Check diagonals
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }
}
