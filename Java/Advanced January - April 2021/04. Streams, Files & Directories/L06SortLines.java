import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L06SortLines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Path path = Paths.get("D:\\Materials\\SoftUni\\Java\\03 Advanced\\04 Streams, Files & Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Problem 06\\input.txt");
        Path output = Paths.get("D:\\Materials\\SoftUni\\Java\\03 Advanced\\04 Streams, Files & Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Problem 06\\06.SortLinesOutput.txt");

        try {
            List<String> lines = Files.readAllLines(path);
            lines.stream().filter(line -> !line.isBlank()).collect(Collectors.toList());
            Collections.sort(lines);
            Files.write(output, lines);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
