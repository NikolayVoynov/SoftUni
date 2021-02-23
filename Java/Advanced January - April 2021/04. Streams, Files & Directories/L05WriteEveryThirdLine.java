import java.io.*;
import java.util.Scanner;

public class L05WriteEveryThirdLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputPath = "D:\\Materials\\SoftUni\\Java\\03 Advanced\\04 Streams, Files & Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Problem 05\\input.txt";
        String outputPath = "D:\\Materials\\SoftUni\\Java\\03 Advanced\\04 Streams, Files & Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Problem 05\\05.WriteEveryThirdLineOutput.txt";

        try (BufferedReader inputStream = new BufferedReader(new FileReader(inputPath));
             PrintWriter outputStream = new PrintWriter(new FileWriter(outputPath))) {

            int counter = 1;
            String line = inputStream.readLine();

            while (line != null) {
                if (counter % 3 == 0) {
                    outputStream.println(line);
                }
                counter++;
                line = inputStream.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
