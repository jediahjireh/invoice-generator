//subclass
public class Restaurant extends Order {
    public Restaurant(String name, String location, String contactNumber) {
        super(name, location, contactNumber);
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
}
