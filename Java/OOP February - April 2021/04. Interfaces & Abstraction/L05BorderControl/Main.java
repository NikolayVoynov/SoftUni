package L05BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> ids = new ArrayList<>();

        String input = "";

        while (!"End".equals(input = scanner.nextLine())) {
            String[] token = input.split("\\s+");
            String entry = token[0];

            if (token.length == 2) {
                Robot robot = new Robot(token[0], token[1]);
                ids.add(robot.getId());
            } else if (token.length == 3) {
                Citizen citizen = new Citizen(token[0], Integer.parseInt(token[1]), token[2]);
                ids.add(citizen.getId());
            }
        }

        String lastDigitsOfFakeIds = scanner.nextLine();


        for (String id : ids) {
            int startIndex = id.length() - lastDigitsOfFakeIds.length();

            if (id.substring(startIndex).equals(lastDigitsOfFakeIds)) {
                System.out.println(id);
            }
        }
    }
}
