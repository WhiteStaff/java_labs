import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        int a, b;
        String word;
        FractionSet myset = new FractionSet();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 'help' for help");
        while (true) {
            word = scanner.next();

            switch (word) {
                case "exit":
                    System.exit(0);
                    break;
                case "min":
                    try
                    {
                        System.out.println("Beautiful view: " + myset.MinFractionView());
                        System.out.println("As value: " + myset.MinFractionNum());
                        System.out.print("Successful!");
                    }
                    catch (Exception e)
                    {
                        System.out.println("Set is empty");
                    }
                    break;
                case "max":
                    try {
                        System.out.println("Beautiful view: " + myset.MaxFractionView());
                        System.out.println("As value: " + myset.MaxFractionNum());
                        System.out.print("Successful!");
                    } catch (Exception e)
                    {
                        System.out.println("Set is empty");
                    }
                    break;
                case "less":
                    try {
                        System.out.print("Enter numerator: ");
                        a = scanner.nextInt();
                        System.out.print("Enter denumerator: ");
                        b = scanner.nextInt();
                        System.out.println(myset.AllLessThan(a, b));
                    } catch (Exception e) {
                        System.out.println("Numbers, please");
                    }
                    break;
                case "more":
                    try {
                        System.out.print("Enter numerator: ");
                        a = scanner.nextInt();
                        System.out.print("Enter denumerator: ");
                        b = scanner.nextInt();
                        System.out.println(myset.AllMoreThan(a, b));

                    } catch (Exception e) {
                        System.out.println("Numbers, please");
                    }
                    break;
                case "add":
                    try {
                        System.out.print("Enter numerator: ");
                        a = scanner.nextInt();
                        System.out.print("Enter denumerator: ");
                        b = scanner.nextInt();
                        myset.Add(a, b);
                        System.out.print("Successful!");
                    } catch (Exception e) {
                        System.out.println("Numbers, please");

                    }
                    break;
                case "help":
                    System.out.println("Enter 'exit' to exit\nEnter 'add' to add new fraction\nEnter 'min' to see minimum fraction\nEnter 'max' to see maximum fraction" +
                            "\nEnter less to compare your fraction with fraction set\nEnter more to compare your fraction with fraction set");
                    break;
                default:
                    System.out.println("Enter 'help' for help");
            }
        }
    }
}
