import java.sql.Array;
import java.util.Random;
import java.util.Scanner;

public class E01AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] phrase = {"Excellent product.", "Such a great product."
                , "I always use that product.", "Best product of its category."
                , "Exceptional product.", "I can’t live without this product."};
        String[] event = {"Now I feel good.", "I have succeeded with this product."
                , "Makes miracles. I am happy of the results!"
                , "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied."
                , "I feel great!"};
        String[] author = {"Diana", "Petya", "Stella", "Elena"
                , "Katya", "Iva", "Annie", "Eva"};
        String[] city = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        int n = Integer.parseInt(scanner.nextLine());

        Random rnd = new Random();

        for (int i = 0; i < n; i++) {
            int phrase2 = rnd.nextInt(phrase.length);
            int event2 = rnd.nextInt(phrase.length);
            int author2 = rnd.nextInt(phrase.length);
            int city2 = rnd.nextInt(phrase.length);

            String phraseRnd = phrase[phrase2];
            String eventRnd = phrase[event2];
            String authorRnd = phrase[author2];
            String cityRnd = phrase[city2];


            System.out.printf("%s %s %s - %s%n", phraseRnd, eventRnd, authorRnd, cityRnd);

        }


    }
}
