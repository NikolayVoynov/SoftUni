import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E01_SuperSet {

    public static List<List<Integer>> answerArr = new ArrayList<>();
    public static List<Integer> tempArr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputArr = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());

        getSuperSets(0, tempArr, answerArr, inputArr);

        for (List<Integer> superSet : answerArr) {
            for (Integer elem : superSet) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }

    }

    private static void getSuperSets(int i, List<Integer> tempArr, List<List<Integer>> answerArr, List<Integer> inputArr) {

        if (i == inputArr.size()) {
            if (tempArr.size() > 0) {
                answerArr.add(tempArr);
            }

            return;
        }

        List<Integer> tempArr1 = new ArrayList<>(tempArr);
        tempArr1.add(inputArr.get(i));

        getSuperSets(i + 1, tempArr1, answerArr, inputArr);

        getSuperSets(i + 1, tempArr, answerArr, inputArr);
    }
}
