/**
 * Represents a commercial property.
 */
public class CommercialProperty extends Property {
    private String businessType;
    private int parkingSpaces;

    public CommercialProperty(String propertyId, String address, double price, String status, String businessType, int parkingSpaces) {
        super(propertyId, address, price, status);
        this.businessType = businessType;
        this.parkingSpaces = parkingSpaces;
    }

    public String getBusinessType() {
        return businessType;
    }

    public int getParkingSpaces() {
        return parkingSpaces;
    }

    @Override
    public String toString() {
        return super.toString() + ", Business Type=" + businessType + ", Parking Spaces=" + parkingSpaces+"]";
    }
}
