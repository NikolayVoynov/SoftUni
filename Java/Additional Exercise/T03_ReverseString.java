import java.util.Scanner;

public class T03_ReverseString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        // Reverse with StringBuffer

        StringBuffer sbr = new StringBuffer(str);
        sbr.reverse();
        System.out.println(sbr);

        // Reverse with for cycle

//        String[] strArr = scanner.nextLine().split("");
//
//
//        for (int i = strArr.length - 1; i >= 0; i--) {
//            System.out.print(strArr[i]);
//        }
    }
}
