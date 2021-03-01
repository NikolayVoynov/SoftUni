package E05CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Engine> enginesMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputEngine = scanner.nextLine().split("\\s+");
            String modelEng = inputEngine[0];
            int powerEng = Integer.parseInt(inputEngine[1]);

            Engine engine = null;
            if (inputEngine.length == 2) {
                engine = new Engine(modelEng, powerEng);
            } else if (inputEngine.length == 3) {
                if (inputEngine[2].matches("^\\d+$")) {
                    int displacementEng = Integer.parseInt(inputEngine[2]);
                    engine = new Engine(modelEng, powerEng, displacementEng);
                } else {
                    String efficiencyEng = inputEngine[2];
                    engine = new Engine(modelEng, powerEng, efficiencyEng);
                }
            } else if (inputEngine.length == 4) {
                int displacementEng = Integer.parseInt(inputEngine[2]);
                String efficiencyEng = inputEngine[3];
                engine = new Engine(modelEng, powerEng, displacementEng, efficiencyEng);
            }

            enginesMap.putIfAbsent(modelEng, engine);
        }

        int m = Integer.parseInt(scanner.nextLine());

        List<Car> carsList = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            String[] inputCar = scanner.nextLine().split("\\s+");
            String modelCar = inputCar[0];
            Engine engine = enginesMap.get(inputCar[1]);

            Car car = null;

            if (inputCar.length == 2) {
                car = new Car(modelCar, engine);
            } else if (inputCar.length == 3) {
                if (inputCar[2].matches("^\\d+$")) {
                    int weight = Integer.parseInt(inputCar[2]);
                    car = new Car(modelCar, engine, weight);
                } else {
                    String color = inputCar[2];
                    car = new Car(modelCar, engine, color);
                }
            } else if (inputCar.length == 4) {
                int weight = Integer.parseInt(inputCar[2]);
                String color = inputCar[3];
                car = new Car(modelCar, engine, weight, color);
            }

            carsList.add(car);
        }

        carsList.forEach(car -> System.out.println(car));


    }

}
