package Bank.Account;

import Bank.Customer.Customer;
import Bank.Exceptions.WithdrawException;

class CreditAccount extends AbstractAccount {

    private double creditLimit;
    private double commission;

    public CreditAccount(Customer customer, double balance, double creditLimit, double commission) {
        this.commission = commission;
        this.creditLimit = creditLimit;
        this.balance = balance;
        this.customer = customer;
    }

    @Override
    public void Withdraw(double value) {
        if (balance - value < creditLimit)
            throw new WithdrawException("Not enough money");
        balance -= value;
    }

    @Override
    public void ApplyPercent() {

    }

    @Override
    public void ApplyCommission() {
        if (balance < 0) balance -= commission;
    }


}
