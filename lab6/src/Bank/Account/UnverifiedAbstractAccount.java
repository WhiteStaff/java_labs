package Bank.Account;

import Bank.Customer.Customer;
import Bank.Exceptions.InvalidTransferExeption;
import Bank.Exceptions.WithdrawException;

public class UnverifiedAbstractAccount implements Account {
    private double limitForUnverified = 100;
    private AbstractAccount abstractAccount;

    public UnverifiedAbstractAccount(AbstractAccount abstractAccount) {
        this.abstractAccount = abstractAccount;
    }


    void TransferMoney(double value, Customer customer) {
        if (value < limitForUnverified) abstractAccount.Withdraw(value);
        else throw new InvalidTransferExeption("Can't withdraw that much with unverified abstractAccount");
    }


    public void Deposit(double value)
    {
        abstractAccount.Deposit(value);
    }

    @Override
    public void Withdraw(double value) {
        if (value < limitForUnverified) abstractAccount.Withdraw(value);
        else throw new WithdrawException("Can't withdraw that much with unverified abstractAccount");

    }

    @Override
    public void ApplyPercent() {
        abstractAccount.ApplyPercent();
    }

    @Override
    public void ApplyCommission() {
        abstractAccount.ApplyCommission();
    }
}
