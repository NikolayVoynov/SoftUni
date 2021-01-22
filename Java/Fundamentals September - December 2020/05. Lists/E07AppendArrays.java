
import java.util.*;
import java.util.stream.Collectors;

public class E07AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split("\\|");

        String result = "";

        for (int i = array.length - 1; i >= 0 ; i--) {
            String[] currentArray = array[i].split("\\s+");
            for (int j = 0; j < currentArray.length; j++) {
                if (!currentArray[j].equals("")) {
                    result += currentArray[j] + " ";
                }
            }
        }
        System.out.println(result.trim());
    }
}
