
//import java package
import java.util.Map;

//subclass
public class Customer extends Order {
    // attributes
    private String orderNumber;
    private String email;
    private String address;
    // meal name to quantity
    private Map<String, Integer> mealQuantity;
    // meal name to price
    private Map<String, Double> mealPrice;
    private String specialInstructions;
    private double totalAmount;

    // constructor
    public Customer(String name, String location, String contactNumber, String orderNumber, String email,
            String address, Map<String, Integer> mealQuantity, Map<String, Double> mealPrice,
            String specialInstructions, double totalAmount) {
        super(name, location, contactNumber);
        this.orderNumber = orderNumber;
        this.email = email;
        this.address = address;
        this.mealQuantity = mealQuantity;
        this.mealPrice = mealPrice;
        this.specialInstructions = specialInstructions;
        this.totalAmount = totalAmount;
    }

    // getters from Order superclass (non-static methods)
    public String getName() {
        return super.getName();
    }

    public String getContactNumber() {
        return super.getContactNumber();
    }

    public String getLocation() {
        return super.getLocation();
    }

    // getters for Customer subclass
    public String getOrderNumber() {
        return orderNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        // format address display
        return address.replace(", ", "\n");
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    // getters for maps
    public Map<String, Integer> getMealQuantity() {
        return mealQuantity;
    }

    public Map<String, Double> getMealPrice() {
        return mealPrice;
    }

    // method to calculate the total amount of the order
    public double calculateTotalAmount() {
        // initialise total amount
        totalAmount = 0.0;
        // iterate over meal quantity and price maps to calculate total of ordered meals
        if (mealQuantity != null && mealPrice != null) {
            for (Map.Entry<String, Integer> entry : mealQuantity.entrySet()) {
                // get meal name
                String mealName = entry.getKey();
                // get meal quantity
                int quantity = entry.getValue();
                // get meal price (use default value if price not found)
                double price = mealPrice.getOrDefault(mealName, 0.0);

                // calculate total amount
                totalAmount += quantity * price;
            }
        }
        // if meal quantity and/or price is null
        else {
            totalAmount = 0.0;
        }
        // send calculated total amount rounded-off to 2 decimal places
        return totalAmount;
    }
}
