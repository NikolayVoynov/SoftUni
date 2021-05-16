import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ME01Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        List<String> textWords = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {
            String number = numbers.get(i);
            List<Integer> digitsNumber = Arrays.stream(number.split(""))
                    .map(Integer::parseInt).collect(Collectors.toList());

            int index = digitsNumber.stream().mapToInt(Integer::intValue).sum();

            if (textWords.size() <= index) {
                index = index % textWords.size();
                System.out.print(textWords.get(index));
            } else {
                System.out.print(textWords.get(index));

            }
            textWords.remove(index);
        }
    }
}
