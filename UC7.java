import java.util.Random;

public class UC7 {

    // Board
    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    public static void main(String[] args) {

        computerMove();
        displayBoard();
    }

    // Computer makes a random valid move
    static void computerMove() {
        Random rand = new Random();

        int row, col;

        while (true) {
            int slot = rand.nextInt(9) + 1; // 1 to 9

            // Convert slot to row & column (reuse UC4 logic)
            row = (slot - 1) / 3;
            col = (slot - 1) % 3;

            // Check if valid (reuse UC5 logic)
            if (board[row][col] == '-') {
                board[row][col] = 'O'; // Computer symbol
                System.out.println("Computer chose slot: " + slot);
                break;
            }
        }
    }

    // Display board
    static void displayBoard() {
        System.out.println("Board after computer move:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}