import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class E02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> consumer = name -> System.out.println("Sir " + name);

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(consumer);
    }
}
