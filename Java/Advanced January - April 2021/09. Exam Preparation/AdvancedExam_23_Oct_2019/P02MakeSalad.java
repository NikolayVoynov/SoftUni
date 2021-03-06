import java.util.*;
import java.util.stream.Collectors;

public class P02MakeSalad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> vegetablesQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> saladsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .forEach(saladsStack::push);

        Map<String, Integer> vegetablesCalories = new HashMap<>();
        vegetablesCalories.put("tomato", 80);
        vegetablesCalories.put("carrot", 136);
        vegetablesCalories.put("lettuce", 109);
        vegetablesCalories.put("potato", 215);

        List<Integer> finishedSalads = new ArrayList<>();

        while (!vegetablesQueue.isEmpty() && !saladsStack.isEmpty()) {
            int salad = saladsStack.peek();

            while (salad > 0) {
                String vegetable = null;
                if (!vegetablesQueue.isEmpty()) {
                    vegetable = vegetablesQueue.poll();
                } else {
                    break;
                }

                int vegCal = vegetablesCalories.get(vegetable);
                salad -= vegCal;
            }

            finishedSalads.add(saladsStack.pop());
        }

        System.out.println(String.join(" ", finishedSalads.toString().replaceAll("[\\[\\],]", "")));

        if (vegetablesQueue.isEmpty()) {
            StringBuilder printLeftSalads = new StringBuilder();
            for (Integer salad : saladsStack) {
                printLeftSalads.append(salad)
                        .append(" ");
            }

            System.out.println(printLeftSalads.toString().trim());
        }

        if (saladsStack.isEmpty()) {
            StringBuilder printLeftVegetables = new StringBuilder();
            for (String vegetable : vegetablesQueue) {
                printLeftVegetables.append(vegetable)
                        .append(" ");
            }

            System.out.println(printLeftVegetables.toString().trim());
        }
    }
}
