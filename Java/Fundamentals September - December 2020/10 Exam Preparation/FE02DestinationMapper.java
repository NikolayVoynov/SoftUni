import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FE02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regexPlace = "([=/])([A-Z][A-Za-z]{2,})\\1";
        Pattern patternPlace = Pattern.compile(regexPlace);

        Matcher matcherPlace = patternPlace.matcher(input);

        List<String> places = new ArrayList<>();

        while (matcherPlace.find()) {

            places.add(matcherPlace.group(2));
        }

        String allPlaces = String.join(", ", places);
        System.out.println("Destinations: " + allPlaces);
        System.out.println("Travel Points: " + places.stream().mapToInt(l -> l.length()).sum());
    }
}
