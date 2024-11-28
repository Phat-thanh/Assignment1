import java.util.Date;

/**
 * @author <Nguyen Thanh Phat - s40564656>
 */
public class RentalAgreement {
    private String agreementId;
    private String propertyId;
    private String tenantId;
    private String ownerId;
    private double rentAmount;
    private String rentalPeriod; // Daily, Weekly, Monthly
    private String status; // New, Active, Completed
    private Date startDate;

    public RentalAgreement(String agreementId, String propertyId, String tenantId, String ownerId, double rentAmount,
                           String rentalPeriod, String status, Date startDate) {
        this.agreementId = agreementId;
        this.propertyId = propertyId;
        this.tenantId = tenantId;
        this.ownerId = ownerId;
        this.rentAmount = rentAmount;
        this.rentalPeriod = rentalPeriod;
        this.status = status;
        this.startDate = startDate;
    }

    public String getAgreementId() {
        return agreementId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public String getRentalPeriod() {
        return rentalPeriod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return "RentalAgreement [ID=" + agreementId + ", PropertyID=" + propertyId + ", TenantID=" + tenantId +
               ", OwnerID=" + ownerId + ", RentAmount=" + rentAmount + ", Period=" + rentalPeriod +
               ", Status=" + status + ", StartDate=" + startDate + "]";
    }
}
