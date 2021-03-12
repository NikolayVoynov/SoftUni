package P03StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();

        String line = scanner.nextLine();
        while (!line.equals("Exit")) {
            String[] input = line.split("\\s+");

            String result = studentSystem.parseCommand(input);

            if (result != null) {
                System.out.println(result);
            }

            line = scanner.nextLine();
        }
    }
}
