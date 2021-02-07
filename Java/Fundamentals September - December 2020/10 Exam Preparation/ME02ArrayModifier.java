import java.util.Arrays;
import java.util.Scanner;

public class ME02ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayIntegers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "swap":
                    int index1 = Integer.parseInt(tokens[1]);
                    int index2 = Integer.parseInt(tokens[2]);
                    int first = arrayIntegers[index1];
                    int second = arrayIntegers[index2];
                    arrayIntegers[index1] = second;
                    arrayIntegers[index2] = first;
                    break;
                case "multiply":
                    index1 = Integer.parseInt(tokens[1]);
                    index2 = Integer.parseInt(tokens[2]);
                    int firstMultiplier = arrayIntegers[index1];
                    int secondMultiplier = arrayIntegers[index2];
                    int product = firstMultiplier * secondMultiplier;
                    arrayIntegers[index1] = product;
                    break;
                case "decrease":
                    for (int i = 0; i < arrayIntegers.length; i++) {
                        arrayIntegers[i] = arrayIntegers[i] - 1;
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        for (int i = 0; i < arrayIntegers.length -1 ; i++) {
            System.out.print(arrayIntegers[i] + ", ");
        }
        System.out.println(arrayIntegers[arrayIntegers.length - 1]);
    }
}
