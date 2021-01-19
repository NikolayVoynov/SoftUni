import java.util.Scanner;

public class E05Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();

        String password = "";

        for (int i = username.length() - 1; i >= 0; i--) {
            password += username.charAt(i);
        }

        int counter = 0;

        while (counter < 4) {

            String input = scanner.nextLine();

            if (input.equals(password)) {
                System.out.printf("User %s logged in.%n", username);
                return;
            } else if (counter < 3){
                System.out.println("Incorrect password. Try again.");

            }

            counter++;
        }

        if (counter == 4) {
            System.out.printf("User %s blocked!", username);
        }


    }
}
