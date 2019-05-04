package Bank.Account;

import Bank.Customer.Customer;
import Bank.Exceptions.WithdrawException;

import java.util.Date;

class DepositAccount extends AbstractAccount {
    private Date date;
    private double startBalance;
    private double percents;

    public DepositAccount(Customer customer, double balance, Date date, double percents) {
        this.date = date;
        this.startBalance = this.balance = balance;
        this.customer = customer;
        this.percents =percents;
    }

@Override
    public void Withdraw(double value) {
        if (date.before(new Date())) throw new WithdrawException("It's too early to withdraw money");
        if (balance - value < 0) throw new WithdrawException("Not enough money");
        balance-=value;
    }

@Override
    public void ApplyPercent() {
        balance += startBalance*percents;
    }

    @Override
    public void ApplyCommission() {

    }

}
