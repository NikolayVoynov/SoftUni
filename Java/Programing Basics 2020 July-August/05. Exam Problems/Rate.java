import java.util.Scanner;

public class Rate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//•	Първоначално вложена сума S – реално положително число [0.01….1000000.00];
//•	Брой месеци за вложението – цяло положително число [1-100];

        double investment = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());

        double sumSimpleInterest = 0;
        double sumComplexInterest = 0;

        sumSimpleInterest = investment + investment * 0.03;
        sumComplexInterest = investment + investment * 0.027;

        for (int i = 1; i < months; i++) {
            sumSimpleInterest = sumSimpleInterest + investment * 0.03;
            sumComplexInterest = sumComplexInterest + sumComplexInterest * 0.027;
        }

        System.out.printf("Simple interest rate: %.2f lv.%n", sumSimpleInterest);
        System.out.printf("Complex interest rate: %.2f lv.%n", sumComplexInterest);

        if (sumComplexInterest > sumSimpleInterest) {
            System.out.printf("Choose a complex interest rate. You will win %.2f lv.", Math.abs(sumComplexInterest - sumSimpleInterest));
        } else {
            System.out.printf("Choose a simple interest rate. You will win %.2f lv.",Math.abs(sumComplexInterest - sumSimpleInterest));
        }
    }
}
