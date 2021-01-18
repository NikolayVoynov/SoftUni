import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberGroups = Integer.parseInt(scanner.nextLine());

        int counter = 0;

        int totalGroup = 0;

        int groupMusala = 0;
        int groupMonblan = 0;
        int groupKili = 0;
        int groupK2 = 0;
        int groupEverest = 0;

        while (counter < numberGroups) {
            int currentGroup = Integer.parseInt(scanner.nextLine());
            totalGroup += currentGroup;

            if (currentGroup < 6) {
                groupMusala += currentGroup;

            } else if (currentGroup < 13) {
                groupMonblan += currentGroup;

            } else if (currentGroup < 26) {
                groupKili += currentGroup;

            } else if (currentGroup < 41) {
                groupK2 += currentGroup;

            } else {
                groupEverest += currentGroup;

            }
            counter++;
        }

        double percentageMusala = groupMusala * 100.0 / totalGroup;
        double percentageMonblan = groupMonblan * 100.0 / totalGroup;
        double percentageKili = groupKili * 100.0 / totalGroup;
        double percentageK2 = groupK2 * 100.0 / totalGroup;
        double percentageEverest = groupEverest * 100.0 / totalGroup;

        System.out.printf("%.2f%%%n", percentageMusala);
        System.out.printf("%.2f%%%n", percentageMonblan);
        System.out.printf("%.2f%%%n", percentageKili);
        System.out.printf("%.2f%%%n", percentageK2);
        System.out.printf("%.2f%%%n", percentageEverest);

    }
}
