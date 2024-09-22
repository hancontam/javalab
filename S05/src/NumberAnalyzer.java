import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Math;

/**
 * S05 - Analyze the user input string.
 *
 * @author HANNNCE180049
 */

public class NumberAnalyzer {

    List<Integer> allNumbers = new ArrayList<>();
    List<Integer> evenNumbers = new ArrayList<>();
    List<Integer> oddNumbers = new ArrayList<>();
    List<Integer> squareNumbers = new ArrayList<>();

    /**
     * The getNumber method parses a string to find numbers, even numbers, odd
     * numbers, and square numbers
     *
     * @param input The input string containing numbers to analyze.
     */
    public void analyzeNumbers(String input) {
        // Use regular expression to find all numbers in string
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            // Extract the numeric string from the input
            int number = Integer.parseInt(matcher.group());

            // Add the found number to the list of all numbers
            allNumbers.add(number);

            // Check if the number is even
            if (number % 2 == 0) {
                // If it's even, add it to the list of even numbers
                evenNumbers.add(number);
            } else {
                // If it's odd, add it to the list of odd numbers
                oddNumbers.add(number);
            }

            // Check if the number is a perfect square
            // Calculate the square root of the number
            double sqrt = Math.sqrt(number);
            // Check if the square root is an integer
            if (sqrt == Math.floor(sqrt)) {
                // If true, add it to the list of square numbers
                squareNumbers.add(number);
            }
        }

    }

    /**
     * Prints the results of the number analysis.
     */
    public void printResults() {
        // display the square Numbers
        System.out.println("Square Numbers: " + squareNumbers);
        // display the Odd numbers
        System.out.println("Odd Numbers: " + oddNumbers);
        // display the evenNumbers
        System.out.println("Even Numbers: " + evenNumbers);
        // dis play the all NUmber
        System.out.println("All Numbers: " + allNumbers);
    }

}
