import java.util.Scanner;

public class MER02ArcheryTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lineTargets = scanner.nextLine().split("\\|");
        int[] numbersTargets = new int[lineTargets.length];

        for (int i = 0; i < lineTargets.length; i++) {
            numbersTargets[i] = Integer.parseInt(lineTargets[i]);
        }

        int sumPoints = 0;

        String lineCommand = scanner.nextLine();

        while (!lineCommand.equals("Game over")) {
            String[] arrayCommand = lineCommand.split("@");
            String command = arrayCommand[0];

            switch (command) {
                case "Shoot Left":
                    int startIndexLeft = Integer.parseInt(arrayCommand[1]);
                    int leftLength = Integer.parseInt(arrayCommand[2]);

                    if (startIndexLeft >= 0 && startIndexLeft < numbersTargets.length) {
                        int targetIndexLeft = startIndexLeft - leftLength;

                        while (targetIndexLeft < 0) {
                            targetIndexLeft = numbersTargets.length + targetIndexLeft;
                        }
                        if (numbersTargets[targetIndexLeft] >= 5) {
                            numbersTargets[targetIndexLeft] -= 5;
                            sumPoints += 5;
                        } else {
                            sumPoints += numbersTargets[targetIndexLeft];
                            numbersTargets[targetIndexLeft] = 0;
                        }

                    }
                    break;
                case "Shoot Right":
                    int startIndexRight = Integer.parseInt(arrayCommand[1]);
                    int rightLength = Integer.parseInt(arrayCommand[2]);

                    if (startIndexRight >= 0 && startIndexRight < numbersTargets.length) {
                        int targetIndexRight = startIndexRight + rightLength;

                        while (targetIndexRight >= numbersTargets.length) {
                            targetIndexRight = targetIndexRight - numbersTargets.length;
                        }

                        if (numbersTargets[targetIndexRight] >= 5) {
                            numbersTargets[targetIndexRight] -= 5;
                            sumPoints += 5;
                        } else {
                            sumPoints += numbersTargets[targetIndexRight];
                            numbersTargets[targetIndexRight] = 0;
                        }
                    }
                    break;
                case "Reverse":
                    for (int i = 0; i < numbersTargets.length / 2; i++) {
                        int currentNumber = numbersTargets[i];
                        numbersTargets[i] = numbersTargets[numbersTargets.length - 1 - i];
                        numbersTargets[numbersTargets.length - 1 - i] = currentNumber;
                    }
                    break;
            }

            lineCommand = scanner.nextLine();
        }

        for (int i = 0; i < numbersTargets.length - 1; i++) {
            System.out.print(numbersTargets[i] + " - ");
        }

        System.out.println(numbersTargets[numbersTargets.length - 1]);
        System.out.printf("Iskren finished the archery tournament with %d points!", sumPoints);
    }
}

