package com.company;

import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        int sum = 0;

        for (int i = 1; i <= count; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            sum += number;
        }
        System.out.println(sum);
    }
}
