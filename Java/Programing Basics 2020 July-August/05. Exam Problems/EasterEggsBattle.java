import java.util.Scanner;

public class EasterEggsBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int eggsFirst = Integer.parseInt(scanner.nextLine());
        int eggsSecond = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("End of battle")) {

            if (input.equals("one")) {
                eggsSecond -= 1;
            } else if (input.equals("two")) {
                eggsFirst -= 1;
            }

            if (eggsFirst == 0) {
                System.out.printf("Player one is out of eggs. Player two has %d eggs left.", eggsSecond);
                break;
            } else if (eggsSecond == 0) {
                System.out.printf("Player two is out of eggs. Player one has %d eggs left.", eggsFirst);
                break;
            }

            input = scanner.nextLine();
        }

        if (input.equals("End of battle")) {
            System.out.printf("Player one has %d eggs left.%n", eggsFirst);
            System.out.printf("Player two has %d eggs left.", eggsSecond);
        }

    }
}
