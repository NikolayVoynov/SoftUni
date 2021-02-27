import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class E01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> consumer = name -> System.out.println(name);

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(consumer);
    }
}
