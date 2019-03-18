public class RationalFraction implements Comparable<RationalFraction> {
    private float value;
    //    Comparator<RationalFraction> comparator = Comparator.comparing(RationalFraction::getValue);
    private int numerator;
    private int denomerator;

    RationalFraction(int a, int b) {
        this.value = (float) a / (float) b;
        this.numerator = a;
        this.denomerator = b;
    }

    public Float getValue() {
        return value;
    }

    public Integer getNumerator() {
        return numerator;
    }

    public Integer getDenomerator() {
        return denomerator;
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
