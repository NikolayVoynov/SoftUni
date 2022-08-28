package Basic1;

public class E39UniqueThreeDigitNumber {
    public static void main(String[] args) {
        int total = 0;

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                for (int k = 1; k <= 4; k++) {
                    if (i != k && i != j && j != k) {
                        total++;
                        System.out.printf("%d%d%d\n", i, j, k);
                    }
                }
            }
        }

        System.out.println("Total numbers: " + total);
    }
}
