import java.util.Scanner;

public class MergingAndSquashing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] numbers = new String[n];

        for (int i = 0; i < n; i++) {
            String num = scanner.nextLine();
            numbers[i] = num;
        }

        String[] merging = new String[n - 1];
        String[] squashing = new String[n - 1];
        int indexMerging = 0;
        int indexSquashing = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            String[] first = numbers[i].split("");
            String[] second = numbers[i + 1].split("");

            String result = first[1] + second[0];
            merging[indexMerging] = result;
            indexMerging++;
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            String[] first = numbers[i].split("");
            String[] second = numbers[i + 1].split("");

            int middleSum = Integer.parseInt(first[1]) + Integer.parseInt(second[0]);
            String middle = String.valueOf(middleSum);
            if (middleSum > 9) {
                middle = String.valueOf(middleSum % 10);
            }
            String result = first[0] + middle + second[1];
            squashing[indexSquashing] = result;
            indexSquashing++;
        }

        System.out.println(String.join(" ", merging));
        System.out.println(String.join(" ", squashing));
    }
}
