import java.util.List;
import java.util.Scanner;

public class TitleSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine().toLowerCase();
            StringBuilder result = new StringBuilder(title);
            int index = 0;

            for (int j = 0; j < result.length(); j++) {
                if (index < input.length() && input.charAt(index) == result.charAt(j)) {
                    index++;
                    result.deleteCharAt(j);
                    j--;
                }
            }

            if (index == input.length()) {
                System.out.println(result);
                title = result.toString();
            } else {
                System.out.println("No such title found!");
            }
        }
    }
}

