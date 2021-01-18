import java.util.Scanner;

public class Substitute {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k11 = Integer.parseInt(scanner.nextLine());
        int l21 = Integer.parseInt(scanner.nextLine());
        int m12 = Integer.parseInt(scanner.nextLine());
        int n22 = Integer.parseInt(scanner.nextLine());

        int ff = 0;
        int sf = 0;
        int fs = 0;
        int ss = 0;

        int counter = 0;


        for (int i = k11; i <= 8; i++) {
            if (i % 2 == 0) {
                ff = i;
            } else {
                continue;
            }
            for (int j = l21; j <= 9; j++) {
                if (j % 2 != 0) {
                    sf = j;
                } else {
                    continue;
                }
                for (int t = m12; t <= 8; t++) {
                    if (t % 2 == 0) {
                        fs = t;
                    } else {
                        continue;
                    }
                    for (int p = n22; p <= 9; p++) {
                        if (p % 2 != 0) {
                            ss = p;
                        } else {
                            continue;
                        }

                        if ((ff != fs) && (sf != ss)) {
                            System.out.printf("%d%d - %d%d%n", ff, fs, sf, ss);
                        } else {
                            System.out.println("Cannot change the same player.%n");
                        }

                        counter++;

                        if (counter == 6) {
                            break;
                        }
                    }
                }
            }
        }
    }
}
