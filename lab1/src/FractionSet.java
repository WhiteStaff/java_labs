import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FractionSet {
    private List<RationalFraction> bigSet = new ArrayList<RationalFraction>();
    private Map<RationalFraction, Integer> amountLess = new HashMap<>();
    private Map<RationalFraction, Integer> amountMore = new HashMap<>();

    public void Add(int a, int b) {
        RationalFraction Fraction = new RationalFraction(a, b);
        bigSet.add(Fraction);
        bigSet.sort(Fraction.comparator);
        amountLess.clear();
        amountMore.clear();
    }

    public String MinFractionView() {
        return (bigSet.get(0).getNumerator() + "/" + bigSet.get(0).getDenomerator());
    }

    public String MinFractionNum() {
        return (String.format("%.5f", bigSet.get(0).getValue()));


    }

    public String MaxFractionView() {
        return (bigSet.get(bigSet.size() - 1).getNumerator() + "/" + bigSet.get(bigSet.size() - 1).getDenomerator());
    }

    public String MaxFractionNum() {
        return (String.format("%.5f", bigSet.get(bigSet.size() - 1).getValue()));
    }

    public int AllLessThan(int a, int b) {
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
                amountLess.put(current, i - 1);
                return i - 1;
            }
            if ((bigSet.get(i - 1).getValue().equals(current.getValue())) && (bigSet.get(i).getValue() > current.getValue())) {
                amountLess.put(current, i - 2);
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
