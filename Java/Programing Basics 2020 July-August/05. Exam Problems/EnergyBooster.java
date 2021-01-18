import java.util.Scanner;

public class EnergyBooster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String size = scanner.nextLine();
        int setCount = Integer.parseInt(scanner.nextLine());

        double prize = 0;
        double prizeFinal = 0;

//                       Диня          Манго          Ананас         Малина
//        2 броя (small) 56 лв./бр.    36.66 лв./бр.  42.10 лв./бр.  20 лв./бр.
//        5 броя (big)   28.70 лв./бр. 19.60 лв./бр.  24.80 лв./бр.  15.20 лв./бр.


        switch (fruit) {
            case "Watermelon":
                if (size.equals("small")) {
                    prize = setCount * 2 * 56;
                } else if (size.equals("big")) {
                    prize = setCount * 5 * 28.7;
                }
                break;
            case "Mango":
                if (size.equals("small")) {
                    prize = setCount * 2 * 36.66;
                } else if (size.equals("big")) {
                    prize = setCount * 5 * 19.6;
                }
                break;
            case "Pineapple":
                if (size.equals("small")) {
                    prize = setCount * 2 * 42.1;
                } else if (size.equals("big")) {
                    prize = setCount * 5 * 24.8;
                }
                break;
            case "Raspberry":
                if (size.equals("small")) {
                    prize = setCount * 2 * 20;
                } else if (size.equals("big")) {
                    prize = setCount * 5 * 15.2;
                }
                break;
        }

        if (prize > 1000) {
            prizeFinal = prize * 0.5;
            System.out.printf("%.2f lv.", prizeFinal);
        } else if (prize >= 400) {
            prizeFinal = prize * 0.85;
            System.out.printf("%.2f lv.", prizeFinal);
        } else {
            System.out.printf("%.2f lv.", prize);
        }
    }
}
