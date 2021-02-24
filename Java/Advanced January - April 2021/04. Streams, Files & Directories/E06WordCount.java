import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class E06WordCount {

    private static final String WordsInPutPath = "C:\\Users\\user\\IdeaProjects\\AdvancedStreamsFilesDirectoriesExercise\\src\\Resources\\words.txt";
    private static final String TextInPutPath = "C:\\Users\\user\\IdeaProjects\\AdvancedStreamsFilesDirectoriesExercise\\src\\Resources\\text.txt";
    private static final String ResultOutPutPath = "C:\\Users\\user\\IdeaProjects\\AdvancedStreamsFilesDirectoriesExercise\\src\\Resources\\result.txt";

    public static void main(String[] args) {
        try (BufferedReader wordReader = new BufferedReader(new FileReader(WordsInPutPath));
             BufferedReader textReader = new BufferedReader(new FileReader(TextInPutPath));
             PrintWriter writer = new PrintWriter(ResultOutPutPath)) {

            String[] words = wordReader.readLine().split("\\s+");
            Map<String, Integer> wordOccurrence = new HashMap<>();

            for (String word : words) {
                wordOccurrence.putIfAbsent(word, 0);
            }

            String[] text = textReader.readLine().split("\\s+");

            for (String textEle : text) {
                if (wordOccurrence.containsKey(textEle)) {
                    wordOccurrence.put(textEle, wordOccurrence.get(textEle) + 1);
                }
            }

            wordOccurrence
                    .entrySet()
                    .stream()
                    .sorted((w1, w2) ->w2.getValue().compareTo(w1.getValue()))
                    .forEach(word->writer.println(String.format("%s - %d", word.getKey(),word.getValue())));


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }


}
