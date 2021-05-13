import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ME02EnglishNameOfTheLastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] number = scanner.nextLine().split("");

        System.out.println(theEnglishNameOfTheLastDigitOfGivenNumber(Integer.parseInt(number[number.length - 1])));
    }

    private static String theEnglishNameOfTheLastDigitOfGivenNumber(int lastDigit) {
        Map<Integer, String> mapOfDigits = new HashMap<>();
        mapOfDigits.put(0, "zero");
        mapOfDigits.put(1, "one");
        mapOfDigits.put(2, "two");
        mapOfDigits.put(3, "three");
        mapOfDigits.put(4, "four");
        mapOfDigits.put(5, "five");
        mapOfDigits.put(6, "six");
        mapOfDigits.put(7, "seven");
        mapOfDigits.put(8, "eight");
        mapOfDigits.put(9, "nine");

        return mapOfDigits.get(lastDigit);
    }
}
