package E07CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> list = new CustomList<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] token = input.split("\\s+");
            String command = token[0];

            switch (command) {
                case "Add":
                    String value = token[1];
                    list.add(value);
                    break;
                case "Remove":
                    int index = Integer.parseInt(token[1]);
                    list.remove(index);
                    break;
                case "Contains":
                    String element = token[1];
                    System.out.println(list.contains(element));
                    break;
                case "Swap":
                    int index1 = Integer.parseInt(token[1]);
                    int index2 = Integer.parseInt(token[2]);
                    list.swap(index1, index2);
                    break;
                case "Greater":
                    String compareTo = token[1];
                    System.out.println(list.countGreaterThan(compareTo));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    System.out.println(list);
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
