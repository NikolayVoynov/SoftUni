import java.util.Scanner;

public class E02VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.print(countOfVowels(input));
    }


    private static int countOfVowels (String input){
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            String currentLetter = String.valueOf(input.charAt(i));

            if (currentLetter.equals("a") ||
                    currentLetter.equals("A") ||
                    currentLetter.equals("e") ||
                    currentLetter.equals("E") ||
                    currentLetter.equals("i") ||
                    currentLetter.equals("I") ||
                    currentLetter.equals("o") ||
                    currentLetter.equals("O") ||
                    currentLetter.equals("u") ||
                    currentLetter.equals("U")) {
                counter++;
            }
        }
        return counter;
    }
}
