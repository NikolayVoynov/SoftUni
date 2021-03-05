package E02Collection;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> collection = Arrays.stream(scanner.nextLine().split("\\s+"))
                .skip(1).collect(Collectors.toList());

        ListyIterator listyIterator = new ListyIterator(collection);

        String input = "";

        while (!"END".equals(input = scanner.nextLine())) {
            String[] token = input.split("\\s+");
            String command = token[0];

            switch (command) {
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.iterator().hasNext());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "PrintAll":
                    try{
                        listyIterator.printAll();
                        System.out.println();
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                }
                    break;
            }
        }
    }
}
