import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E02ChangeList2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listNumbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");

            String action = tokens[0];
            int element = Integer.parseInt(tokens[1]);

            switch (action) {
                case "Delete":

                    for (int i = 0; i < listNumbers.size(); i++) {
                        int currentElement = listNumbers.get(i);
                        if (element == currentElement) {
                            listNumbers.remove(i);
                            i -= 1;
                        }
                    }

                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    listNumbers.add(index, element);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.print(listNumbers.toString().replaceAll("[\\[\\]\\,]", ""));
    }
}
