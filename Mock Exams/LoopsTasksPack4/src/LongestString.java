import java.util.Scanner;

public class LongestString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String food = scanner.nextLine();
        String longestFood = "";

        while (!food.equals("END")) {

            if(food.length() >= longestFood.length()){
                longestFood = food;
            }

            food = scanner.nextLine();
        }

        System.out.printf(longestFood);
    }
}
