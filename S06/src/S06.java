
import java.util.Scanner;

/**
 * S06 - Delete duplicate elements in an array.
 *
 * @author HANNNCE180049
 */
public class S06 {

    /**
     * Main method to run the program. The program prompts the user to enter the
     * size of an array, then input the elements of the array, remove duplicate
     * elements, and display the results.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read input from the keyboard
        int size = 0;
        boolean validInput = false; // Variable to check for valid input

        // Loop to get the size of the array from the user until a valid value is
        // entered
        while (!validInput) {
            try {
                System.out.print("Please enter the size of the array: "); // Prompt the user to enter the size of the
                                                                          // array
                String input = scanner.nextLine().trim(); // Read user input and remove extra whitespace
                // Check if the input is a positive integer
                if (input.isEmpty() || !input.matches("\\d+")) {
                    // If input is empty or not a positive integer, throw an exception
                    throw new IllegalArgumentException("Invalid input. Please enter a positive integer.");
                }
                size = Integer.parseInt(input); // Convert input to an integer
                if (size <= 0) {
                    // If size is less than or equal to 0, throw an exception
                    throw new IllegalArgumentException("Size must be greater than zero.");
                }
                validInput = true; // If input is valid, exit the loop
            } catch (IllegalArgumentException e) {
                // Catch the exception and display the error message
                System.out.println(e.getMessage());
            }
        }

        // Create a MyArray object with the size entered by the user
        MyArray arrayManipulator = new MyArray(size);
        arrayManipulator.inputElements(scanner); // Prompt the user to enter the array elements

        System.out.println("The original array:"); // Display a message
        arrayManipulator.displayArray(); // Display the original array with spaces between elements

        arrayManipulator.removeDuplicates(); // Remove duplicate elements

        System.out.println("The array after removing duplicate elements:"); // Display a message
        arrayManipulator.displayArray(); // Display the array after removing duplicate elements
        scanner.close();
    }
}
