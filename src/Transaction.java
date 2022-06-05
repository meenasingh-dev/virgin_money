import java.time.LocalDate;
import java.util.Currency;
import java.util.Date;

public class Transaction {
    private LocalDate tranDate;
    private String vendor;
    private String type;
    private double  amount;
    private String category;

    public Transaction(LocalDate tranDate, String vendor, String type, double amount, String category) {
        this.tranDate = tranDate;
        this.vendor = vendor;
        this.type = type;
        this.amount = amount;
        this.category = category;
    }

    public LocalDate getTranDate() {
        return tranDate;
    }

    public String getVendor() {
        return vendor;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "tranDate=" + tranDate +
                ", vendor='" + vendor + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", category='" + category + '\'' +
                '}';
    }
}
