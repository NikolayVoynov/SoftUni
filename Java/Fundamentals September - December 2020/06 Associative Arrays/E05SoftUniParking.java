import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E05SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> registeredUsers = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] data = input.split("\\s++");
            String command = data[0];
            String username = data[1];

            switch (command) {
                case "register":
                    String licencePlate = data[2];
                    if (registeredUsers.containsKey(username)) {
                        System.out.println("ERROR: already registered with plate number " + licencePlate);

                    } else {
                        registeredUsers.put(username, licencePlate);
                        System.out.println(username + " registered " + licencePlate + " successfully");

                    }
                    break;
                case "unregister":
                    if (!registeredUsers.containsKey(username)) {
                        System.out.printf("ERROR: user %s not found%n", username);

                    } else {
                        registeredUsers.remove(username);
                        System.out.println(username + " unregistered successfully");

                    }
                    break;
            }
        }

        registeredUsers.forEach((k, v) -> System.out.println(k + " => " + v));
    }
}
