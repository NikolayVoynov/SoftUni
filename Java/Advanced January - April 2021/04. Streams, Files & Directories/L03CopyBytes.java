import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class L03CopyBytes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputPath = "D:\\Materials\\SoftUni\\Java\\03 Advanced\\04 Streams, Files & Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Problem 03\\input.txt";
        String outputPath = "D:\\Materials\\SoftUni\\Java\\03 Advanced\\04 Streams, Files & Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Problem 03\\03.CopyBytesOutput.txt";

        try (FileInputStream inputStream = new FileInputStream(inputPath);
             FileOutputStream outputStream = new FileOutputStream(outputPath)) {

            int oneByte = 0;

            while ((oneByte = inputStream.read()) >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    outputStream.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);

                    for (int i = 0; i < digits.length(); i++) {
                        outputStream.write(digits.charAt(i));
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
