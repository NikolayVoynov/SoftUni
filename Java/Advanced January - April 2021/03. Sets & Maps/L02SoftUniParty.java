import java.util.Scanner;
import java.util.TreeSet;

public class L02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> vip = new TreeSet<>();
        TreeSet<String> regular = new TreeSet<>();

        String input = scanner.nextLine();

        while (!input.equals("PARTY")) {

            if (Character.isDigit(input.charAt(0))) {
                vip.add(input);
            } else {
                regular.add(input);
            }

            input = scanner.nextLine();
        }

        while (!input.equals("END")) {

            if (Character.isDigit(input.charAt(0))) {
                vip.remove(input);
            } else {
                regular.remove(input);
            }

            input = scanner.nextLine();
        }

        System.out.println(vip.size() + regular.size());
        vip.forEach(e-> System.out.println(e));
        regular.forEach(e -> System.out.println(e));
    }
}
