using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HighwayToPeak.Models
{
    public class NaturalClimber : Climber
    {
        private const int initStamina = 6;
        private const int recoverUnit = 2;
        public NaturalClimber(string name) : base(name, initStamina)
        {
        }

        public override void Rest(int daysCount)
        {
            base.Stamina += daysCount * recoverUnit;
        }
    }
}
