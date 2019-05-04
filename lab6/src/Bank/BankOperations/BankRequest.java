package Bank.BankOperations;

import Bank.Account.AbstractAccount;

public class BankRequest {

    public static void doOperation(AbstractAccount abstractAccount, BankRequestTypes request) {
        if (request == BankRequestTypes.comission) abstractAccount.ApplyCommission();
        if (request == BankRequestTypes.percent) abstractAccount.ApplyPercent();
    }
}
