package Bank.Customer;

public class Customer {
    private String name;
    private String surname;
    private String passport;
    private String address;

    public Customer(String name, String surname, String passport, String address)
    {
        this.name = name;
        this.surname = surname;
        this.passport = passport;
        this.address = address;
    }

    public boolean isInformationFull()
    {
        return ((passport == null) || (address == null));
    }
}
