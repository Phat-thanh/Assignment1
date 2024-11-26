/**
 * Base class for properties.
 */
public class Property {
    private String propertyId;
    private String address;
    private double price;
    private String status; // Available, Rented, Under Maintenance

    public Property(String propertyId, String address, double price, String status) {
        this.propertyId = propertyId;
        this.address = address;
        this.price = price;
        this.status = status;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public String getAddress() {
        return address;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Property [ID=" + propertyId + ", Address=" + address + ", Price=" + price + ", Status=" + status + "]";
    }
}
