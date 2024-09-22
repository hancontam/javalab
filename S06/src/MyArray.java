import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * S06 - Delete duplicate elements in an array.
 *
 * @author HANNNCE180049
 */
public class MyArray {

    private int[] array;
    private int size;
    private Set<Integer> uniqueElements; // Renamed variable to match method usage

    /**
     * Constructs a MyArray object with a specified size.
     *
     * @param size The size of the array. Must be a positive number.
     */
    public MyArray(int size) {
        this.size = size;
        this.array = new int[size]; // Create an integer array with the specified size
        this.uniqueElements = new HashSet<>(); // Initialize the Set to store unique elements
    }

    /**
     * Inputs the elements of the array from the user. This method prompts the
     * user to enter values for each element in the array. It validates that
     * each input is an integer and handles invalid input appropriately.
     */
    public void inputElements(Scanner scanner) {
        System.out.println("Enter " + size + " elements:"); // Prompt for number of elements

        // Loop through all array indices to input values
        for (int i = 0; i < size; i++) {
            boolean validInput = false; // Flag to track valid input
            while (!validInput) { // Continue looping until valid input is received
                try {
                    System.out.print("Element[" + i + "] = "); // Prompt for individual element
                    String input = scanner.nextLine().trim(); // Read and trim the input
                    // Validate if input is a non-empty integer value
                    if (input.isEmpty() || !input.matches("\\d+")) {
                        // If input is invalid, throw an exception with an appropriate message
                        throw new IllegalArgumentException("Invalid input. Please enter an integer.");
                    }
                    array[i] = Integer.parseInt(input); // Parse and store the input as an integer
                    validInput = true; // Set flag to true indicating valid input received
                } catch (IllegalArgumentException e) {
                    // Catch and display any exception messages for invalid input
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    /**
     * Removes duplicate elements from the array. This method utilizes a Set to
     * track unique elements and updates the array to only include these unique
     * values, effectively removing any duplicates.
     */
    public void removeDuplicates() {
        int uniqueCount = 0; // Counter to keep track of the number of unique elements
        // Loop through each element in the array
        for (int i = 0; i < size; i++) {
            // If the element is added to the Set
            if (uniqueElements.add(array[i])) {
                // Store the unique element in the array and increment the counter
                array[uniqueCount] = array[i];
                uniqueCount++;
            }
        }
        // Update the size to reflect the number of unique elements
        size = uniqueCount;
    }

    /**
     * Displays the elements of the array. This method prints the array
     * elements, each separated by spaces.
     */
    public void displayArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "  "); // Print each element followed by two spaces
        }
        System.out.println(); // Move to the next line after printing all elements
    }

}
