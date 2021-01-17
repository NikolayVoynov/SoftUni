import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int jury = Integer.parseInt(scanner.nextLine());


        double sumAllRatings = 0;
        int counterPresentations = 0;

        String input = scanner.nextLine();

        while (!input.equals("Finish")) {
            double sumCurrentRatings = 0;
            counterPresentations++;

            for (int i = 0; i < jury; i++) {
                double rating = Double.parseDouble(scanner.nextLine());
                sumCurrentRatings += rating;
            }

            double averageRating = sumCurrentRatings / jury;
            System.out.printf("%s - %.2f.%n", input, averageRating);

            sumAllRatings += averageRating;

            input = scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", sumAllRatings / counterPresentations);
    }
}
