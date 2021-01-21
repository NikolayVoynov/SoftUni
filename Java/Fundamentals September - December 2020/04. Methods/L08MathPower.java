import java.text.DecimalFormat;
import java.util.Scanner;

public class L08MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        int powerOf = Integer.parseInt(scanner.nextLine());

        System.out.println(new DecimalFormat("0.####").format(resultPowerOf(number, powerOf)));
    }

    private static double resultPowerOf(double number, int powerOf) {
        return Math.pow(number, powerOf);
    }
}
