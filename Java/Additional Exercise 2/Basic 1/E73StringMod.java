package Basic1;

import java.util.Scanner;

public class E73StringMod {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input str1: ");
        String str1 = scanner.nextLine();
        System.out.print("Input str2: ");
        String str2 = scanner.nextLine();

        String result = "";

        result += (str1.length() >= 1) ? str1.substring(0,1) : "#";
        result += (str2.length() >= 1) ? str2.substring(str2.length() -1) : "#";

        System.out.println(result);
    }
}
