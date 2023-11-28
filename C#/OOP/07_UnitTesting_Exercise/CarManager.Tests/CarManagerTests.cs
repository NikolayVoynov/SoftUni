namespace CarManager.Tests
{
    using NUnit.Framework;
    using System;

    [TestFixture]
    public class CarManagerTests
    {
        private Car car;

        [SetUp]
        public void SetUp()
        {
            car = new Car("Mercedes", "C200", 7.2, 55.0);
        }

        [Test]
        public void MustCreateCarSuccessfully()
        {
            string expectedMake = "Mercedes";
            string expectedModel = "C200";
            double expectedFuelConsumption = 7.2;
            double expectedFuelCapacity = 55.0;

            Assert.AreEqual(expectedMake, car.Make);
            Assert.AreEqual(expectedModel, car.Model);
            Assert.AreEqual(expectedFuelConsumption, car.FuelConsumption);
            Assert.AreEqual(expectedFuelCapacity, car.FuelCapacity);
        }

        [Test]
        public void MustCreateCarWithZeroFuelAmount()
        {
            Assert.AreEqual(0, car.FuelAmount);
        }

        [TestCase("")]
        [TestCase(null)]
        public void WhenCarMakeSetToNullOrEmptyMustThrowException(string make)
        {
            ArgumentException exception = Assert.Throws<ArgumentException>(()
                => new Car(make, "C200", 7.2, 55.0));

            Assert.AreEqual("Make cannot be null or empty!", exception.Message);
        }

        [TestCase("")]
        [TestCase(null)]
        public void WhenCarModelSetToNullOrEmptyMustThrowException(string model)
        {
            ArgumentException exception = Assert.Throws<ArgumentException>(()
                => new Car("Mercedes", model, 7.2, 55.0));

            Assert.AreEqual("Model cannot be null or empty!", exception.Message);
        }

        [TestCase(0)]
        [TestCase(-6)]
        public void WhenCarFuelConsumptionSetToZeroOrNegativeMustThrowException(double fuelConsumption)
        {
            ArgumentException exception = Assert.Throws<ArgumentException>(()
                => new Car("Mercedes", "C200", fuelConsumption, 55.0));

            Assert.AreEqual("Fuel consumption cannot be zero or negative!", exception.Message);
        }

        [Test]
        public void IfCarFuelAmountIsNegativeMustThrowException()
        {
            Assert.Throws<InvalidOperationException>(()
                => car.Drive(12), "Fuel amount cannot be negative!");
        }

        [TestCase(0)]
        [TestCase(-15)]
        public void WhenCarFuelCapacitySetToZeroOrNegativeMustThrowException(double fuelCapacity)
        {
            ArgumentException exception = Assert.Throws<ArgumentException>(()
                => new Car("Mercedes", "C200", 7.2, fuelCapacity));

            Assert.AreEqual("Fuel capacity cannot be zero or negative!", exception.Message);
        }

        [TestCase(0)]
        [TestCase(-15)]
        public void RefuelMethodMustThrowExceptionWhenSetToZeroOrNegative(double refuelAmount)
        {
            ArgumentException exception = Assert.Throws<ArgumentException>(()
                => car.Refuel(refuelAmount));

            Assert.AreEqual("Fuel amount cannot be zero or negative!", exception.Message);
        }

        [Test]
        public void RefuelMethodMustIncreaseFuelAmount()
        {
            double expectedResult = 15.0;

            car.Refuel(15);
            double actualResult = car.FuelAmount;

            Assert.AreEqual(expectedResult, actualResult);
        }

        [Test]
        public void FuelAmountCanNotBeMoreThanFuelCapacity()
        {
            double expectedResult = 55.0;

            car.Refuel(75.0);
            double actualResult = car.FuelAmount;

            Assert.AreEqual(expectedResult, actualResult);
        }

        [Test]
        public void DriveMethodMustDecreaseFuelAmount()
        {
            double expectedResult = 9.28;

            car.Refuel(10);
            car.Drive(10);
            double actualResult = car.FuelAmount;

            Assert.AreEqual(expectedResult, actualResult);
        }

        [Test]
        public void DriveMethodMustThrowExceptionIfFuelNeededIsMoreThanFuelAmount()
        {
            car.Refuel(2);

            InvalidOperationException exception = Assert.Throws<InvalidOperationException>(()
                => car.Drive(50));

            Assert.AreEqual("You don't have enough fuel to drive!", exception.Message);
        }


    }
}