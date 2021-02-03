import java.util.Scanner;

public class FE01ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String activationKey = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Generate")) {
            String[] tokens = input.split(">>>");
            String command = tokens[0];

            switch (command) {
                case "Contains":
                    String substring = tokens[1];
                    if (activationKey.contains(substring)) {
                        System.out.println(activationKey + " contains " + substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String caseLetters = tokens[1];
                    int startIndexF = Integer.parseInt(tokens[2]);
                    int endIndexF = Integer.parseInt(tokens[3]);

                    switch (caseLetters) {
                        case "Upper":
                            String firstU = activationKey.substring(0, startIndexF);
                            String secondU = activationKey.substring(startIndexF, endIndexF);
                            String thirdU = activationKey.substring(endIndexF);
                            activationKey = firstU + secondU.toUpperCase() + thirdU;
                            System.out.println(activationKey);

                            break;
                        case "Lower":
                            String firstL = activationKey.substring(0, startIndexF);
                            String secondL = activationKey.substring(startIndexF, endIndexF);
                            String thirdL = activationKey.substring(endIndexF);
                            activationKey = firstL + secondL.toLowerCase() + thirdL;
                            System.out.println(activationKey);

                            break;
                    }

                    break;
                case "Slice":
                    int startIndexS = Integer.parseInt(tokens[1]);
                    int endIndexS = Integer.parseInt(tokens[2]);
                    String first = activationKey.substring(0, startIndexS);
                    String second = activationKey.substring(endIndexS);
                    activationKey = first + second;
                    System.out.println(activationKey);
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println("Your activation key is: " + activationKey);


    }
}
