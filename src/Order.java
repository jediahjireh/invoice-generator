//superclass
public class Order {
    // attributes
    private String name;
    private String location;
    private String contactNumber;

    // constructor
    public Order(String name, String location, String contactNumber) {
        this.name = name;
        this.location = location;
        this.contactNumber = contactNumber;
    }

    // getters (non-static methods)
    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getLocation() {
        return location;
    }

}
