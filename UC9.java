import java.util.Random;
import java.util.Scanner;

public class UC9 {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    static char currentPlayer = 'X'; // Human starts

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver) {

            displayBoard();

            if (currentPlayer == 'X') {
                // Human move
                System.out.print("Enter slot (1-9): ");
                int slot = sc.nextInt();

                int row = (slot - 1) / 3;
                int col = (slot - 1) % 3;

                if (isValidMove(row, col)) {
                    board[row][col] = 'X';
                } else {
                    System.out.println("Invalid move! Try again.");
                    continue; // retry same player
                }

            } else {
                // Computer move
                computerMove();
            }

            // Check win
            if (checkWin(currentPlayer)) {
                displayBoard();
                System.out.println(currentPlayer + " wins!");
                gameOver = true;
            }
            // Check draw
            else if (isBoardFull()) {
                displayBoard();
                System.out.println("It's a draw!");
                gameOver = true;
            }
            // Switch turn
            else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        sc.close();
    }

    // Validate move
    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    // Computer move (random valid)
    static void computerMove() {
        Random rand = new Random();

        while (true) {
            int slot = rand.nextInt(9) + 1;
            int row = (slot - 1) / 3;
            int col = (slot - 1) % 3;

            if (isValidMove(row, col)) {
                board[row][col] = 'O';
                System.out.println("Computer chose slot: " + slot);
                break;
            }
        }
    }

    // Check win
    static boolean checkWin(char player) {

        // Rows & Columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }

        // Diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }

    // Check draw
    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    // Display board
    static void displayBoard() {
        System.out.println("\nBoard:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}