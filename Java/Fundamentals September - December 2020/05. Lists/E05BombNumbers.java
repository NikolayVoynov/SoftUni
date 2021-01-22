import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E05BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> bombInfo = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int specialNumber = bombInfo.get(0);
        int specialPower = bombInfo.get(1);

        while (listNumbers.contains(specialNumber)) {
            int bombPosition = listNumbers.indexOf(specialNumber);

            int leftBorder = Math.max(0, bombPosition - specialPower);
            int rightBorder = Math.min(listNumbers.size() - 1, bombPosition + specialPower);

            for (int i = rightBorder; i >= leftBorder; i--) {
                listNumbers.remove(i);
            }
        }

        int sum = 0;
        for (Integer listNumber : listNumbers) {
            sum += listNumber;
        }

        System.out.println(sum);

    }
}
