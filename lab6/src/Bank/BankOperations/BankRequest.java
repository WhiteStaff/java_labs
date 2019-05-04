package Bank.BankOperations;

import Bank.Account.Account;

public class BankRequest {

    public static void doOperation(Account account, BankRequestTypes request) {
        if (request == BankRequestTypes.comission) account.ApplyCommission();
        if (request == BankRequestTypes.percent) account.ApplyPercent();
    }
}
