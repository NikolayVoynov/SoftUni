import java.util.Scanner;

public class ME01DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dataType = scanner.nextLine();

        switch (dataType) {
            case "int":
                int number1 = Integer.parseInt(scanner.nextLine());
                returnOnConsole(number1);
                break;
            case "real":
                double number2 = Double.parseDouble(scanner.nextLine());
                returnOnConsole(number2);
                break;
            case "string":

                String word = scanner.nextLine();
                returnOnConsole(word);
                break;
        }

    }

    public static void returnOnConsole(int number) {
        System.out.println(number * 2);
    }

    public static void returnOnConsole(double number) {
        System.out.printf("%.2f%n", number * 1.5);
    }

    public static void returnOnConsole(String input) {
        System.out.printf("$%s$%n", input);
    }


}
