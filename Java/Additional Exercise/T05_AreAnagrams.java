import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class T05_AreAnagrams {

    static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        } else {
            HashMap<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < str1.length(); i++) {
                if (map.containsKey(str1.charAt(i))) {
                    map.put(str1.charAt(i), map.get(str1.charAt(i)) + 1);
                } else {
                    map.put(str1.charAt(i), 1);
                }
            }

            for (int i = 0; i < str2.length(); i++) {

                if (map.containsKey(str2.charAt(i))) {
                    map.put(str2.charAt(i), map.get(str2.charAt(i)) - 1);
                } else {
                    return false;
                }
            }

            Set<Character> keys = map.keySet();

            for (Character key : keys) {
                if (map.get(key) != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert first string:");
        String str1 = scanner.nextLine();
        System.out.println("Insert second string:");
        String str2 = scanner.nextLine();

        boolean anagrams = areAnagrams(str1, str2);

        if (anagrams) {
            System.out.println("Strings are anagrams!");
        } else  {
            System.out.println("No! Strings are NOT anagrams!");
        }
    }
}
