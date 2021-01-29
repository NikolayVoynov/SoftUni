import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class E02Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameRegex = "[A-Za-z]";
        String distanceRegex = "\\d";

        Pattern patternName = Pattern.compile(nameRegex);
        Pattern patternDist = Pattern.compile(distanceRegex);

        List<String> participants = Arrays
                .stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        Map<String, Integer> racersDistance = new LinkedHashMap<>();

        for (String participant : participants) {
            racersDistance.put(participant, 0);
        }

        String info = scanner.nextLine();

        while (!info.equals("end of race")) {

            Matcher matcherName = patternName.matcher(info);
            StringBuilder nameBuilder = new StringBuilder();

            while (matcherName.find()) {
                nameBuilder.append(matcherName.group());
            }

            if (racersDistance.containsKey(nameBuilder.toString())) {
                int currentDist = racersDistance.get(nameBuilder.toString());
                Matcher matcherDist = patternDist.matcher(info);

                while (matcherDist.find()) {
                    currentDist += Integer.parseInt(matcherDist.group());
                }

                racersDistance.put(nameBuilder.toString(), currentDist);
            }

            info = scanner.nextLine();
        }

        List<String> winners = racersDistance.entrySet().stream()
                .sorted((f, s) -> s.getValue() - f.getValue())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());


        int count = 1;

        for (String winner : winners) {
            switch (count++) {
                case 1:
                    System.out.println("1st place: " + winner);
                    break;
                case 2:
                    System.out.println("2nd place: " + winner);
                    break;
                case 3:
                    System.out.println("3rd place: " + winner);
                    break;
            }
        }

    }
}
