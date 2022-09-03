package Algorithmic;

public class FindNumberWithBST {

    public static void main(String[] args) {

        int left = 1;
        int right = 10000;
        int num = 6381;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (middle == num) {
                System.out.println("Number found!");
                return;
            } else if (middle > num) {
                right = middle - 1;
                System.out.println("Try again!");
            } else {
                left = middle + 1;
                System.out.println("Try again!");
            }

        }

    }
}
