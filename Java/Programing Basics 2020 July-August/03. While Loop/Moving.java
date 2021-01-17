import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        int volume = width * length * height;

        boolean hasVolume = true;

        while (!command.equals("Done")) {
            int box = Integer.parseInt(command);
            volume -= box;

            if (volume < 0) {
                hasVolume = false;
                break;
            }
            command = scanner.nextLine();
        }
        if (hasVolume)
            System.out.printf("%d Cubic meters left.", volume);
        else
            System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(volume));
    }
}
