﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VehiclesExtension.Models.Interfaces
{
    public interface IVehicle
    {
        double FuelQuantity { get; }

        double FuelConsumption { get; }

        string Drive(double distance, bool isIncreasedConsumption = true);

        void Refuel(double fuelAmount);
    }
}
