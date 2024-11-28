/**
 * Represents a residential property.
 */
public class ResidentialProperty extends Property {
    private int bedrooms;
    private boolean allowsPets;

    public ResidentialProperty(String propertyId, String address, double price, String status, int bedrooms, boolean allowsPets) {
        super(propertyId, address, price, status);
        this.bedrooms = bedrooms;
        this.allowsPets = allowsPets;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public boolean isAllowsPets() {
        return allowsPets;
    }

    @Override
    public String toString() {
        return super.toString() + ", Bedrooms=" + bedrooms + ", Allows Pets=" + allowsPets+"]";
    }
}
