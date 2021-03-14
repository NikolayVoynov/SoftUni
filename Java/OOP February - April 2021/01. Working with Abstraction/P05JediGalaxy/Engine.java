package P05JediGalaxy;

public class Engine {
    private ConsoleReader consoleReader;
    private Enemy enemy;
    private Player player;
    private String command;

    public Engine(ConsoleReader consoleReader, Enemy enemy, Player player) {
        this.consoleReader = consoleReader;
        this.enemy = enemy;
        this.player = player;
        this.command = "";
    }

    public void run() {
        this.command = consoleReader.readLine();

        while (!command.equals("Let the Force be with you")) {

            int[] playerLocation = InputParser.parseToIntegerArray(this.command);
            int[] enemyLocation = InputParser.parseToIntegerArray(this.consoleReader.readLine());

            int playerRow = playerLocation[0];
            int playerCol = playerLocation[1];

            int enemyRow = enemyLocation[0];
            int enemyCol = enemyLocation[1];

            this.enemy.deleteStars(enemyRow, enemyCol);

            this.player.collectStars(playerRow, playerCol);

            this.command = consoleReader.readLine();
        }
    }
}
