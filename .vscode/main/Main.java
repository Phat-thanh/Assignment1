import java.util.*;

/**
 * Main application for the Rental Management System.
 */
public class Main {
    private static RentalManager rentalManager = new RentalManagerImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        // Load data from CSV files
        rentalManager.loadSampleData();

        while (!exit) {
            System.out.println("\n=== Rental Management System ===");
            System.out.println("1. View All Rentals");
            System.out.println("2. Add Rental");
            System.out.println("3. Update Rental");
            System.out.println("4. Delete Rental");
            System.out.println("5. View Tenants");
            System.out.println("6. View Hosts");
            System.out.println("7. View Owners");
            System.out.println("8. View Properties");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    viewRentals();
                    break;
                case "2":
                    addRental();
                    break;
                case "3":
                    updateRental();
                    break;
                case "4":
                    deleteRental();
                    break;
                case "5":
                    viewTenants();
                    break;
                case "6":
                    viewHosts();
                    break;
                case "7":
                    viewOwners();
                    break;
                case "8":
                    viewProperties();
                    break;
                case "9":
                    exit = true;
                    rentalManager.saveDataToFile();
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    // Function to view all rental agreements
    private static void viewRentals() {
        List<RentalAgreement> rentals = rentalManager.getAllRentals();
        if (rentals.isEmpty()) {
            System.out.println("No rental agreements available.");
        } else {
            rentals.forEach(System.out::println);
        }
    }

    // Function to add a new rental agreement
    private static void addRental() {
        System.out.println("\n--- Add Rental Agreement ---");
        System.out.print("Enter Rental ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Property ID: ");
        String propertyId = scanner.nextLine();
        System.out.print("Enter Tenant ID: ");
        String tenantId = scanner.nextLine();
        System.out.print("Enter Owner ID: ");
        String ownerId = scanner.nextLine();
        System.out.print("Enter Rent Amount: ");
        double rentAmount = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Rental Period (Daily/Weekly/Monthly): ");
        String period = scanner.nextLine();
        System.out.print("Enter Status (New/Active/Completed): ");
        String status = scanner.nextLine();

        RentalAgreement rental = new RentalAgreement(id, propertyId, tenantId, ownerId, rentAmount, period, status, new Date());
        rentalManager.addRental(rental);
        System.out.println("Rental agreement added successfully.");
    }

    // Function to update a rental agreement
    private static void updateRental() {
        System.out.println("\n--- Update Rental Agreement ---");
        System.out.print("Enter Rental ID to update: ");
        String id = scanner.nextLine();
        System.out.print("Enter new status (New/Active/Completed): ");
        String status = scanner.nextLine();

        try {
            rentalManager.updateRental(id, status);
            System.out.println("Rental agreement updated successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // Function to delete a rental agreement
    private static void deleteRental() {
        System.out.println("\n--- Delete Rental Agreement ---");
        System.out.print("Enter Rental ID to delete: ");
        String id = scanner.nextLine();
        rentalManager.deleteRental(id);
        System.out.println("Rental agreement deleted successfully.");
    }

    // Function to view all tenants
    private static void viewTenants() {
        List<Tenant> tenants = rentalManager.getAllTenants();
        if (tenants.isEmpty()) {
            System.out.println("No tenants available.");
        } else {
            tenants.forEach(System.out::println);
        }
    }

    // Function to view all hosts
    private static void viewHosts() {
        List<Host> hosts = rentalManager.getAllHosts();
        if (hosts.isEmpty()) {
            System.out.println("No hosts available.");
        } else {
            hosts.forEach(System.out::println);
        }
    }

    // Function to view all owners
    private static void viewOwners() {
        List<Owner> owners = rentalManager.getAllOwners();
        if (owners.isEmpty()) {
            System.out.println("No owners available.");
        } else {
            owners.forEach(System.out::println);
        }
    }

    // Function to view all properties
    private static void viewProperties() {
        List<Property> properties = rentalManager.getAllProperties();
        if (properties.isEmpty()) {
            System.out.println("No properties available.");
        } else {
            properties.forEach(System.out::println);
        }
    }
}
