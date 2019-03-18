import java.util.*;

// TODO: see java naming conventions (method/field names are camelCase, class names are TitleCase)
// TODO: rename to `FractionList`
// TODO: make all fields final
// TODO: think (FL is immutable) vs (FL is mutable)
public class FractionSet {
    // TODO: rename to `fractions` (`coefficients` in Polynomial)
    private List<RationalFraction> bigSet = new ArrayList<RationalFraction>();
    private Map<RationalFraction, Integer> amountLess = new HashMap<>();
    private Map<RationalFraction, Integer> amountMore = new HashMap<>();

//    // when you implement primary ctor:
//    FractionSet(List, Map, Map) {
//        this.bigSet = bigSet;
//        ...
//    }

//    // secondary ctors:
//    FractionSet(List) {
//        this(..., new HashMap(), new HashMap())
//    }

//    FractionSet(RationalFraction... fractions) {
//        // Note: fractions has type RationalFraction[]
//        this( Arrays.asList(fractions) );
//    }

    // this function is `mutator` => FL is mutable
    public void Add(int a, int b) {
        RationalFraction Fraction = new RationalFraction(a, b);
        bigSet.add(Fraction);
//        bigSet.sort(Fraction.comparator);
        bigSet.sort(Comparator.naturalOrder());
        amountLess.clear();
        amountMore.clear();
    }

    public String MinFractionView() {
        return (bigSet.get(0).getNumerator() + "/" + bigSet.get(0).getDenomerator());
    }

    public String MinFractionNum() {
        return (String.format("%.5f", bigSet.get(0).getValue()));
    }

    public boolean IsEmpty() {
        return bigSet.isEmpty();
    }

    public String MaxFractionView() {
        return (bigSet.get(bigSet.size() - 1).getNumerator() + "/" + bigSet.get(bigSet.size() - 1).getDenomerator());
    }

    public String MaxFractionNum() {
        return (String.format("%.5f", bigSet.get(bigSet.size() - 1).getValue()));
    }


    // TODO: pass Fraction as an argument
    // TODO: rename to `countLessThan`
    public int AllLessThan(int a, int b) {
        // TODO: use Stream API

        if (!amountLess.isEmpty()) {
            System.out.println("Previous requests:\n");

            amountLess.forEach((current, key) -> System.out.println(current.getNumerator() + "/" + current.getDenomerator() +
                    "(" + String.format("%.5f", current.getValue()) + ") is bigger than " + key + " values in set."));
        }
        RationalFraction current = new RationalFraction(a, b);
        if (bigSet.get(0).getValue() >= current.getValue()) {
            amountLess.put(current, 0);
            return 0;
        }
        if (bigSet.get(bigSet.size() - 1).getValue() == current.getValue()) {
            amountLess.put(current, bigSet.size() - 1);
            return bigSet.size() - 1;
        }
        if (bigSet.get(bigSet.size() - 1).getValue() < current.getValue()) {
            amountLess.put(current, bigSet.size());
            return bigSet.size();
        }
        for (int i = 1; i < bigSet.size(); i++) {
            if ((bigSet.get(i - 1).getValue() < current.getValue()) && (bigSet.get(i).getValue() > current.getValue())) {
                amountLess.put(current, i);
                return i - 1;
            }
            if ((bigSet.get(i - 1).getValue().equals(current.getValue())) && (bigSet.get(i).getValue() > current.getValue())) {
                amountLess.put(current, i - 1);
                return i - 2;
            }
        }
        return 0;
    }

    public int AllMoreThan(int a, int b) {
        if (!amountMore.isEmpty()) {
            System.out.println("Previous requests:\n");

            amountMore.forEach((current, key) -> System.out.println(current.getNumerator() + "/" + current.getDenomerator() +
                    "(" + String.format("%.5f", current.getValue()) + ") is less than " + key + " values in set."));
        }
        RationalFraction current = new RationalFraction(a, b);
        if (bigSet.get(bigSet.size() - 1).getValue() <= current.getValue()) {
            amountMore.put(current, 0);
            return 0;
        }
        if (bigSet.get(0).getValue() == current.getValue()) {
            amountMore.put(current, bigSet.size() - 1);
            return bigSet.size() - 1;
        }
        if (bigSet.get(0).getValue() > current.getValue()) {
            amountMore.put(current, bigSet.size());
            return bigSet.size();
        }
        for (int i = 1; i < bigSet.size(); i++) {
            if ((bigSet.get(i - 1).getValue() < current.getValue()) && (bigSet.get(i).getValue() > current.getValue())) {
                amountMore.put(current, bigSet.size() - 1);
                return bigSet.size() - i;
            }
            if ((bigSet.get(i - 1).getValue() < current.getValue()) && (bigSet.get(i).getValue().equals(current.getValue()))) {
                amountMore.put(current, bigSet.size() - i - 1);
                return bigSet.size() - i - 1;
            }
        }
        return 0;
    }

}
