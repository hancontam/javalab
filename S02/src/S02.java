import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * S02 - String Array Manipulations.
 *
 * @author HANNNCE180049
 */
public class S02 {

    /**
     * The main method, which is the starting point of the program. Asks the
     * user to enter the size of the array and the names to be sorted.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        // Initialize a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        int size = 0;

        while (true) { // Use a loop to ensure the user enters a correct size
            try {
                // Prompt the user to enter the size of the array
                System.out.println("Enter the value of n: ");

                // Read an integer value from the user
                size = scanner.nextInt();
                scanner.nextLine(); // Consume the remaining newline character

                // Check if the entered value is valid
                if (size > 50 || size <= 0) {
                    throw new IllegalArgumentException("Invalid size. Please enter a size between 1 and 50.");
                }
                break;

            } catch (InputMismatchException e) { // Handle the exception when input is not a number
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the non-integer input to avoid infinite loop
            } catch (IllegalArgumentException e) { // Handle invalid size exception
                System.out.println(e.getMessage());
            }
        }

        // Create an ArrayManipulations object with the entered size
        ArrayManipulations stringArray = new ArrayManipulations(size);

        stringArray.inputElements(scanner);// Call the method to input elements for the array

        stringArray.sortArray(); // Call the method to sort the array elements alphabetically

        // Display the sorted list of names
        System.out.println("List sorted names:");
        stringArray.displayArray();
        scanner.close();
    }
}
