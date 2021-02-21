import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> phoneBook = new HashMap<>();

        while (!input.equals("search")) {
            String[] personInfo = input.split("\\-");
            String name = personInfo[0];
            String phoneNumber = personInfo[1];

            phoneBook.putIfAbsent(name, phoneNumber);
            phoneBook.put(name, phoneNumber);

            input = scanner.nextLine();
        }

        String searchFor = scanner.nextLine();

        while (!searchFor.equals("stop")) {

            if (phoneBook.containsKey(searchFor)) {
                System.out.println(String.format("%s -> %s", searchFor, phoneBook.get(searchFor)));
            } else {
                System.out.println("Contact " + searchFor + " does not exist.");
            }

            searchFor = scanner.nextLine();
        }
    }
}
