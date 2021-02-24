import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class E05LineNumbers {

    private static final String InPutPath = "C:\\Users\\user\\IdeaProjects\\AdvancedStreamsFilesDirectoriesExercise\\src\\Resources\\inputLineNumbers.txt";
    private static final String OutPutPath = "C:\\Users\\user\\IdeaProjects\\AdvancedStreamsFilesDirectoriesExercise\\src\\Resources\\output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(InPutPath));
             PrintWriter writer = new PrintWriter(OutPutPath)) {

            String line = reader.readLine();
            int row = 0;

            while (line != null) {
                row++;

                writer.println(String.format("%d. " + line,row));

                line = reader.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
