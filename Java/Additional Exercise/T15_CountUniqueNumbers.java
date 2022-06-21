import java.util.Arrays;
import java.util.HashMap;

public class T15_CountUniqueNumbers {

    public static void main(String[] args) {
        int[] numberArr = {1, 3, 5, 2, 1, 3, 5, 6, 8, 12, 77, 77, 12, 7};

        HashMap<Integer, Integer> mapNum = new HashMap<>();

        for (int num : numberArr) {
            if (mapNum.containsKey(num)) {
                mapNum.put(num, mapNum.get(num) + 1);
            } else {
                mapNum.put(num, 1);
            }
        }

        long unique = 0;

        for (Integer value : mapNum.values()) {
            if (value == 1) {
                unique++;
            }
        }

        System.out.println(unique);
    }
}
