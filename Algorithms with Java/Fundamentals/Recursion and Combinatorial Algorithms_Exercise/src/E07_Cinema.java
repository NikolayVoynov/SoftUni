import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E07_Cinema {
    public static String[] seats;
    public static String[] combinations;
    public static boolean[] used;
    public static List<String> people;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        people = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        seats = new String[people.size()];
        String line = scanner.nextLine();

        while (!line.equals("generate")) {
            String[] tokens = line.split(" - ");

            String name = tokens[0];
            int seat = Integer.parseInt(tokens[1]);

            seats[seat - 1] = name;
            seats[seat - 1] = name;
            people.remove(name);

            line = scanner.nextLine();
        }

        combinations = new String[people.size()];
        used = new boolean[people.size()];

        generatePermutations(0);
    }

    private static void generatePermutations(int index) {
        if (index == combinations.length) {
            print();
        } else {
            for (int i = 0; i < people.size(); i++) {
                if (!used[i]) {
                    used[i] = true;
                    combinations[index] = people.get(i);
                    generatePermutations(index + 1);
                    used[i] = false;
                }
            }
        }
    }

    private static void print() {
        int indexCombinations = 0;
        String[] result = new String[seats.length];
        for (int i = 0; i < result.length; i++) {
            if (seats[i] != null) {
                result[i] = seats[i];
            } else {
                result[i] = combinations[indexCombinations++];
            }
        }
        System.out.println(String.join(" ", result));
    }
}
