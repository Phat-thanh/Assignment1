import java.util.Date;

/**
 *@author <Nguyen Thanh Phat> <s4054656>
 */
public class Payment {
    private String paymentId;
    private double amount;
    private Date paymentDate;
    private String method;

    public Payment(String paymentId, double amount, Date paymentDate, String method) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.method = method;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public String getMethod() {
        return method;
    }

    @Override
    public String toString() {
        return "Payment [ID=" + paymentId + ", Amount=" + amount + ", Date=" + paymentDate + ", Method=" + method + "]";
    }
}
