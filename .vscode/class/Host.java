import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *@author <Nguyen Thanh Phat> <s4054656>
 */
public class Host extends Person {
    private List<Property> managedProperties;

    public Host(String id, String fullName, Date dateOfBirth, String contactInfo) {
        super(id, fullName, dateOfBirth, contactInfo);
        this.managedProperties = new ArrayList<>();
    }

    public List<Property> getManagedProperties() {
        return managedProperties;
    }

    public void addManagedProperty(Property property) {
        managedProperties.add(property);
    }

    @Override
    public String toString() {
        return super.toString() + ", Managed Properties: " + managedProperties.size();
    }
}
