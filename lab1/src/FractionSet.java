import java.util.ArrayList;

import java.util.List;

public class FractionSet {
    private List<RationalFraction> BigSet = new ArrayList<RationalFraction>();

    public void Add(int a, int b)
    {
        RationalFraction Fraction = new RationalFraction(a, b);
        BigSet.add(Fraction);
        BigSet.sort(Fraction.comparator);
    }

    public String MinFractionView()
    {
        return (BigSet.get(0).getnumerator()+"/"+BigSet.get(0).getennumerator());
    }

    public float MinFractionNum()
    {
        return (BigSet.get(0).getvalue());
    }

    public String MaxFractionView()
    {
        return (BigSet.get(BigSet.size()-1).getnumerator()+"/"+BigSet.get(BigSet.size()-1).getennumerator());
    }

    public float MaxFractionNum()
    {
        return (BigSet.get(BigSet.size()-1).getvalue());
    }

    public int AllLessThan(int a, int b)
    {
        float current = ((float)a/(float)b);
        if (BigSet.get(0).getvalue() >= current) { return 0;}
        if (BigSet.get(BigSet.size() - 1).getvalue() == current) { return BigSet.size()-1; }
        if (BigSet.get(BigSet.size() - 1).getvalue() < current) { return BigSet.size(); }
        for (int i = 1; i < BigSet.size(); i++)
        {
            if ((BigSet.get(i-1).getvalue() > current) && (BigSet.get(i).getvalue() < current)) { return i-1; }
            if ((BigSet.get(i-1).getvalue() == current) && (BigSet.get(i).getvalue() < current)) { return i-2; }
        }
        return 0;
    }

    public int AllMoreThan(int a, int b)
    {
        float current = ((float)a/(float)b);
        if (BigSet.get(BigSet.size() - 1).getvalue() <= current) { return 0;}
        if (BigSet.get(0).getvalue() == current) { return BigSet.size()-1; }
        if (BigSet.get(0).getvalue() > current) { return BigSet.size(); }
        for (int i = 1; i < BigSet.size(); i++)
        {
            if ((BigSet.get(i-1).getvalue() > current) && (BigSet.get(i).getvalue() < current)) { return BigSet.size() - i; }
            if ((BigSet.get(i-1).getvalue() > current) && (BigSet.get(i).getvalue() == current)) { return BigSet.size() - i - 1; }
        }
        return 0;
    }

}
