package Bank.Account;

import Bank.Customer.Customer;
import Bank.Exceptions.InvalidTransferExeption;

public abstract class AbstractAccount implements Account{
    protected Customer customer;
    protected double balance;

    void TransferMoney(double money, Customer customer)
    {
        if (!customer.equals(this.customer)) throw new InvalidTransferExeption("You can't transfer money to other customer");
    }

    public void Deposit(double value) {
        balance += value;
    }

}
