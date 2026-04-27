import java.util.Scanner;

public class UC3 {

    public static void main(String[] args) {
        int slot = getUserSlot();
        System.out.println("Slot entered: " + slot);
    }

    // Method to read slot input from user
    static int getUserSlot() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a slot number (1-9): ");
        int slot = sc.nextInt();

        return slot; // return the entered value
    }
}