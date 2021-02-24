import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class E02SumBytes {

    private static final String Path = "C:\\Users\\user\\IdeaProjects\\AdvancedStreamsFilesDirectoriesExercise\\src\\Resources\\input.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(Path))) {

            String line = reader.readLine();

            long sum = 0;

            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }

                line = reader.readLine();
            }

            System.out.println(sum);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
