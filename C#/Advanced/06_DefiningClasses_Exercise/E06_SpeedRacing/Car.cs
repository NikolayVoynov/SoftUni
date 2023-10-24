using System;
using System.Reflection;

namespace SpeedRacing;

public class Car
{
    private string model;
    private double fuelAmount;
    private double fuelConsumptionPerKilometer;
    private double travelledDistance;

    public Car(string model,
        double fuelAmount,
        double fuelConsumptionPerKilometer)
    {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelConsumptionPerKilometer = fuelConsumptionPerKilometer;
        this.travelledDistance = 0.0;
    }

    public string Model
    {
        get { return this.model; }
        set { this.model = value; }
    }

    public double FuelAmount
    {
        get { return this.fuelAmount; }
        set { this.fuelAmount = value; }
    }

    public double FuelConsumptionPerKilometer
    {
        get { return this.fuelConsumptionPerKilometer; }
        set { this.fuelConsumptionPerKilometer = value; }
    }

    public double TravelledDistance
    {
        get { return this.travelledDistance; }
        set { this.travelledDistance = value; }
    }

    public void Drive(double amountOfKm)
    {
        if (this.FuelAmount < amountOfKm * this.FuelConsumptionPerKilometer)
        {
            Console.WriteLine("Insufficient fuel for the drive");
        }
        else
        {
            this.FuelAmount -= amountOfKm * FuelConsumptionPerKilometer;
            this.TravelledDistance += amountOfKm;
        }
    }
}
