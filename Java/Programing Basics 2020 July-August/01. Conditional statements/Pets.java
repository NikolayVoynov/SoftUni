import java.util.Scanner;

public class Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int food = Integer.parseInt(scanner.nextLine());
        double foodDogDay = Double.parseDouble(scanner.nextLine());
        double foodCatDay = Double.parseDouble(scanner.nextLine());
        double foodTortoiseDay = Double.parseDouble(scanner.nextLine());

        double foodNeeded = days * (foodDogDay + foodCatDay + foodTortoiseDay * 0.001);

        if (food >= foodNeeded) {
            double foodExtra = Math.floor(food - foodNeeded);
            System.out.printf("%.0f kilos of food left.", foodExtra);
        } else {
            double foodDeficient = Math.ceil(foodNeeded - food);
            System.out.printf("%.0f more kilos of food are needed.", foodDeficient);
        }
    }
}
