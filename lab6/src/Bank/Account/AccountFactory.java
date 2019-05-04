package Bank.Account;

import Bank.Customer.Customer;

import java.util.Date;

public class AccountFactory {
    private double percents;
    private double comission;

    public AccountFactory(double percents, double comission) {
        this.comission = comission;
        this.percents = percents;
    }

    public Account createAccount(Customer customer, double balance, double limit) {
        if (customer.isInformationFull()) return new CreditAccount(customer, balance, limit, comission);
        else
            return new UnverifiedAccount(new CreditAccount(customer, balance, limit, comission));
    }

    public Account createAccount(Customer customer, double balance) {
        if (customer.isInformationFull()) return new UsualAccount(customer, balance, percents);
        else return new UnverifiedAccount(new UsualAccount(customer, balance, percents));
    }

    public Account createAccount(Customer customer, double balance, Date date, double percents) {
        if (customer.isInformationFull()) return new DepositAccount(customer, balance, date, percents);
        else return new UnverifiedAccount(new DepositAccount(customer, balance, date, percents));
    }
}
