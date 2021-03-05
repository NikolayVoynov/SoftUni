package E03StackIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomStack customStack = new CustomStack();

        String[] initialValues = scanner.nextLine()
                .replaceAll("Push ", "").split(",\\s+");

        for (int i = 0; i < initialValues.length; i++) {
            customStack.push(Integer.parseInt(initialValues[i].trim()));
        }

        String inputCommands = "";

        while (!"END".equals(inputCommands = scanner.nextLine())) {
            if (inputCommands.equals("Pop")) {
                try {
                    customStack.pop();

                } catch (IllegalStateException ise) {
                    System.out.println(ise.getMessage());
                }

            } else {
                customStack.push(Integer.parseInt(inputCommands.split("\\s+")[1]));
            }
        }

        for (int i = 0; i < 2; i++) {
            for (Integer element : customStack) {
                System.out.println(element);
            }
        }
    }
}
