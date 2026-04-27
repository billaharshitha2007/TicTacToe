public class UC6 {

    // Board initialization
    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    public static void main(String[] args) {

        int row = 1;
        int col = 2;
        char symbol = 'X';

        updateBoard(row, col, symbol);
        displayBoard();
    }

    // Method to update board
    static void updateBoard(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Method to display board
    static void displayBoard() {
        System.out.println("Current Board:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}