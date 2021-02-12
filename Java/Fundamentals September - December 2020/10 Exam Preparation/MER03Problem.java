import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MER03Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersPaintings = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String instruction = scanner.nextLine();

        while (!instruction.equals("END")) {
            String[] token = instruction.split("\\s+");
            String command = token[0];

            switch (command) {
                case "Change":
                    int paintingNumber = Integer.parseInt(token[1]);
                    int changedNumber = Integer.parseInt(token[2]);
                    if (numbersPaintings.contains(paintingNumber)) {
                        for (int i = 0; i < numbersPaintings.size(); i++) {
                            if (numbersPaintings.get(i) == paintingNumber) {
                                numbersPaintings.set(i, changedNumber);
                            }
                        }
                    }
                    break;

                case "Hide":
                    int paintingNumberHide = Integer.parseInt(token[1]);
                    if (numbersPaintings.contains(paintingNumberHide)) {

                        numbersPaintings.remove(Integer.valueOf(paintingNumberHide));
                    }
                    break;

                case "Switch":
                    int paintingNumberFirst = Integer.parseInt(token[1]);
                    int paintingNumberSecond = Integer.parseInt(token[2]);

                    int firstIndex = 0;
                    int secondIndex = 0;
                    if (numbersPaintings.contains(paintingNumberFirst)
                            && numbersPaintings.contains(paintingNumberSecond)) {
                        for (int i = 0; i < numbersPaintings.size(); i++) {
                            if (numbersPaintings.get(i) == paintingNumberFirst) {
                                firstIndex = i;
                            }

                            if (numbersPaintings.get(i) == paintingNumberSecond) {
                                secondIndex = i;
                            }
                        }

                        numbersPaintings.set(firstIndex, paintingNumberSecond);
                        numbersPaintings.set(secondIndex, paintingNumberFirst);

                    }
                    break;

                case "Insert":
                    int place = Integer.parseInt(token[1]);
                    int paintingNumberInsert = Integer.parseInt(token[2]);
                    int insertPlace = place + 1;

                    if (insertPlace < numbersPaintings.size()) {
                        numbersPaintings.add(insertPlace, paintingNumberInsert);
                    }
                    break;

                case "Reverse":
                    Collections.reverse(numbersPaintings);
                    break;
            }

            instruction = scanner.nextLine();
        }

        System.out.println(numbersPaintings.toString().replaceAll("[\\[\\],]", ""));


    }
}
