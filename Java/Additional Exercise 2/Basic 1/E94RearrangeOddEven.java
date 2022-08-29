package Basic1;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class E94RearrangeOddEven {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 4, 12, 3, 56, 32, 1, 77};
        List<Integer> listEven = new Stack<>();
        List<Integer> listOdd = new Stack<>();

        for (int e : arr) {
            if (e % 2 == 0) {
                listEven.add(e);
            } else {
                listOdd.add(e);
            }
        }

        for (int i = 0; i < listOdd.size(); i++) {
            arr[i] = listOdd.get(i);
        }

        for (int i = 0; i < listEven.size(); i++) {
            arr[listOdd.size() + i] = listEven.get(i);
        }

        System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", ""));
    }
}
