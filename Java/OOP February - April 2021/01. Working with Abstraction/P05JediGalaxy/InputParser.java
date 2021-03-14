package P05JediGalaxy;

import java.util.Arrays;

public class InputParser {
    public static int[] parseToIntegerArray(String input) {
        return Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
