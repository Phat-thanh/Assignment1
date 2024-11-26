import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Represents a property owner.
 */
public class Owner extends Person {
    private List<Property> ownedProperties;

    public Owner(String id, String fullName, Date dateOfBirth, String contactInfo) {
        super(id, fullName, dateOfBirth, contactInfo);
        this.ownedProperties = new ArrayList<>();
    }

    public List<Property> getOwnedProperties() {
        return ownedProperties;
    }

    public void addOwnedProperty(Property property) {
        ownedProperties.add(property);
    }

    @Override
    public String toString() {
        return super.toString() + ", Owned Properties: " + ownedProperties.size();
    }
}
