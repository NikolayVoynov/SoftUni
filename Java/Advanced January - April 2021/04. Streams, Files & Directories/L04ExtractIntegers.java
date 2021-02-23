import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class L04ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {

        String inputPath = "D:\\Materials\\SoftUni\\Java\\03 Advanced\\04 Streams, Files & Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Problem 04\\input.txt";
        String outputPath = "D:\\Materials\\SoftUni\\Java\\03 Advanced\\04 Streams, Files & Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Problem 04\\04.ExtractIntegersOutput.txt";

        Scanner scanner = new Scanner(new FileInputStream(inputPath));
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputPath));

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                printWriter.println(scanner.nextInt());
            }
            scanner.next();
        }
        printWriter.flush();
        printWriter.close();
    }
}
