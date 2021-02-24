import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

public class E04CountCharacterTypes {

    private static final String InPutPath = "C:\\Users\\user\\IdeaProjects\\AdvancedStreamsFilesDirectoriesExercise\\src\\Resources\\input.txt";
    private static final String OutPutPath = "C:\\Users\\user\\IdeaProjects\\AdvancedStreamsFilesDirectoriesExercise\\src\\Resources\\output.txt";

    public static void main(String[] args) {

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuation = Set.of('!', '.', ',', '?');

        int vowelsCount = 0;
        int consonantsCount = 0;
        int punctuationCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(InPutPath));
             PrintWriter writer = new PrintWriter(OutPutPath)) {

            String line = reader.readLine();

            while (line != null) {

                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);

                    if (vowels.contains(symbol)) {
                        vowelsCount++;
                    } else if (punctuation.contains(symbol)) {
                        punctuationCount++;
                    } else if (symbol != ' ') {
                        consonantsCount++;
                    }
                }
                line = reader.readLine();
            }

            StringBuilder sb = new StringBuilder();

            sb.append(String.format("Vowels: %d", vowelsCount))
                    .append(System.lineSeparator())
                    .append(String.format("Consonants: %d", consonantsCount))
                    .append(System.lineSeparator())
                    .append(String.format("Punctuation: %d", punctuationCount));

            writer.println(sb);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
