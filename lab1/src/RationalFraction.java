public class RationalFraction implements Comparable<RationalFraction> {
    private float value;
    //Comparator<RationalFraction> comparator = Comparator.comparing(RationalFraction::getValue);
    private int numerator;
    private int denomerator;

    RationalFraction(int a, int b) {
        int del = egcd(a, b);
        this.value = (float) a / (float) b;
        if (a*b>0) {a = Math.abs(a); b = Math.abs(b);}
        this.numerator = a / del;
        this.denomerator = b / del;
    }

    RationalFraction()
    {
        this.value = 1;
        this.numerator = 1;
        this.denomerator = 1;
    }

    RationalFraction(int a)
    {
        this.value = a;
        this.numerator = a;
        this.denomerator = 1;
    }

    public Float getValue() {
        return value;
    }

    public RationalFraction Sub(RationalFraction a)
    {
        return new RationalFraction(this.numerator * a.denomerator, a.numerator * this.denomerator);

    }

    private int egcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0)
            return b;

        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }

        return a;
    }

    @Override
    public String toString() {
//        return String.format("RationalFraction{value=%s, numerator=%d, denomerator=%d}", value, numerator, denomerator);
        return String.format("%d / %d", numerator, denomerator);
    }

    @Override
    public int compareTo(RationalFraction other) {
        return Float.compare(this.getValue(), other.getValue());
    }
}
