/**
 * S05 - Analyze the user input string.
 *
 * @author HanNNCE180049
 */

public class CharacterAnalyzer {

    StringBuilder allChars = new StringBuilder();
    StringBuilder upperChars = new StringBuilder();
    StringBuilder lowerChars = new StringBuilder();
    StringBuilder specialChars = new StringBuilder();

    /**
     * Analyzes the characters in the input string and categorizes them.
     *
     * @param input The string to analyze.
     */
    public void analyzeCharacters(String input) {

        // Convert the input string to an array of characters and iterate over each
        // character
        for (char ch : input.toCharArray()) {
            // Character classification
            if (Character.isUpperCase(ch)) {
                // If character is uppercase, append to upperChars
                upperChars.append(ch);
                allChars.append(ch); // Add the character to the list of all characters
            } else if (Character.isLowerCase(ch)) {
                // If character is lowercase, append to lowerChars
                lowerChars.append(ch);
                allChars.append(ch); // Add the character to the list of all characters
            } else if (!Character.isDigit(ch)) {
                // If character is not a digit (i.e., it's a special character), append to
                // specialChars
                specialChars.append(ch);
                allChars.append(ch); // Add the character to the list of all characters
            }
        }
    }

    /**
     * Prints the results of the character analysis
     */
    public void printResults() {
        // Display the uppercase characters
        System.out.println("Upper Characters: " + upperChars);
        // Display the lowercase characters
        System.out.println("Lower Characters: " + lowerChars);
        // Display the special characters
        System.out.println("Special Characters: " + specialChars);
        // Display all characters in the input string
        System.out.println("All Characters: " + allChars);
    }
}
