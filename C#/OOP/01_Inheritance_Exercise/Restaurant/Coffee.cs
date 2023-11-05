using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Restaurant
{
    public class Coffee : HotBeverage
    {
        private const decimal CoffeePrice = 3.50M;
        private const double CoffeeMilliliters = 50;
        public Coffee(string name, decimal price, double milliters, double caffeine) : base(name, price, milliters)
        {
            Caffeine = caffeine;
        }

        public double Caffeine { get; private set; }
    }
}
