public class Polynom {

    private FractionList list;

    Polynom(FractionList a)
    {
        list = a;
    }

    public Polynom Sum(Polynom a)
    {
        return new Polynom(this.list.Sub(a.list));
    }
}
