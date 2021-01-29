import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E01Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>\\d+\\.?\\d*)!(?<quantity>\\d+)";
        Pattern patternFurn = Pattern.compile(regex);

        List<String> listFurniture = new ArrayList<>();

        double totalPrice = 0;

        String input = scanner.nextLine();

        while (!input.equals("Purchase")) {

            Matcher matcherFurn = patternFurn.matcher(input);

            while (matcherFurn.find()) {
                String furniture = matcherFurn.group("furniture");
                double price = Double.parseDouble(matcherFurn.group("price"));
                int quantity = Integer.parseInt(matcherFurn.group("quantity"));

                totalPrice += price * quantity;

                listFurniture.add(furniture);
            }

            input = scanner.nextLine();
        }

        System.out.println("Bought furniture:");

        listFurniture.forEach(f-> System.out.println(f));

        System.out.printf("Total money spend: %.2f", totalPrice);

    }
}
