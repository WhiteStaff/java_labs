import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        RationalFraction f = new RationalFraction(1, 10);
//        FractionSet fs = new FractionSet(f1, f2, f3, f4);
//
//        System.out.println("Fraction: " + f);
//        System.out.println("Fractions: " + fs);
//        System.out.println("Min fraction: " + fs.getMin());

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
                    if (myset.IsEmpty()) {
                        System.out.println("Set is empty!!");
                        break;
                    }
                    System.out.println("Beautiful view: " + myset.MinFractionView());
                    System.out.println("As value: " + myset.MinFractionNum());
                    System.out.println("Successful!");
                    break;
                case "max":
                    if (myset.IsEmpty()) {
                        System.out.println("Set is empty!!");
                        break;
                    }
                    System.out.println("Beautiful view: " + myset.MaxFractionView());
                    System.out.println("As value: " + myset.MaxFractionNum());
                    System.out.println("Successful!");
                    break;
                case "less":
                    if (myset.IsEmpty()) {
                        System.out.println("Set is empty!!");
                        break;
                    }
                    try {
                        System.out.print("Enter numerator: ");
                        a = scanner.nextInt();
                        System.out.print("Enter denumerator: ");
                        b = scanner.nextInt();
                        System.out.println("Your fraction is bigger than " + myset.AllLessThan(a, b) + " fractions in set.");
                    } catch (Exception e) {
                        System.out.println("Numbers, please");
                    }
                    break;
                case "more":
                    if (myset.IsEmpty()) {
                        System.out.println("Set is empty!!");
                        break;
                    }
                    try {
                        System.out.print("Enter numerator: ");
                        a = scanner.nextInt();
                        System.out.print("Enter denumerator: ");
                        b = scanner.nextInt();
                        System.out.println("Your fraction is bigger than " + myset.AllMoreThan(a, b) + " fractions in set.");

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
                        System.out.println("Successful!");
                    } catch (Exception e) {
                        System.out.println("Numbers, please");

                    }
                    break;
//                case "file":
//                    File file = new File(scanner.next());
//                    try {
//                        Scanner fileScanner = new Scanner(file);
////                        fileScanner
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    }
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
