import java.util.Scanner;

public class E01_AlphaDecay {

    public static String[] nucleus;
    public static String[] variations;
    public static boolean[] used;
    public static int k;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        nucleus = scanner.nextLine().split("\\s+");
        k = Integer.parseInt(scanner.nextLine());

        used = new boolean[nucleus.length];
        variations = new String[k];

        generateVariation(0);
    }

    private static void generateVariation(int index) {
        if (index == variations.length) {
            System.out.println(String.join(" ", variations));
        } else {
            for (int i = 0; i < nucleus.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    variations[index] = nucleus[i];
                    generateVariation(index + 1);
                    used[i] = false;
                }
            }
        }
    }
}
