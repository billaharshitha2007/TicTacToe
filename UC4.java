public class UC4 {

    public static void main(String[] args) {
        int slot = 5; // you can change this value for testing

        int row = getRow(slot);
        int col = getCol(slot);

        System.out.println("Slot: " + slot);
        System.out.println("Row: " + row);
        System.out.println("Column: " + col);
    }

    // Method to calculate row
    static int getRow(int slot) {
        return (slot - 1) / 3;
    }

    // Method to calculate column
    static int getCol(int slot) {
        return (slot - 1) % 3;
    }
}