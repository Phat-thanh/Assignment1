import java.util.ArrayList;
import java.util.List;
import java.util.Date;
/**
 *@author <Nguyen Thanh Phat> <s4054656>
 */
public class Tenant extends Person {
    private List<RentalAgreement> rentalAgreements;
    private List<Payment> payments;

    public Tenant(String id, String fullName, Date dateOfBirth, String contactInfo) {
        super(id, fullName, dateOfBirth, contactInfo);
        this.rentalAgreements = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    public List<RentalAgreement> getRentalAgreements() {
        return rentalAgreements;
    }

    public void addRentalAgreement(RentalAgreement agreement) {
        rentalAgreements.add(agreement);
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    @Override
    public String toString() {
        return super.toString() + ", Rental Agreements: " + rentalAgreements.size() + ", Payments: " + payments.size();
    }
}
