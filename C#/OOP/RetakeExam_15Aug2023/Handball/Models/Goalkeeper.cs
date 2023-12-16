using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Handball.Models
{
    public class Goalkeeper : Player
    {
        private const double rating = 2.5;
        private const double increaseValue = 0.75;
        private const double decreaseValue = 1.25;

        public Goalkeeper(string name) : base(name, rating)
        {
        }

        public override void DecreaseRating()
        {
            base.Rating -= decreaseValue;
        }

        public override void IncreaseRating()
        {
            base.Rating += increaseValue;
        }
    }
}
