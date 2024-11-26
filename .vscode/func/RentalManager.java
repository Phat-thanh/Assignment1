import java.util.List;

/**
 * Interface defining rental management operations.
 */
public interface RentalManager {

    // Methods for managing Rental Agreements
    void addRental(RentalAgreement rental); // Add a new rental agreement
    void updateRental(String rentalId, String status); // Update the status of a rental agreement
    void deleteRental(String rentalId); // Delete a rental agreement
    List<RentalAgreement> getAllRentals(); // Retrieve all rental agreements
    List<RentalAgreement> getRentalsByOwner(String ownerId); // Get rentals by owner
    List<RentalAgreement> getRentalsByProperty(String propertyId); // Get rentals by property
    List<RentalAgreement> getRentalsByStatus(String status); // Get rentals by status

    // Methods for managing other entities
    List<Tenant> getAllTenants(); // Retrieve all tenants
    List<Host> getAllHosts(); // Retrieve all hosts
    List<Owner> getAllOwners(); // Retrieve all owners
    List<Property> getAllProperties(); // Retrieve all properties

    // File operations
    void loadSampleData(); // Load initial data from files
    void saveDataToFile(); // Save current data to files
}
