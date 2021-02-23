import java.io.File;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Scanner;

public class L08NestedFolders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = "D:\\Materials\\SoftUni\\Java\\03 Advanced\\04 Streams, Files & Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        File root = new File(path);

        ArrayDeque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);

        int count = 0;

        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    dirs.offer(nestedFile);

                }
            }
            count++;
            System.out.println(current.getName());
        }

        System.out.println(count + " folders");
    }
}
