import java.util.Scanner;

public class CatWalking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int walkMin = Integer.parseInt(scanner.nextLine());
        int walkNum = Integer.parseInt(scanner.nextLine());
        int consumedCalories = Integer.parseInt(scanner.nextLine());

        double burnedCalories = walkMin * walkNum * 5.0;
        double requiredCalories = consumedCalories * 0.5;

        if (burnedCalories >= requiredCalories) {
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %.0f.", burnedCalories);
        } else {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %.0f.", burnedCalories);
        }
    }
}
