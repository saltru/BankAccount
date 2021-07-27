import java.util.Calendar;
import java.util.Date;

public class BankAccountCurrency extends BankAccount implements ICashable {
    protected String currencyName;
    protected double currencyRate;

    BankAccountCurrency() {
        this.name = "UNKNOWN";
        this.dateOfCreation = Calendar.getInstance().getTime();
        this.accountNumber = "0000000000";
        this.moneyAmount = 0.0;
        this.currencyName = "RUB";
        this.currencyRate = 1.0;
    }

    BankAccountCurrency(String name, Date dateOfCreation, String accountNumber, double moneyAmount,
                        String currencyName, double currencyRate)
    {
        this.name = name;
        this.dateOfCreation = dateOfCreation;
        this.accountNumber = accountNumber;
        this.moneyAmount = moneyAmount;
        this.currencyName = currencyName;
        this.currencyRate = currencyRate;

        if (currencyRate <= 0.0)
            currencyRate = 1.0;
    }

    BankAccountCurrency(BankAccountCurrency bankAccount) {
        this.name = bankAccount.name;
        this.dateOfCreation = bankAccount.dateOfCreation;
        this.accountNumber = bankAccount.accountNumber;
        this.moneyAmount = bankAccount.moneyAmount;
        this.currencyName = bankAccount.currencyName;
        this.currencyRate = bankAccount.currencyRate;

        if (currencyRate <= 0.0)
            currencyRate = 1.0;
    }

    public double cashIn(double value) throws Exception {
        if (value > 0.0) {
            moneyAmount += value / currencyRate;
        } else {
            throw new Exception("Value must be positive!");
        }

        return moneyAmount;
    }

    public double cashOut(double value) throws Exception {
        if (value > 0.0) {
            if (moneyAmount * currencyRate > value) {
                moneyAmount -= value / currencyRate;
            }
            else {
                throw new Exception(accountNumber.toString() + " " + name + ": Not enough money!");
            }
        } else {
            throw new Exception(accountNumber.toString() + " " + name + ": Value must be positive!");
        }

        return moneyAmount;
    }
}
