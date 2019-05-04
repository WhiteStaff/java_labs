package Bank.Account;

import Bank.Customer.Customer;
import Bank.Exceptions.WithdrawException;

public class UsualAbstractAccount extends AbstractAccount {
    private double percent;

    public UsualAbstractAccount(Customer customer, double balance, double percent) {
        this.percent = percent;
        this.balance = balance;
        this.customer = customer;
    }

    @Override
    public void Withdraw(double value) {
        if (balance - value < 0)
            throw new WithdrawException("Not enough money");
        balance -= value;
    }

    @Override
    public void ApplyPercent() {
        balance += balance * percent;
    }

    @Override
    public void ApplyCommission() {

    }


}
