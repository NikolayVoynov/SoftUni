import java.util.Arrays;
import java.util.Scanner;

public class ME02Commands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] collection = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "reverse":
                    int startIndex = Integer.parseInt(tokens[2]);
                    int count = Integer.parseInt(tokens[4]);
                    int endIndex = startIndex + count - 1;

                        int[] section = new int[count];

                        for (int i = 0; i < count; i++) {
                            section[i] = collection[i + startIndex];
                        }

                        for (int i = 0; i < section.length / 2; i++) {
                            int oldElement = section[i];
                            section[i] = section[section.length - 1 - i];
                            section[section.length - 1 - i] = oldElement;
                        }

                        for (int i = 0; i < section.length; i++) {
                            collection[i + startIndex] = section[i];
                        }

                    break;

                case "sort":
                    startIndex = Integer.parseInt(tokens[2]);
                    count = Integer.parseInt(tokens[4]);
                    endIndex = startIndex + count;

                    Arrays.sort(collection, startIndex, endIndex);

                    break;

                case "remove":
                    count = Integer.parseInt(tokens[1]);

                    int[] secondPart = new int[collection.length - count];

                    for (int i = 0; i < secondPart.length; i++) {
                        secondPart[i] = collection[i + count];
                    }

                    collection = new int[secondPart.length];

                    for (int i = 0; i < secondPart.length; i++) {
                        collection[i] = secondPart[i];
                    }

                    break;
            }

            input = scanner.nextLine();
        }

        System.out.print(Arrays.toString(collection).replaceAll("[\\[\\]]", ""));
        
    }
}
