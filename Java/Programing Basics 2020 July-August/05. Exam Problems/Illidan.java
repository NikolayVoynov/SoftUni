import java.util.Scanner;

public class Illidan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());
        int blood = Integer.parseInt(scanner.nextLine());

        int totalPower = people * power;

        if (totalPower < blood) {
            System.out.printf("You are not prepared! You need %d more points.", Math.abs(totalPower - blood));
        } else {
            System.out.printf("Illidan has been slain! You defeated him with %d points.", Math.abs(totalPower - blood));
        }
    }
}
