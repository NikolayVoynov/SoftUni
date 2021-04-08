package garage;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GarageTests {

    @Test
    public void testConstructorIfArraySizeIsCorrect() {
        Garage garage = new Garage();
        garage.addCar(new Car("Audi", 100, 10000));
        garage.addCar(new Car("Audi", 150, 11000));

        List<Car> expected = new ArrayList<>();
        expected.add(new Car("Audi", 100, 10000));
        expected.add(new Car("Audi", 150, 11000));

        Assert.assertEquals(expected.size(), garage.getCars().size());
    }


    @Test
    public void testFindAllCarsWithMaxSpeedAbove() {
        Garage garage = new Garage();
        garage.addCar(new Car("Audi", 100, 10000));
        garage.addCar(new Car("Audi", 150, 11000));
        garage.addCar(new Car("Audi", 200, 12000));

        List<Car> expected = new ArrayList<>();
        expected.add(new Car("Audi", 150, 11000));
        expected.add(new Car("Audi", 200, 12000));

        List<Car> actual = garage.findAllCarsWithMaxSpeedAbove(110);

        Assert.assertEquals(expected.size(), actual.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_testAddCar_then_throwException() {
        Garage garage = new Garage();
        garage.addCar(null);
    }

    @Test
    public void when_getTheMostExpensiveCar_then_returnCorrect() {
        Garage garage = new Garage();
        garage.addCar(new Car("Audi1", 100, 10000.0));
        garage.addCar(new Car("Audi2", 150, 11000.0));
        garage.addCar(new Car("Audi3", 200, 12000.0));

        Car expected = new Car("Audi3", 200, 12000.0);

        Car actual = garage.getTheMostExpensiveCar();

        Assert.assertEquals(expected.getBrand(), actual.getBrand());
    }

    @Test
    public void when_findAllCarsByBrand_then_returnTheCorrect(){
        Garage garage = new Garage();
        garage.addCar(new Car("Audi1", 100, 10000.0));
        garage.addCar(new Car("Audi1", 150, 11000.0));
        garage.addCar(new Car("Audi3", 200, 12000.0));

        List<Car> expected = new ArrayList<>();
        expected.add(new Car("Audi1", 100, 10000.0));
        expected.add(new Car("Audi1", 150, 11000.0));

        List<Car> actual = garage.findAllCarsByBrand("Audi1");

        Assert.assertEquals(expected.size(), actual.size());
    }


}