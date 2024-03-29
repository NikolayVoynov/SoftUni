﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VehiclesExtension.Models
{
    public class Truck : Vehicle
    {
        private const double IncreasedConsumption = 1.6;

        public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity)
            : base(fuelQuantity, fuelConsumption, tankCapacity, IncreasedConsumption)
        {
        }

        public override void Refuel(double fuelAmount)
        {
            if (fuelAmount + FuelQuantity > TankCapacity)
            {
                throw new ArgumentException($"Cannot fit {fuelAmount} fuel in the tank");
            }

            base.Refuel(fuelAmount * 0.95);
        }
    }
}
