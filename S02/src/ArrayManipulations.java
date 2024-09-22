import java.util.Scanner;

/**
 * S02 - String Array Manipulations.
 *
 * @author HANNNCE180049
 */
public class ArrayManipulations {

    private String[] array;
    private int size;

    /**
     * Constructor for the ArrayManipulations class.
     *
     * @param size The size of the array, must be a positive number.
     */
    public ArrayManipulations(int size) {
        this.size = size;
        this.array = new String[size];
    }

    /**
     * Method to input names from the user and ensure they are non-empty and
     * alphabetic.
     */
    public void inputElements(Scanner scanner) {
        // Create a Scanner object to read user input
        System.out.println("Enter " + size + " names"); // Prompt the user to enter names

        // Loop to input each name
        for (int i = 0; i < size; i++) {
            String input = ""; // Variable to store user input
            boolean validInput = false; // Flag to check if the input is valid

            // Loop until a valid input is provided
            while (!validInput) {
                try {
                    input = scanner.nextLine().trim(); // Read input and remove leading/trailing spaces
                    if (input.isEmpty()) { // Check if input is empty
                        throw new IllegalArgumentException("String cannot be empty.");
                    }

                    // Check if input contains only alphabetic characters
                    for (char c : input.toCharArray()) {
                        if (!Character.isLetter(c)) {
                            throw new IllegalArgumentException("Name can only contain letters.");
                        }
                    }

                    validInput = true; // If input is valid, exit the loop
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage()); // Print error message for invalid input
                }
            }

            array[i] = input; // Store the valid input in the array
        }
    }

    /**
     * Method to print all names in the array.
     */
    public void displayArray() {
        // Loop through the array and print each name with its corresponding index
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + array[i]);
        }
    }

    /**
     * Method to sort the names in the array alphabetically, case insensitive.
     */
    public void sortArray() {
        // Outer loop iterates through each element in the array except the last one.
        // Each pass through the array places the next largest element in its correct
        // position.
        for (int i = 0; i < size - 1; i++) {
            // Inner loop compares adjacent elements in the array.
            // With each pass, the largest unsorted element bubbles up to its correct
            // position.
            for (int j = 0; j < size - i - 1; j++) {
                // Compare adjacent elements and ignore case differences
                if (array[j].compareToIgnoreCase(array[j + 1]) > 0) { // Change '<' to '>' for ascending order
                    // Swap elements if the current element is greater than the next
                    String temp = array[j]; // Temporarily store the current element
                    array[j] = array[j + 1]; // Move the next element to the current position
                    array[j + 1] = temp; // Place the current element in the next position
                }
            }
        }
    }
}
