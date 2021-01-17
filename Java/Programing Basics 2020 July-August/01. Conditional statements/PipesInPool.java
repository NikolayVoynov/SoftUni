import java.io.PrintStream;
import java.util.Scanner;

public class PipesInPool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int poolV = Integer.parseInt(scanner.nextLine());
        int p1 = Integer.parseInt(scanner.nextLine());
        int p2 = Integer.parseInt(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double p1V = h * p1;
        double p2V = h * p2;
        double pipesV = p1V + p2V;
        double p1VPercentage = p1V / pipesV * 100;
        double p2VPercentage = p2V / pipesV * 100;
        double pipesVPercentage = pipesV / poolV * 100;

        if (pipesV <= poolV) {
            String percentage = "%";
            System.out.printf("The pool is %.2f" + "%s full.", pipesVPercentage, percentage);
            System.out.printf("Pipe 1: %.2f" + "%s.", p1VPercentage, percentage);
            System.out.printf("Pipe 2: %.2f%s.", p2VPercentage, percentage);

        } else {
            double overflow = pipesV - poolV;
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", h, overflow);
        }


    }
}
