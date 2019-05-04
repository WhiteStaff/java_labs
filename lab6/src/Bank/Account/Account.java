package Bank.Account;

import Bank.Customer.Customer;
import Bank.Exceptions.InvalidTransferExeption;

public abstract class Account {
    protected Customer customer;
    protected double balance;

    void TransferMoney(double money, Customer customer)
    {
        if (!customer.equals(this.customer)) throw new InvalidTransferExeption("You can't transfer money to other customer");
    }

    public void Deposit(double value) {
        balance += value;
    }

    public abstract void Withdraw(double value);

    public abstract void ApplyPercent();

    public abstract void ApplyCommission();
}
