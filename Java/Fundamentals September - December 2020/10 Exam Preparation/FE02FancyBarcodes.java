import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FE02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regexValidBarcode = "@[#]+([A-Z][A-Za-z0-9]{4,}[A-Z])@[#]+";
        Pattern pattern = Pattern.compile(regexValidBarcode);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String barcode = scanner.nextLine();
            Matcher matcherValidBarcode = pattern.matcher(barcode);

            if (matcherValidBarcode.find()) {
                String validBarcode = matcherValidBarcode.group();
                String regexProductGroup = "\\d+";
                Pattern patternDigit = Pattern.compile(regexProductGroup);
                Matcher matcherProductGroup = patternDigit.matcher(validBarcode);

                boolean noDigits = true;

                StringBuilder productGroup = new StringBuilder();

                while (matcherProductGroup.find()) {
                    noDigits = false;
                    productGroup.append(matcherProductGroup.group());
                }

                if (noDigits) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.println("Product group: " + productGroup.toString());
                }

            } else {
                System.out.println("Invalid barcode");
            }

        }
    }
}
