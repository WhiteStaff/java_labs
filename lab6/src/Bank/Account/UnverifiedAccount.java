package Bank.Account;

import Bank.Customer.Customer;
import Bank.Exceptions.InvalidTransferExeption;
import Bank.Exceptions.WithdrawException;

public class UnverifiedAccount extends Account {
    private double limitForUnveryfied = 100;
    private Account account;

    public UnverifiedAccount(Account account) {
        this.account = account;
    }

    @Override
    void TransferMoney(double value, Customer customer) {
        if (value < limitForUnveryfied) account.Withdraw(value);
        else throw new InvalidTransferExeption("Can't withdraw that much with unverified account");
    }

    @Override
    public void Deposit(double value)
    {
        account.Deposit(value);
    }

    @Override
    public void Withdraw(double value) {
        if (value < limitForUnveryfied) account.Withdraw(value);
        else throw new WithdrawException("Can't withdraw that much with unverified account");

    }

    @Override
    public void ApplyPercent() {
        account.ApplyPercent();
    }

    @Override
    public void ApplyCommission() {
        account.ApplyCommission();
    }
}
