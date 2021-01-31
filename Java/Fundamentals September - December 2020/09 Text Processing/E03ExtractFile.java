import java.util.Scanner;

public class E03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();
        String nameFileAndExtension = path.substring(path.lastIndexOf("\\"));
        String nameFile = nameFileAndExtension.substring(1, nameFileAndExtension.indexOf("."));
        String extension = nameFileAndExtension.substring(nameFileAndExtension.indexOf(".") + 1);


        System.out.println("File name: " + nameFile);
        System.out.println("File extension: " + extension);


    }
}
