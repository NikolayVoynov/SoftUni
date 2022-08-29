package Basic1;

public class E92CountEvenOdd {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 4, 37, 7, 27, 88, 11, 5, 2, 16, 13};
        int even = 0;
        int odd = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}
