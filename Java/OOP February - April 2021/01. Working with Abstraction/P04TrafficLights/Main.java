package P04TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] initialTrafficLights = scanner.nextLine().split("\\s+");
        int countOfUpdates = Integer.parseInt(scanner.nextLine());

        List<TrafficLight> trafficLights = new ArrayList<>();

        for (String currentTrafficLight : initialTrafficLights) {
            TrafficLight trafficLight = new TrafficLight(TrafficLightState.valueOf(currentTrafficLight));
            trafficLights.add(trafficLight);
        }

        for (int i = 0; i < countOfUpdates; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.update();
                System.out.print(trafficLight);
            }
            System.out.println();
        }

    }
}
