import java.util.*;
import java.util.stream.Collectors;

public class P01DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(e -> malesStack.push(e));

        ArrayDeque<Integer> femalesQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));


        int matches = 0;

        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {

            int male = malesStack.peek();
            int female = femalesQueue.peek();

            if (male <= 0) {
                while (male <= 0) {
                    malesStack.pop();
                    if (!malesStack.isEmpty()) {
                        male = malesStack.peek();
                    }
                }
            }

            if (female <= 0) {
                while (female <= 0) {
                    femalesQueue.poll();
                    if (!femalesQueue.isEmpty()) {
                        female = femalesQueue.peek();
                    }
                }

            }

            if (male % 25 == 0 || female % 25 == 0) {
                if (male % 25 == 0) {
                    malesStack.pop();
                    malesStack.pop();
                }

                if (female % 25 == 0) {
                    femalesQueue.poll();
                    femalesQueue.poll();
                }
            } else if (male == female) {
                matches++;
                malesStack.pop();
                femalesQueue.pop();
            } else {
                femalesQueue.poll();
                male -= 2;
                malesStack.pop();
                malesStack.push(male);
            }
        }

        System.out.println("Matches: " + matches);

        if (malesStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.println("Males left: " + malesStack.toString().replaceAll("[\\[\\]]", ""));
        }

        if (femalesQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.println("Females left: " + femalesQueue.toString().replaceAll("[\\[\\]]", ""));

        }

    }
}
