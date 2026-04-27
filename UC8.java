import java.util.Scanner;
import java.util.Random;

public class UC8 {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    static char currentPlayer = 'X'; // X = Human, O = Computer

    public static void main(String[] args) {

        while (true) {

            displayBoard();

            if (currentPlayer == 'X') {
                humanMove();
            } else {
                computerMove();
            }

            // Check win
            if (checkWin()) {
                displayBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            // Check draw
            if (isBoardFull()) {
                displayBoard();
                System.out.println("Game is a Draw!");
                break;
            }

            // Switch turn
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    // Human move
    static void humanMove() {
        Scanner sc = new Scanner(System.in);
        int slot;

        while (true) {
            System.out.print("Enter slot (1-9): ");
            slot = sc.nextInt();

            int row = (slot - 1) / 3;
            int col = (slot - 1) % 3;

            if (isValidMove(row, col)) {
                board[row][col] = 'X';
                break;
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
    }

    // Computer move
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

    // Validate move (UC5)
    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    // Check win (basic)
    static boolean checkWin() {

        // Rows & Columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer &&
                board[i][1] == currentPlayer &&
                board[i][2] == currentPlayer)
                return true;

            if (board[0][i] == currentPlayer &&
                board[1][i] == currentPlayer &&
                board[2][i] == currentPlayer)
                return true;
        }

        // Diagonals
        if (board[0][0] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][2] == currentPlayer)
            return true;

        if (board[0][2] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][0] == currentPlayer)
            return true;

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