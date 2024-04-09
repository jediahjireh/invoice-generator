
//import java packages
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//standalone class
public class FoodQuick {

    // main() method
    public static void main(String[] args) {
        // try-catch block
        try {
            // create customer object
            Customer customer = createCustomer();

            // create restaurant object
            Restaurant restaurant = createRestaurant();

            // find nearest driver
            String driverName = findNearestDriver(customer.getLocation());

            // write to invoice
            generateInvoice(customer, restaurant, driverName);

        } catch (Exception e) {
            // notify user of error occurrence(s)
            System.err.println("Error occurrence: " + e.getMessage());
        } finally {
            // close input scanner
            InputValidation.closeScanner();
        }
    }

    // method to create a Customer object
    public static Customer createCustomer() {
        // get user input for Customer object

        // get order number
        String orderNumber = InputValidation.validateStringInput("Enter order number: ");
        // get name
        String name = InputValidation.validateStringInput("Enter customer name: ");
        // get email address
        String email = InputValidation.validateStringInput("Enter customer email address: ");
        // get contact number
        String contactNumber = InputValidation.validateStringNumberInput("Enter customer phone number: ");
        // get customer location
        String location = InputValidation.validateStringInput("Enter customer location (city): ");
        // get delivery address
        String address = InputValidation.validateStringInput("Enter customer address: ");

        // create new maps
        Map<String, Integer> mealQuantity = new HashMap<>();
        Map<String, Double> mealPrice = new HashMap<>();

        // get meal order(s)
        InputValidation.validateMealInput(mealQuantity, mealPrice);

        // get special instructions
        String specialInstructions = InputValidation
                .validateStringInput("Enter any special preparation instructions: ");

        // create new Customer object and initialise total amount for calculation
        Customer customer = new Customer(name, location, contactNumber, orderNumber, email, address, mealQuantity,
                mealPrice, specialInstructions, 0.00);

        // display calculated total amount
        double totalAmount = customer.calculateTotalAmount();
        System.out.println("Total amount: " + totalAmount);

        // return new Customer object
        return customer;
    }

    // method to create a Restaurant object
    public static Restaurant createRestaurant() {
        // get user input for Restaurant object

        // get name
        String name = InputValidation.validateStringInput("Enter restaurant name: ");
        // get restaurant location
        String location = InputValidation.validateStringInput("Enter restaurant location (city): ");
        // get contact number
        String contactNumber = InputValidation.validateStringNumberInput("Enter restaurant phone number: ");

        // return new Restaurant object
        return new Restaurant(name, location, contactNumber);
    }

    // method to find the nearest driver
    public static String findNearestDriver(String customerLocation) {
        // declare variables
        String nearestDriver = null;

        // referenced https://ioflood.com/blog/integer-max-value-java/
        // website referenced for guidance on upper limit of an integer in Java
        int minLoad = Integer.MAX_VALUE;

        // try-catch block
        // new scanner object to read through new file object for drivers text file
        try (Scanner fileScanner = new Scanner(new File("src/driver-info.txt"))) {
            // iterate through lines of drivers text file
            while (fileScanner.hasNextLine()) {
                // read line of text file
                String line = fileScanner.nextLine();
                // split line up into information parts divided by a comma
                String[] parts = line.split(", ");
                // get driver location
                String driverLocation = parts[1];

                // find drivers in location
                if (driverLocation.equalsIgnoreCase(customerLocation)) {
                    // get driver load
                    int load = Integer.parseInt(parts[2]);

                    // find driver with least load
                    if (load <= minLoad) {
                        minLoad = load;
                        // get driver name
                        nearestDriver = parts[0];
                    }
                }
            }
            // close file scanner
            fileScanner.close();
        } catch (FileNotFoundException e) {
            // display error message
            System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            // notify user of error occurrence(s)
            System.err.println("An error occurred: " + e.getMessage());
        }
        // return driver's name
        return nearestDriver;
    }

    // method to write to invoice.txt - called in main() method
    public static void generateInvoice(Customer customer, Restaurant restaurant, String driverName) {
        // create new invoice text file
        try (Formatter formatter = new Formatter(new File("src/invoice.txt"))) {

            // if delivery is unavailable (location does not match a driver's location)
            if (driverName == null) {
                // only display on invoice
                formatter.format(
                        "Sorry! Our drivers are too far away from you to be able to deliver to your location.");
                // exit method
                return;
            }

            // write to text file - call getters
            // order number
            formatter.format("Order number %s%n", customer.getOrderNumber());
            // name
            formatter.format("Customer: %s%n", customer.getName());
            // email
            formatter.format("Email: %s%n", customer.getEmail());
            // contact number
            formatter.format("Phone number: %s%n", customer.getContactNumber());
            // location
            formatter.format("Location: %s%n%n", customer.getLocation());
            // restaurant name and location
            formatter.format("You have ordered the following from %s in %s:%n%n", restaurant.getName(),
                    restaurant.getLocation());

            // iterate over meal quantity and price maps to write ordered meals
            if (customer.getMealQuantity() != null && customer.getMealPrice() != null) {
                for (Map.Entry<String, Integer> entry : customer.getMealQuantity().entrySet()) {
                    // get meal name to display
                    String mealName = entry.getKey();
                    // get display meal quantity to display
                    int quantity = entry.getValue();
                    // get display meal price to display
                    double price = customer.getMealPrice().get(mealName);

                    // %d - integer value
                    // %.2f - floating-point rounded-off to 2 decimal places
                    formatter.format("%d x %s (R%.2f)%n", quantity, mealName, price);
                }
            }

            // special instructions
            formatter.format("%nSpecial instructions: %s%n%n", customer.getSpecialInstructions());

            // total amount
            formatter.format("Total: R%.2f%n%n", customer.calculateTotalAmount());

            // if driver name is found
            if (driverName != null) {
                // nearest driver
                formatter.format(
                        "%s is nearest to the restaurant and so he/she will be delivering your order to you at:%n%n",
                        driverName);

                // address
                formatter.format("%s%n%n", customer.getAddress());

                // restaurant contact number
                formatter.format("If you need to contact the restaurant, their number is %s.%n",
                        restaurant.getContactNumber());
            }

            // close formatter
            formatter.close();
        } catch (FileNotFoundException e) {
            // display error message
            System.out.println(e.getMessage());
        }
    }
}
