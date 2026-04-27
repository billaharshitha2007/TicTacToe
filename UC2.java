import java.util.Random;

public class UC2 {

    static String currentPlayer;
    static char humanSymbol;
    static char computerSymbol;

    public static void main(String[] args) {
        displayTossResult();
    }

    // Method to perform toss and assign symbols
    static void displayTossResult() {
        Random rand = new Random();

        // 0 or 1 random toss
        int toss = rand.nextInt(2);

        if (toss == 0) {
            currentPlayer = "Human";
            humanSymbol = 'X';
            computerSymbol = 'O';
        } else {
            currentPlayer = "Computer";
            humanSymbol = 'O';
            computerSymbol = 'X';
        }

        // Output
        System.out.println("=== Toss Result ===");
        System.out.println("First Player: " + currentPlayer);
        System.out.println("Human Symbol: " + humanSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);
    }
}