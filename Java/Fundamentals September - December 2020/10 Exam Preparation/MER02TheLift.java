import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MER02TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int waitingPeople = Integer.parseInt(scanner.nextLine());

        int[] lift = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int liftMaxCapacity = 4 * lift.length;
        int currentCapacity = IntStream.of(lift).sum();

        while (waitingPeople > 0 && currentCapacity < liftMaxCapacity) {

            for (int i = 0; i < lift.length; i++) {
                int wagon = lift[i];

                if (wagon < 4) {
                    int neededPeople = 4 - wagon;

                    if (neededPeople <= waitingPeople) {
                        waitingPeople -= neededPeople;
                        currentCapacity += neededPeople;
                        lift[i] = lift[i] + neededPeople;
                    } else {
                        currentCapacity += waitingPeople;
                        lift[i] = lift[i] + waitingPeople;
                        waitingPeople = 0;
                    }
                }
            }
        }

        if (waitingPeople == 0 && currentCapacity < liftMaxCapacity) {
            System.out.println("The lift has empty spots!");
            System.out.print(Arrays.toString(lift).replaceAll("[\\[\\]\\,]", ""));

        } else if (waitingPeople != 0 && currentCapacity == liftMaxCapacity) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", waitingPeople);
            System.out.print(Arrays.toString(lift).replaceAll("[\\[\\]\\,]", ""));

        } else if (waitingPeople == 0 && currentCapacity == liftMaxCapacity) {
            System.out.print(Arrays.toString(lift).replaceAll("[\\[\\]\\,]", ""));

        }
    }
}
