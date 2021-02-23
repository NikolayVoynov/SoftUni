import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class L02WriteToFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputPath = "D:\\Materials\\SoftUni\\Java\\03 Advanced\\04 Streams, Files & Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Problem 02\\input.txt";
        String outputPath = "D:\\Materials\\SoftUni\\Java\\03 Advanced\\04 Streams, Files & Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Problem 02\\02.WriteToFileOutput.txt";

        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '!', '?', '.', ',');

        try (FileInputStream inputStream = new FileInputStream(inputPath);
             FileOutputStream outputStream = new FileOutputStream(outputPath)) {

            int oneByte = 0;
            while ((oneByte = inputStream.read()) >= 0) {
                if (!symbols.contains((char)oneByte)) {
                    outputStream.write(oneByte);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
