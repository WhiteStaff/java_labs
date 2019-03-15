
import java.util.Comparator;

public class RationalFraction
{



    private float value;
    public Float getValue()
    {
        return value;
    }
    private int numerator;
    public Integer getNumerator()
    {
        return numerator;
    }
    private int denomerator;
    public Integer getDenomerator()
    {
        return denomerator;
    }


    RationalFraction(int a, int b)
    {
        this.value = (float)a/(float)b;
        this.numerator = a;
        this.denomerator = b;
    }
    Comparator<RationalFraction> comparator = Comparator.comparing(RationalFraction::getValue);
}
