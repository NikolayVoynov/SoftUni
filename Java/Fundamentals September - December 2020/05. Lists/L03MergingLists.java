import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L03MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> mergedList = new ArrayList<>();

        int indexFirst = 0;
        int indexSecond = 0;

        while (indexFirst < firstList.size() || indexSecond < secondList.size()) {
            if (indexFirst < firstList.size()) {
                mergedList.add(firstList.get(indexFirst));
            }

            if (indexSecond < secondList.size()) {
                mergedList.add(secondList.get(indexSecond));
            }

            indexFirst++;
            indexSecond++;
        }
            System.out.println(mergedList.toString().replaceAll("[\\[\\],]", ""));
    }
}
