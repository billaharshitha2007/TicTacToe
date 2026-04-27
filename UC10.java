class UC10 {

    static char[][] board = {
        {'X', 'O', 'X'},
        {'X', 'O', 'O'},
        {'O', 'X', 'X'}
    };

    public static void main(String[] args) {

        if (isDraw()) {
            System.out.println("Game is a DRAW!");
        } else {
            System.out.println("Moves still possible.");
        }
    }

    // Method to check draw
    static boolean isDraw() {

        // Traverse entire board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                // If any cell is empty → not draw
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }

        // No empty cells → draw
        return true;
    }
}