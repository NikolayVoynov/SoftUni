package Basic1;

import java.util.Scanner;

public class E60NextToLastWordOfSentence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\s+");

        System.out.print("Penultimate word: " + input[input.length - 2]);
    }
}
