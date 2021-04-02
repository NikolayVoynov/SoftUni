package builderPattern;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car().withColor("Blue").withPetrolEngine(true).withXenonLights(true);
        System.out.println(car1.toString());

        Car car2 = new Car().withColor("Red").withDieselEngine(true).withXenonLights(true);
        System.out.println(car2.toString());

    }
}
