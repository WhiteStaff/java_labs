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
        if (customer.isInformationFull()) return new CreditAbstractAccount(customer, balance, limit, comission);
        else
            return new UnverifiedAbstractAccount(new CreditAbstractAccount(customer, balance, limit, comission));
    }

    public Account createAccount(Customer customer, double balance) {
        if (customer.isInformationFull()) return new UsualAbstractAccount(customer, balance, percents);
        else return new UnverifiedAbstractAccount(new UsualAbstractAccount(customer, balance, percents));
    }

    public Account createAccount(Customer customer, double balance, Date date, double percents) {
        if (customer.isInformationFull()) return new DepositAbstractAccount(customer, balance, date, percents);
        else return new UnverifiedAbstractAccount(new DepositAbstractAccount(customer, balance, date, percents));
    }
}
