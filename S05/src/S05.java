import java.util.Scanner;

/**
 * S05 - Analyze the user input string.
 *
 * @author HANNNCE180049
 */
public class S05 {

    /**
     * The main method is the starting point of the program.
     *
     * @param args It receives a string from the user and performs numeric and
     *             character analysis on that string.
     */
    public static void main(String[] args) {
        // Create a Scanner object to receive data from the keyboard
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("===== Analysis String program ====\n");

            // The input variable stores the string the user enters. Initially set to empty.
            String input = "";

            /**
             * Loop that asks the user to re-enter if the string is empty or f *
             * contains only whitespace (e.g. " "). `trim()` removes whitespace
             * from the beginning and end of the string before checking.
             * `isEmpty()` checks if the string is empty after removing
             * whitespace.
             */
            while (input.trim().isEmpty()) {
                System.out.print("Input String: ");
                input = scanner.nextLine();// // Read the user input from the console

                // Check the string after trimming to make sure it's not just whitespace
                if (input.trim().isEmpty()) {
                    System.out.println("Input cannot be empty or just whitespace! Please try again.");
                }
            }

            // Initialize NumberAnalyzer and CharacterAnalyzer objects
            NumberAnalyzer numberAnalyzer = new NumberAnalyzer();
            // Analyze numbers in the input string
            numberAnalyzer.analyzeNumbers(input);
            // Print the results of the numeric analysis
            numberAnalyzer.printResults();

            // Create an instance of CharacterAnalyzer
            CharacterAnalyzer characterAnalyzer = new CharacterAnalyzer();
            // Analyze characters in the input string
            characterAnalyzer.analyzeCharacters(input);
            // Print the results of the character analysis
            characterAnalyzer.printResults();

        } catch (Exception e) {
            // Handle any exceptions that may occur
            System.out.println("Exception: " + e.getMessage());
        }
        scanner.close();
    }
}
