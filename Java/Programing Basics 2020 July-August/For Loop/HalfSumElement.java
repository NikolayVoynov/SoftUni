package com.company;

import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n =Integer.parseInt(scanner.nextLine());

        int sum = 0;
        int numberMax = Integer.MIN_VALUE;
        int sumWithoutMax = 0;

        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            sum += number;

            if (number > numberMax) {
                numberMax = number;
            }
        }

        sumWithoutMax = sum - numberMax;

        if (numberMax == sumWithoutMax) {
            System.out.println("Yes");
            System.out.printf("Sum = %d", numberMax);
        } else {
            System.out.println("No");
            System.out.printf("Diff = %d", Math.abs(sumWithoutMax - numberMax));
        }
    }
}
