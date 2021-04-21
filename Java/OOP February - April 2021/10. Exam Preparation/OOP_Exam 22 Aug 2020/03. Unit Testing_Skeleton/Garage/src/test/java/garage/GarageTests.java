package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GarageTests {
    private Garage garage;

    @Before
    public void setUp() {
        this.garage = new Garage();
        this.garage.addCar(new Car("Audi4", 100, 10000.0));
        this.garage.addCar(new Car("Audi5", 150, 11000.0));
        this.garage.addCar(new Car("Audi6", 200, 12000.0));
    }

    @Test
    public void testConstructorIfArraySizeIsCorrect() {
        Assert.assertEquals(3, garage.getCars().size());
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAbove() {
        List<Car> actual = this.garage.findAllCarsWithMaxSpeedAbove(110);
        Assert.assertEquals(2, actual.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_testAddCar_then_throwException() {
        this.garage.addCar(null);
    }

    @Test
    public void when_getTheMostExpensiveCar_then_returnCorrect() {
        Car expected = new Car("Audi6", 200, 12000.0);
        Car actual = this.garage.getTheMostExpensiveCar();
        Assert.assertEquals(expected.getBrand(), actual.getBrand());
    }

    @Test
    public void when_findAllCarsByBrand_then_returnTheCorrect() {
        List<Car> actual = garage.findAllCarsByBrand("Audi5");
        Assert.assertEquals(1, actual.size());
    }


}