import java.util.Scanner;

public class L03Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String wordToBeRemoved = scanner.nextLine();
        String text = scanner.nextLine();

        int index = text.indexOf(wordToBeRemoved);

        while (index != -1) {
            text =text.replace(wordToBeRemoved, "");
            index = text.indexOf(wordToBeRemoved);
        }

        System.out.println(text);

    }
}
