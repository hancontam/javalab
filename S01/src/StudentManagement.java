import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * S01 Manage student
 *
 * @author HANNNCE180049
 */
public class StudentManagement {

    private static final String fileName = "Student.txt"; // The file name where the student list is saved
    private List<Student> studentList = new ArrayList<>(); // The list to store students dynamically
    private static final String[] MONTHS = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "July", "August", "Sep", "Oct",
            "Nov", "Dec" }; // Array to represent months

    /**
     * Method to enter student information and save it to a file
     *
     * @param scanner Scanner object for input
     */
    public void enterStudentList(Scanner scanner) {
        String studentCode;
        String studentName;
        String dateOfBirth = "";
        double learningPoint;

        // Enter student code
        while (true) {
            try {
                System.out.print("Student code: "); // Prompt user to enter student code
                studentCode = scanner.nextLine(); // Read the student code input

                // Check if the student code already exists
                if (isStudentCodeExists(studentCode)) {
                    throw new IllegalArgumentException("Student code already exists. Please try again"); // Throw
                                                                                                         // exception if
                                                                                                         // the code
                                                                                                         // exists
                }
                if (studentCode.isEmpty() || !studentCode.matches("^[A-Z]+\\d+$")) {
                    throw new IllegalArgumentException("Incorrect format, Please enter capital letters"); // Validate
                                                                                                          // the format
                                                                                                          // of student
                                                                                                          // code
                }
                break; // Exit loop if the input is valid
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // Print error message if the input is invalid
            }
        }

        // Enter student name
        while (true) {
            try {
                System.out.print("Student name: "); // Prompt user to enter student name
                studentName = scanner.nextLine(); // Read the student name input
                if (studentName.isEmpty() || !studentName.matches("^[A-Z][a-z]*( [A-Z][a-z]*)*$")) {
                    throw new IllegalArgumentException("Incorrect, please enter first letter in capital"); // Validate
                                                                                                           // the format
                                                                                                           // of student
                                                                                                           // name
                }
                break; // Exit loop if the input is valid
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // Print error message if the input is invalid
            }
        }

        // Enter date of birth
        while (true) {
            try {
                System.out.print("Date of birth: "); // Prompt user to enter date of birth
                dateOfBirth = scanner.nextLine(); // Read the date of birth input

                // Check if the year of birth is less than or equal to 2004
                if (!validateDateOfBirth(dateOfBirth)) {
                    throw new IllegalArgumentException("Incorrect, please try again. Date format is incorrect "); // Validate
                                                                                                                  // the
                                                                                                                  // date
                                                                                                                  // of
                                                                                                                  // birth
                }
                break; // Exit loop if the input is valid
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // Print error message if the input is invalid
            }
        }

        // Enter learning point
        while (true) {
            try {
                System.out.print("Learning point: "); // Prompt user to enter learning point
                learningPoint = Double.parseDouble(scanner.nextLine()); // Read and parse the learning point input
                if (learningPoint < 0 || learningPoint > 4) {
                    throw new IllegalArgumentException("Learning point must be between 0 and 4"); // Validate the range
                                                                                                  // of learning point
                }
                break; // Exit loop if the input is valid
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number for learning point."); // Handle invalid
                                                                                                      // number format
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // Print error message if the input is invalid
            }
        }

        // Create a student object and add it to the list
        Student student = new Student(studentCode, studentName, dateOfBirth, learningPoint); // Create new student with
                                                                                             // input data
        studentList.add(student); // Add the student to the list
        saveToFile(); // Save the updated student list to the file
    }

    /**
     * Method to search for a student by name
     *
     * @param scanner Scanner object for input
     */
    public void lookUpStudent(Scanner scanner) {
        System.out.print("Please enter student name: "); // Prompt user to enter student name
        String name = scanner.nextLine(); // Read the student name input
        boolean found = false; // Flag to indicate if the student is found

        // Search through the student list to find a match by name
        for (Student student : studentList) {
            if (student.getStudentName().equalsIgnoreCase(name)) { // Compare names case-insensitively
                student.printStudent(); // Print student details if found
                found = true; // Set flag to true if student is found
                break; // Exit loop after finding the student
            }
        }

        // If no match is found
        if (!found) {
            System.out.println("Student not found."); // Print message if student is not found
        }
    }

    /**
     *
     * Method to display all students in the list
     */
    public void displayStudentList() {
        System.out.println("Student list:");
        System.out.println("---------------------------");
        loadFromFile(); // Load student data from file
        for (Student student : studentList) { // Iterate over the student list
            student.printStudent(); // Print each student's details
        }
    }

    /**
     * This private method checks whether a student with the given code already
     * exists in the internal list.
     *
     * @param studentCode the student code to check for
     * @return true if the student code exists, false otherwise
     */
    private boolean isStudentCodeExists(String studentCode) {
        // Check if the provided student code matches any existing student
        for (Student student : studentList) {
            if (student.getStudentCode().equals(studentCode)) {
                return true;

            }
        }
        return false; // Return false if the student code does not exist
    }

    /**
     * Save student list to file
     */
    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) { // Open a BufferedWriter to write
                                                                                     // to the file
            Collections.sort(studentList); // Sort the student list before saving
            for (Student student : studentList) { // Iterate over the sorted list
                writer.write(student.toString()); // Write each student's data as a string to the file
                writer.newLine(); // Add a newline after each student
            }
        } catch (IOException e) { // Catch any I/O exceptions
            System.out.println("Error writing to file: " + e.getMessage()); // Print error message if an exception
                                                                            // occurs
        }
    }

    /**
     * Load student list from file
     */
    private void loadFromFile() {
        studentList.clear(); // Clear current list before loading
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) { // Open a BufferedReader to read
                                                                                     // from the file
            String line;

            // Read each line from the file and create a student object
            while ((line = reader.readLine()) != null) { // Continue reading until no more lines
                String[] data = line.split("#"); // Split the line by the '#' delimiter
                String studentCode = data[0];
                String studentName = data[1];
                String dateOfBirth = data[2];
                double learningPoint = Double.parseDouble(data[3]); // Parse and get learning point
                Student student = new Student(studentCode, studentName, dateOfBirth, learningPoint); // Create new
                                                                                                     // student with
                                                                                                     // parsed data
                studentList.add(student); // Add the student to the list
            }
        } catch (IOException e) { // Catch any I/O exceptions
            System.out.println("Error reading file: " + e.getMessage()); // Print error message if an exception occurs
        }
    }

    /**
     * This private method validates the student's date of birth.
     *
     * @param dateOfBirth Validate the date of birth and check year must less
     *                    than 2004
     * @return Return correct date format
     */
    private boolean validateDateOfBirth(String dateOfBirth) {
        try {
            // Split the date into day, month, and year
            String[] parts = dateOfBirth.split("-"); // Split date by the '-' delimiter
            int day = Integer.parseInt(parts[0]); // Parse day from the first part
            String month = parts[1]; // Get month from the second part
            int year = Integer.parseInt(parts[2]); // Parse year from the third part

            // Check if the year is greater than 2004
            if (Year.now().getValue() - year >= 18) {
                return false; // Return false if the year is greater than 2004
            }

            // Validate the month
            boolean validMonth = false; // Flag to track if month is valid
            for (String m : MONTHS) { // Iterate over the MONTHS array
                if (month.equals(m)) { // Check if the input month matches any in the array
                    validMonth = true; // Set flag to true if match found
                    break; // Exit loop
                }
            }

            if (!validMonth) {
                return false; // Return false if month is invalid
            }

            // Check valid day based on the month
            switch (month) {
                case "Feb":
                    // Check for February
                    return day >= 1 && day <= 28; // February has 28 days
                case "Apr":
                case "Jun":
                case "Sep":
                case "Nov":
                    return day >= 1 && day <= 30; // These months have 30 days
                default:
                    return day >= 1 && day <= 31; // Other months have 31 days
            }
        } catch (NumberFormatException e) { // Catch any parsing errors or invalid input
            return false; // Return false if validation fails
        }
    }
}
