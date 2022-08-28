package Basic1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class E37ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input string: ");
        Object[] input = Arrays.stream(scanner.nextLine().split("")).toArray();

        Stack<Object> reversedStr = new Stack<>();

        for (Object s : input) {
            reversedStr.push(s);
        }

        while (!reversedStr.isEmpty()) {
            System.out.print(reversedStr.pop());
        }
    }
}
