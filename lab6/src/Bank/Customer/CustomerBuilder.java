package Bank.Customer;

import Bank.Exceptions.IncorrectDataException;

public class CustomerBuilder {
    private String name;
    private String surname;
    private String passport;
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    Customer Build() {
        if (name == null || surname == null)
            throw new IncorrectDataException("Name or Surname not found");
        return new Customer(name, surname, passport, address);
    }

}
