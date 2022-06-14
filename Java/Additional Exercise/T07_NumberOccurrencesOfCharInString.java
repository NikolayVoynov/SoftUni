import java.util.HashMap;
import java.util.Scanner;

public class T07_NumberOccurrencesOfCharInString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert string:");
        String[] str = scanner.nextLine().split("");
        System.out.println("Insert letter:");
        String letter = scanner.nextLine();

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length; i++) {

            if (map.containsKey(str[i])) {
                map.put(str[i], map.get(str[i]) + 1);
            } else {
                map.put(str[i], 1);
            }
        }

        if (map.containsKey(letter)) {
            System.out.println(map.get(letter));
        } else {
            System.out.println("There is no such letter in this string!");
        }
    }
}
