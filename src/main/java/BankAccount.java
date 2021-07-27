import java.util.Calendar;
import java.util.Date;

public abstract class BankAccount implements ICashable {
    protected String name;
    protected Date dateOfCreation;
    protected String accountNumber;
    protected double moneyAmount;

    BankAccount() {
        this.name = "UNKNOWN";
        this.dateOfCreation = Calendar.getInstance().getTime();
        this.accountNumber = "0000000000";
        this.moneyAmount = 0.0;
    }

    BankAccount(String name, Date dateOfCreation, String accountNumber, double moneyAmount)
    {
        this.name = name;
        this.dateOfCreation = dateOfCreation;
        this.accountNumber = accountNumber;
        this.moneyAmount = moneyAmount;
    }

    BankAccount(BankAccount bankAccount) {
        this.name = bankAccount.name;
        this.dateOfCreation = bankAccount.dateOfCreation;
        this.accountNumber = bankAccount.accountNumber;
        this.moneyAmount = bankAccount.moneyAmount;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public abstract double cashIn(double value) throws Exception;

    public abstract double cashOut(double value) throws Exception;
}
