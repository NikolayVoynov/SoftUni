import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class E08GetFolderSize {

    private static final String InPutPath = "C:\\Users\\user\\IdeaProjects\\AdvancedStreamsFilesDirectoriesExercise\\src\\Resources\\Exercises Resources";
    private static final String ResultOutPutPath = "C:\\Users\\user\\IdeaProjects\\AdvancedStreamsFilesDirectoriesExercise\\src\\Resources\\result.txt";

    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(ResultOutPutPath)) {

            File folder = new File(InPutPath);
            int size = 0;

            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    size += file.length();
                }
            }

            writer.println(String.format("Folder size: " + size));

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }


}
