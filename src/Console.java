import java.util.Scanner;

public class Console {

    private static Scanner scanner=new Scanner(System.in);
    public static double readValue(String promt)
    {
        return scanner.nextDouble();
    }
    public static double readValue(String promt, int min, int max) {
        double value;
        while (true) {
            System.out.print(promt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("enter value between " + min + " and " + max);
        }
        return value;
    }
}
