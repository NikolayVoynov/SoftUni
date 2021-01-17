import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String output = "";
        boolean magicNum = false;

        for (int i = 1111; i <= 9999; i++) {
            String currentNum = "" + i;

            for (int j = 0; j < currentNum.length(); j++) {
                int currentDigit = Integer.parseInt("" + currentNum.charAt(j));

                if (currentDigit != 0) {
                    if (n % currentDigit == 0) {
                        output = String.format("%s", currentNum);
                        magicNum = true;
                    } else {
                        magicNum = false;
                        output = "";
                        break;
                    }
                } else {
                    magicNum = false;
                    break;
                }
            }
            if (magicNum) {
                System.out.printf("%s ", output);
            }
        }
    }
}
