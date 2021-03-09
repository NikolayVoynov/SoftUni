import java.util.*;
import java.util.stream.Collectors;

public class P01Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> effectsBombsQueue = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> casingBombStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(casingBombStack::push);

        String[] typeBombs = new String[]{"Datura Bombs", "Cherry Bombs", "Smoke Decoy Bombs"};

        Map<Integer, String> menuOfBombs = new HashMap<>();
        menuOfBombs.put(40, "Datura Bombs");
        menuOfBombs.put(60, "Cherry Bombs");
        menuOfBombs.put(120, "Smoke Decoy Bombs");

        Map<String, Integer> countOfBombs = new TreeMap<>();
        countOfBombs.put("Datura Bombs", 0);
        countOfBombs.put("Cherry Bombs", 0);
        countOfBombs.put("Smoke Decoy Bombs", 0);

        boolean bombPouchedIsFilled = false;

        while (!effectsBombsQueue.isEmpty() && !casingBombStack.isEmpty()) {
            int effectsElement = effectsBombsQueue.poll();
            int casingElement = casingBombStack.pop();

            int sumBomb = createBomb(effectsElement, casingElement);
            String bomb = menuOfBombs.get(sumBomb);
            countOfBombs.put(bomb, countOfBombs.get(bomb) + 1);


            if (countOfBombs.get(typeBombs[0]) >= 3 && countOfBombs.get(typeBombs[1]) >= 3
                    && countOfBombs.get(typeBombs[2]) >= 3) {
                bombPouchedIsFilled = true;
                break;
            }
        }


        if (bombPouchedIsFilled) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        System.out.println("Bomb Effects: " + getElementsInfo(effectsBombsQueue));
        System.out.println("Bomb Casings: " + getElementsInfo(casingBombStack));

        countOfBombs.forEach((k,v) -> {
            System.out.println(k +": "+ v);
        });
    }

    private static String getElementsInfo(ArrayDeque<Integer> deque) {
        return deque.isEmpty()
                ? "empty"
                : deque
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }


    private static int createBomb(int effect, int casing) {
        int sumBomb = effect + casing;

        while (sumBomb != 40 && sumBomb != 60 && sumBomb != 120) {
            casing -= 5;
            sumBomb = effect + casing;
        }

        return sumBomb;
    }
}
