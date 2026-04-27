public class UC5 {

    // Create empty board
    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    public static void main(String[] args) {

        int row = 1;
        int col = 1;

        boolean valid = isValidMove(row, col);

        System.out.println("Move at (" + row + "," + col + ") is valid: " + valid);
    }

    // Method to validate move
    static boolean isValidMove(int row, int col) {

        // Check boundaries
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        // Check if cell is empty
        if (board[row][col] != '-') {
            return false;
        }

        return true;
    }
}