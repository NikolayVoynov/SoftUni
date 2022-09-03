package Algorithmic;

import java.util.ArrayList;
import java.util.List;

public class IntervalWithMaxSum {

    public static void main(String[] args) {

        int[] origArr = new int[]{1, 2, -5, 6, -1, 4, -2, 3, -40, -2, 3};
        List<Integer> maxInterval = new ArrayList<>();
        List<Integer> currInterval = new ArrayList<>();
        int maxSum = 0;
        int currSum = 0;

        for (int i = 0; i < origArr.length; i++) {
            currSum += origArr[i];
            currInterval.add(origArr[i]);
            if (currSum < 0) {
                currSum = 0;
                currInterval.clear();
            } else {
                if (currSum > maxSum) {
                    maxSum = currSum;
                    maxInterval.clear();
                    maxInterval.addAll(currInterval);
                }
            }
        }

        System.out.println("Max sum: " + maxSum);
        System.out.println(maxInterval);
    }
}
