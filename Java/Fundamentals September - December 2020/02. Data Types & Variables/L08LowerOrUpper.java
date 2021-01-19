import java.util.Scanner;

public class L08LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char ch = scanner.nextLine().charAt(0);

        if (65 <= (int) ch && (int) ch <= 90) {
            System.out.println("upper-case");
        }

        if (97 <= (int) ch && (int) ch <= 122) {
            System.out.println("lower-case");
        }


    }
}
