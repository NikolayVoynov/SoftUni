
public class T14_ContainAllAlphabet {


    static boolean containAllAlphabet(String str) {

        long result = str.toLowerCase().chars()
                .filter(c -> c >= 'a' && c <= 'z')
                .distinct()
                .count();

        return result == 26;
    }

    public static void main(String[] args) {
        String[] strArr = {"qwertyuioplkjhgfdsazxcvbnm", "dhbcsdcuscjkcjds", "qwertyuioplkjhgfdsazxcvbnmvdshvgbvdv"};

        for (String s : strArr) {
            if (containAllAlphabet(s)) {
                System.out.printf("%s contains all alphabet!%n", s);
            } else {
                System.out.printf("%s does NOT contain all alphabet!%n", s);
            }
        }
    }
}
