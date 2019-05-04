
import Bank.Account.Account;
import Bank.Account.AccountFactory;
import Bank.BankOperations.BankRequest;
import Bank.BankOperations.BankRequestTypes;
import Bank.Customer.Customer;
import Bank.Customer.CustomerBuilder;

public class  Main {

    public static void main(String[] args) {
        CustomerBuilder ass = new CustomerBuilder();
        ass.setName("1212");
        ass.setSurname("fssfs");
        Customer qwerty = ass.Build();
        AccountFactory fff = new AccountFactory(10, 100);
        Account asd = fff.createUsualAccount(qwerty, 100);
        BankRequest.doOperation(asd, BankRequestTypes.percent);
        System.out.println(asd.getBalance());
        }
}
