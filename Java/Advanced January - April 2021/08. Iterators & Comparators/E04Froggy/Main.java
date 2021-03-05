package E04Froggy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] stones = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Lake lake = new Lake(stones);
        Iterator<Integer> froggy = lake.iterator();

        List<Integer> sequenceStones = new ArrayList<>();

        while (froggy.hasNext()) {
            sequenceStones.add(froggy.next());
        }

        System.out.println(String.join(", ", sequenceStones.toString()).replaceAll("[\\[\\]]", ""));
    }
}
