import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E07MergeTwoFiles {

    private static final String OneInPutPath = "C:\\Users\\user\\IdeaProjects\\AdvancedStreamsFilesDirectoriesExercise\\src\\Resources\\inputOne.txt";
    private static final String TwoInPutPath = "C:\\Users\\user\\IdeaProjects\\AdvancedStreamsFilesDirectoriesExercise\\src\\Resources\\inputTwo.txt";
    private static final String ResultOutPutPath = "C:\\Users\\user\\IdeaProjects\\AdvancedStreamsFilesDirectoriesExercise\\src\\Resources\\result.txt";

    public static void main(String[] args) {
        try (BufferedReader oneReader = new BufferedReader(new FileReader(OneInPutPath));
             BufferedReader twoReader = new BufferedReader(new FileReader(TwoInPutPath));
             PrintWriter writer = new PrintWriter(ResultOutPutPath)) {

            List<String> listToPrint = new ArrayList<>();
            String oneInput = oneReader.readLine();

            while (oneInput != null) {
                listToPrint.add(oneInput);
                oneInput = oneReader.readLine();
            }

            String twoInput = twoReader.readLine();
            while (twoInput != null) {
                listToPrint.add(twoInput);
                twoInput = twoReader.readLine();
            }

            for (String element : listToPrint) {
                writer.println(element);
            }


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }


}
