import java.util.Scanner;

public class EasterShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//•	На първи ред - Началното количество яйца в магазина - цяло число в интервала [1… 10000]
//•	След това поредица от два реда (до получаване на команда "Close" или при заявка за купуване на повече от
// наличните в магазина яйца) :
//        o	Команда за купуване или допълване на яйца в магазина – текст ("Buy" или "Fill")
//        o	Брой на яйца, които да бъдат купени или допълнени в магазина – цяло число в интервала [1… 1000]

        int eggsCount = Integer.parseInt(scanner.nextLine());
        int eggsSold = 0;

        String command = scanner.nextLine();

        boolean notEnoughEggs = false;

        while (!command.equals("Close")) {
            int eggsCurrent = Integer.parseInt(scanner.nextLine());

            if (command.equals("Buy")) {
                if (eggsCurrent > eggsCount) {
                    notEnoughEggs = true;
                    break;
                } else {
                    eggsCount -= eggsCurrent;
                    eggsSold += eggsCurrent;
                }
            } else if (command.equals("Fill")) {
                eggsCount += eggsCurrent;
            }

            command = scanner.nextLine();
        }

        if (notEnoughEggs) {
            System.out.printf("Not enough eggs in store!%n");
            System.out.printf("You can buy only %d.", eggsCount);
        } else {
            System.out.printf("Store is closed!%n");
            System.out.printf("%d eggs sold.", eggsSold);
        }
    }
}
