import java.util.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Implementation of the RentalManager interface.
 */
public class RentalManagerImpl implements RentalManager {
    private List<RentalAgreement> rentals;
    private List<Tenant> tenants;
    private List<Host> hosts;
    private List<Owner> owners;
    private List<Property> properties;

    private static final String RENTALS_FILE = "data/rentals.csv";
    private static final String TENANTS_FILE = "data/tenants.csv";
    private static final String HOSTS_FILE = "data/hosts.csv";
    private static final String OWNERS_FILE = "data/owners.csv";
    private static final String PROPERTIES_FILE = "data/properties.csv";

    public RentalManagerImpl() {
        rentals = new ArrayList<>();
        tenants = new ArrayList<>();
        hosts = new ArrayList<>();
        owners = new ArrayList<>();
        properties = new ArrayList<>();
    }

    // Rental Agreement Management
    @Override
    public void addRental(RentalAgreement rental) {
        rentals.add(rental);
    }

    @Override
    public void updateRental(String rentalId, String status) {
        for (RentalAgreement rental : rentals) {
            if (rental.getAgreementId().equals(rentalId)) {
                rental.setStatus(status);
                return;
            }
        }
        throw new IllegalArgumentException("Rental ID not found.");
    }

    @Override
    public void deleteRental(String rentalId) {
        rentals.removeIf(rental -> rental.getAgreementId().equals(rentalId));
    }

    @Override
    public List<RentalAgreement> getAllRentals() {
        return rentals;
    }

    @Override
    public List<RentalAgreement> getRentalsByOwner(String ownerId) {
        List<RentalAgreement> results = new ArrayList<>();
        for (RentalAgreement rental : rentals) {
            if (rental.getOwnerId().equals(ownerId)) {
                results.add(rental);
            }
        }
        return results;
    }

    @Override
    public List<RentalAgreement> getRentalsByProperty(String propertyId) {
        List<RentalAgreement> results = new ArrayList<>();
        for (RentalAgreement rental : rentals) {
            if (rental.getPropertyId().equals(propertyId)) {
                results.add(rental);
            }
        }
        return results;
    }

    @Override
    public List<RentalAgreement> getRentalsByStatus(String status) {
        List<RentalAgreement> results = new ArrayList<>();
        for (RentalAgreement rental : rentals) {
            if (rental.getStatus().equalsIgnoreCase(status)) {
                results.add(rental);
            }
        }
        return results;
    }

    // Other Entities Management
    @Override
    public List<Tenant> getAllTenants() {
        return tenants;
    }

    @Override
    public List<Host> getAllHosts() {
        return hosts;
    }

    @Override
    public List<Owner> getAllOwners() {
        return owners;
    }

    @Override
    public List<Property> getAllProperties() {
        return properties;
    }

    // File Operations
    @Override
    public void loadSampleData() {
        loadRentals();
        loadTenants();
        loadHosts();
        loadOwners();
        loadProperties();
    }

    @Override
    public void saveDataToFile() {
        saveRentals();
        saveTenants();
        saveHosts();
        saveOwners();
        saveProperties();
    }

    // Private helper methods for file I/O
    private void loadRentals() {
        try (BufferedReader reader = new BufferedReader(new FileReader(RENTALS_FILE))) {
            String line;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày tháng
    
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                rentals.add(new RentalAgreement(
                    parts[0], // Rental ID
                    parts[1], // Property ID
                    parts[2], // Tenant ID
                    parts[3], // Owner ID
                    Double.parseDouble(parts[4]), // Rent Amount
                    parts[5], // Rental Period
                    parts[6], // Status
                    dateFormat.parse(parts[7]) // Chuyển chuỗi ngày thành Date
                ));
            }
        } catch (IOException e) {
            System.out.println("Error loading rentals: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }
    }

    private void saveRentals() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RENTALS_FILE))) {
            for (RentalAgreement rental : rentals) {
                writer.write(String.join(",",
                        rental.getAgreementId(),
                        rental.getPropertyId(),
                        rental.getTenantId(),
                        rental.getOwnerId(),
                        String.valueOf(rental.getRentAmount()),
                        rental.getRentalPeriod(),
                        rental.getStatus(),
                        String.valueOf(rental.getStartDate().getTime())
                ));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving rentals: " + e.getMessage());
        }
    }

private void loadTenants() {
    try (BufferedReader reader = new BufferedReader(new FileReader(TENANTS_FILE))) {
        String line;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày tháng

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            tenants.add(new Tenant(
                parts[0], // Tenant ID
                parts[1], // Full Name
                dateFormat.parse(parts[2]), // Chuyển chuỗi ngày thành Date
                parts[3]  // Contact Info
            ));
        }
    } catch (IOException e) {
        System.out.println("Error loading tenants: " + e.getMessage());
    } catch (ParseException e) {
        System.out.println("Error parsing date: " + e.getMessage());
    }
}
    private void saveTenants() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TENANTS_FILE))) {
            for (Tenant tenant : tenants) {
                writer.write(String.join(",",
                        tenant.getId(),
                        tenant.getFullName(),
                        String.valueOf(tenant.getDateOfBirth().getTime()),
                        tenant.getContactInfo()
                ));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tenants: " + e.getMessage());
        }
    }

    private void loadHosts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(HOSTS_FILE))) {
            String line;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày tháng
    
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                hosts.add(new Host(
                    parts[0], // Host ID
                    parts[1], // Full Name
                    dateFormat.parse(parts[2]), // Chuyển chuỗi ngày thành Date
                    parts[3]  // Contact Info
                ));
            }
        } catch (IOException e) {
            System.out.println("Error loading hosts: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }
    }

    private void saveHosts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HOSTS_FILE))) {
            for (Host host : hosts) {
                writer.write(String.join(",",
                        host.getId(),
                        host.getFullName(),
                        String.valueOf(host.getDateOfBirth().getTime()),
                        host.getContactInfo()
                ));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving hosts: " + e.getMessage());
        }
    }

    private void loadOwners() {
        try (BufferedReader reader = new BufferedReader(new FileReader(OWNERS_FILE))) {
            String line;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                owners.add(new Owner(
                    parts[0], // Owner ID
                    parts[1], // Full Name
                    dateFormat.parse(parts[2]), // Date of Birth
                    parts[3]  // Contact Info
                ));
            }
        } catch (IOException e) {
            System.out.println("Error loading owners: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }
    }
    
    private void saveOwners() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OWNERS_FILE))) {
            for (Owner owner : owners) {
                writer.write(String.join(",",
                        owner.getId(),
                        owner.getFullName(),
                        String.valueOf(owner.getDateOfBirth().getTime()),
                        owner.getContactInfo()
                ));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving owners: " + e.getMessage());
        }
    }

    private void loadProperties() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PROPERTIES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                properties.add(new Property(parts[0], parts[1], Double.parseDouble(parts[2]), parts[3]));
            }
        } catch (IOException e) {
            System.out.println("Error loading properties: " + e.getMessage());
        }
    }

    private void saveProperties() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PROPERTIES_FILE))) {
            for (Property property : properties) {
                writer.write(String.join(",",
                        property.getPropertyId(),
                        property.getAddress(),
                        String.valueOf(property.getPrice()),
                        property.getStatus()
                ));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving properties: " + e.getMessage());
        }
    }
}
