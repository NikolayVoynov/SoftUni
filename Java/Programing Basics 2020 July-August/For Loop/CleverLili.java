package com.company;

import java.util.Scanner;

public class CleverLili {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int years = Integer.parseInt(scanner.nextLine());
        double priceLaundry = Double.parseDouble(scanner.nextLine());
        int priceToy = Integer.parseInt(scanner.nextLine());

        double presentEven = 0;
        double presentOdd = 0;
        double totalMoney = 0;

        for (int i = 1; i <= years; i++) {
            if (i % 2 == 0) {
                presentEven = 10 + 5 * (i - 2);
            } else {
                presentOdd += priceToy;
            }
        }
        presentEven = presentEven - years / 2.0;
        totalMoney = presentEven + presentOdd;

        if (totalMoney >= priceLaundry) {
            System.out.printf("Yes! %.2f", Math.abs(totalMoney - priceLaundry));
        } else {
            System.out.printf("No! %.2f", Math.abs(totalMoney - priceLaundry));
        }



    }
}
