import java.util.Scanner;

public class RepeatingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] occurrenceArr = new int[11];

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(scanner.nextLine());

            occurrenceArr[input]++;
        }

        int maxOccur = 0;
        int maxOccurIndex = Integer.MAX_VALUE;

        for (int i = 1; i < occurrenceArr.length; i++) {
            if(occurrenceArr[i] > maxOccur) {
                maxOccur = occurrenceArr[i];
                maxOccurIndex = i;
            } else if(occurrenceArr[i] == maxOccur){
                maxOccurIndex = Math.min(maxOccurIndex, i);
            }
        }

        System.out.println(maxOccurIndex);
    }
}
