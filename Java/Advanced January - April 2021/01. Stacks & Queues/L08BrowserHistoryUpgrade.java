import java.util.ArrayDeque;
import java.util.Scanner;

public class L08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        String current = "";

        ArrayDeque<String> stackBrowser = new ArrayDeque<>();
        ArrayDeque<String> queueForward = new ArrayDeque<>();

        while (!command.equals("Home")) {

            if (command.equals("back")) {

                if (!stackBrowser.isEmpty()) {
                    queueForward.addFirst(current);
                    current = stackBrowser.pop();
                } else {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                }

            } else if (command.equals("forward")) {

                if (!queueForward.isEmpty()) {
                    current = queueForward.poll();

                } else {
                    System.out.println("no next URLs");
                    command = scanner.nextLine();
                    continue;
                }

            } else {
                if (!current.equals("")) {
                    stackBrowser.push(current);
                }

                queueForward.clear();
                current = command;
            }

            System.out.println(current);
            command = scanner.nextLine();
        }
    }
}
