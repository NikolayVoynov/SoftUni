﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Restaurant
{
    public abstract class ColdBeverage : Beverage
    {
        public ColdBeverage(string name, decimal price, double milliters) : base(name, price, milliters)
        {
        }
    }
}