import java.io.File;
import java.util.Scanner;

public class L07ListFiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        File file = new File("D:\\Materials\\SoftUni\\Java\\03 Advanced\\04 Streams, Files & Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    if (!f.isDirectory()) {
                        System.out.printf("%s: [%s]%n", f.getName(), f.length());
                    }
                }
            }
        }
    }
}
