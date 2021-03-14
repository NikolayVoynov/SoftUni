package P05JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();

        int[] dimensions = InputParser.parseToIntegerArray(consoleReader.readLine());
        int rows = dimensions[0];
        int cols = dimensions[1];

        Galaxy galaxy = new Galaxy(new Field(new int[rows][cols]));

        Enemy enemy = new Enemy(galaxy);
        Player player = new Player(galaxy);
        Engine engine = new Engine(consoleReader, enemy, player);

        engine.run();

        System.out.println(player.getCollectedPoints());


    }
}
