import java.util.*;

// TODO: see java naming conventions (method/field names are camelCase, class names are TitleCase)
// TODO: rename to `FractionList`
// TODO: make all fields final
// TODO: think (FL is immutable) vs (FL is mutable)
public class FractionList {
    // TODO: rename to `fractions` (`coefficients` in Polynomial)
    private List<RationalFraction> bigList = new ArrayList();
    private Map<RationalFraction, Integer> amountLess = new HashMap<>();
    private Map<RationalFraction, Integer> amountMore = new HashMap<>();

//    // when you implement primary ctor:
//    FractionList(List, Map, Map) {
//        this.bigList = bigList;
//        ...
//    }

//    // secondary ctors:
//    FractionList(List) {
//        this(..., new HashMap(), new HashMap())
//    }

//    FractionList(RationalFraction... fractions) {
//        // Note: fractions has type RationalFraction[]
//        this( Arrays.asList(fractions) );
//    }

    FractionList(List<RationalFraction> list)
    {
        bigList = list;
    }

    FractionList(RationalFraction... fractions)
    {
        bigList = Arrays.asList(fractions);
    }

    FractionList()
    {
    }


    public FractionList Sub(FractionList a)
    {
        FractionList x = new FractionList();
        int a1;
        a1 = this.bigList.size();
        if (a.bigList.size() > a1) { a1=a.bigList.size(); }
        for (int i = a1 - 1; i >= 0; i--)
        {
            x.Add(this.bigList.get(i).Sub(a.bigList.get(i)));
        }
        return x;
    }

    // this function is `mutator` => FL is mutable
    public void Add(int a, int b) {
        RationalFraction Fraction = new RationalFraction(a, b);
        bigList.add(Fraction);
        amountLess.clear();
        amountMore.clear();
    }

    public  void Add(RationalFraction Fraction)
    {
        bigList.add(Fraction);
        amountLess.clear();
        amountMore.clear();
    }

    public String MinFractionView() {
        return bigList.stream()
                .min(RationalFraction::compareTo)
                .toString();
    }

    public boolean IsEmpty() {
        return bigList.isEmpty();
    }

    public String MaxFractionView() {
        return bigList.stream()
                .max(RationalFraction::compareTo)
                .toString();
    }


    // TODO: pass Fraction as an argument
    // TODO: rename to `countLessThan`
    public long countLessThan(RationalFraction a) {
        // TODO: use Stream API

            return bigList.stream()
                    .filter(s -> s.getValue() < a.getValue())
                    .count();
    }

    public long countLessThan(int a1, int b) {
        RationalFraction a = new RationalFraction(a1, b);

        return bigList.stream()
                .filter(s -> s.getValue() < a.getValue())
                .count();
    }


    public long countMoreThan(int a1, int b) {
        RationalFraction a = new RationalFraction(a1, b);
        return bigList.stream()
                .filter(s -> s.getValue() > a.getValue())
                .count();
    }

}
