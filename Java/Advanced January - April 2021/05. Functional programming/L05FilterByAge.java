import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class L05FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> personInfo = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputPeople = scanner.nextLine().split(",\\s+");
            personInfo.put(inputPeople[0], Integer.parseInt(inputPeople[1]));
        }


        String[] commands = new String[3];

        for (int i = 0; i < 3; i++) {
            commands[i] = scanner.nextLine();
        }

        String condition = commands[0];
        Integer age = Integer.parseInt(commands[1]);
        String format = commands[2];

        Predicate<Integer> tester = testFor(condition, age);
        Consumer<Map.Entry<String, Integer>> printer = creatPrinter(format);

        printFilteredStudents(personInfo, tester, printer);


    }

    private static void printFilteredStudents(Map<String, Integer> personInfo, Predicate<Integer> tester, Consumer<Map.Entry<String, Integer>> printer) {
        for (Map.Entry<String, Integer> entry : personInfo.entrySet()) {
            if (tester.test(personInfo.get(entry.getKey()))) {
                printer.accept(entry);
            }
        }
    }

    private static Predicate<Integer> testFor(String condition, Integer age) {
        Predicate<Integer> tester = null;
        switch (condition) {
            case "younger":
                tester = x -> x <= age;
                break;
            case "older":
                tester = x -> x >= age;
                break;
        }
        return tester;
    }

    private static Consumer<Map.Entry<String, Integer>> creatPrinter(String format) {
        Consumer<Map.Entry<String, Integer>> printer = null;
        switch (format) {
            case "name":
                printer = personInfo -> System.out.println(String.format("%s", personInfo.getKey()));
                break;
            case "age":
                printer = personInfo -> System.out.println(String.format("%d", personInfo.getValue()));
                break;
            case "name age":
                printer = personInfo -> System.out.println(String.format("%s - %d", personInfo.getKey(), personInfo.getValue()));
                break;
        }
        return printer;
    }
}
