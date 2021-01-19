import java.util.Scanner;

public class E09PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double amountMoney = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double lightsaberPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        int lightsaberExtra = (int) Math.ceil(students * 0.1);
        int lightsaberNumber = students + lightsaberExtra;
        int beltsFree = students / 6;

        double moneyLightsabers = lightsaberNumber * lightsaberPrice;
        double moneyRobes = students * robePrice;
        double moneyBelts = students * beltPrice - beltsFree * beltPrice;
        double calculatedMoney = moneyLightsabers + moneyRobes + moneyBelts;

        if (calculatedMoney <= amountMoney) {
            System.out.printf("The money is enough - it would cost %.2flv.", calculatedMoney);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", Math.abs(amountMoney - calculatedMoney));
        }
    }
}
