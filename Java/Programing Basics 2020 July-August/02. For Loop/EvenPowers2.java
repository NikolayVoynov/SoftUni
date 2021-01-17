package com.company;

import java.util.Scanner;

public class EvenPowers2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n = Double.parseDouble(scanner.nextLine());

        for (double i = 0; i <= n; i += 2) {
            System.out.printf("%.0f%n", Math.pow(2,i));
        }


    }
}
