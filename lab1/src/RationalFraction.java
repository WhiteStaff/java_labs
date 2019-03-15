
import java.util.Comparator;

public class RationalFraction
{



    private float value;
    public Float getvalue()
    {
        return value;
    }
    private int numerator;
    public Integer getnumerator()
    {
        return numerator;
    }
    private int denomerator;
    public Integer getennumerator()
    {
        return numerator;
    }


    RationalFraction(int a, int b)
    {
        this.value = (float)a/(float)b;
        this.numerator = a;
        this.denomerator = b;
    }
    Comparator<RationalFraction> comparator = Comparator.comparing(RationalFraction::getvalue);
}
