import java.io.*;

public class E03AllCapitals {

    private static final String InPutPath = "C:\\Users\\user\\IdeaProjects\\AdvancedStreamsFilesDirectoriesExercise\\src\\Resources\\input.txt";
    private static final String OutPutPath = "C:\\Users\\user\\IdeaProjects\\AdvancedStreamsFilesDirectoriesExercise\\src\\Resources\\output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(InPutPath));
             PrintWriter writer = new PrintWriter(OutPutPath)) {

            String line = reader.readLine();

            while (line != null) {

                writer.println(line.toUpperCase());

                line = reader.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
