import java.util.Map;
import java.util.Scanner;

//class for input validation
public class InputValidation {
    // create new scanner object to read user input
    private static Scanner scanner = new Scanner(System.in);

    // method to validate string data entries
    public static String validateStringInput(String prompt) {
        // declare input variable
        String strInput;

        // repeat prompt if input is null
        do {
            // print out prompt
            System.out.print(prompt);
            // use scanner to read user input
            strInput = scanner.nextLine().trim();

            // check if entry is null
            if (strInput.isEmpty()) {
                // notify user
                System.out.println("Please provide an input entry.");
            }
        } while (strInput.isEmpty());

        // return validated input
        return strInput;
    }

    // method to validate double data entries
    public static double validateDoubleInput(String prompt) {
        // declare variable
        String input;
        // initialise variable
        double doubleInput = 0;

        // repeat prompt until a valid number is entered (break encountered)
        do {
            // print out prompt
            System.out.print(prompt);
            // read user input and remove whitespace
            input = scanner.nextLine().trim();

            // try-catch block
            try {
                // check if input can be cast to a double data type
                doubleInput = Double.parseDouble(input);
                // exit do-while loop if casting succeeds
                break;
            } catch (NumberFormatException e) {
                // notify user
                System.out.println("Invalid input! Please enter a valid number.");
            }
        } while (true);

        // return validated input of a double data type
        return doubleInput;
    }

    // method to validate integer data entries
    public static int validateIntegerInput(String prompt) {
        // declare variable
        String intInput;

        // repeat prompt until user inputs a positive integer
        do {
            // print out prompt
            System.out.print(prompt);
            // read user input and remove whitespace
            intInput = scanner.nextLine().trim();

            // check if input matches the pattern for a positive integer
            if (!intInput.matches("\\d+")) {
                // notify user about invalid input
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        } while (!intInput.matches("\\d+"));

        // return validated input
        return Integer.parseInt(intInput);
    }

    // method to validate string-integer data entries (e.g. contact/ID numbers)
    public static String validateStringNumberInput(String prompt) {
        // declare variable
        String input;

        // repeat prompt until user inputs a positive integer
        do {
            // print out prompt
            System.out.print(prompt);
            // read user input and remove whitespace
            input = scanner.nextLine().trim();

            // check if input matches the pattern for a positive integer
            if (!input.matches("\\d+")) {
                // notify user about invalid input
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        } while (!input.matches("\\d+"));

        // return validated input
        return input;
    }

    // method to update map input
    public static void validateMealInput(Map<String, Integer> mealQuantity, Map<String, Double> mealPrice) {
        // check if loop is to be repeated (an entry of 'OK' terminates loop)
        while (true) {
            // get meal name
            System.out.println("Enter meal name: \t(Enter 'OK' to terminate prompt)");
            // retrieve user input
            String meal = scanner.nextLine().trim();

            // check if loop terminator input 'OK' was entered
            if (meal.equalsIgnoreCase("OK")) {
                break;
            }

            // get meal quantity
            int quantity = validateIntegerInput("Enter quantity for " + meal + ": ");
            // add meal quantity to map
            mealQuantity.put(meal, quantity);

            // get meal price
            double price = validateDoubleInput("Enter price of " + meal + ": ");
            // add meal price to map
            mealPrice.put(meal, price);
        }
    }

    // method to close scanner reading input
    public static void closeScanner() {
        scanner.close();
    }
}
