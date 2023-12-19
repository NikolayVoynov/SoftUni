using HighwayToPeak.Models.Contracts;
using HighwayToPeak.Repositories.Contracts;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HighwayToPeak.Repositories
{
    public class ClimberRepository : IRepository<IClimber>
    {
        private List<IClimber> listClimbers;

        public ClimberRepository()
        {
            this.listClimbers = new List<IClimber>();
        }

        public IReadOnlyCollection<IClimber> All => listClimbers.AsReadOnly();

        public void Add(IClimber model)
        {
            listClimbers.Add(model);
        }

        public IClimber Get(string name) => All.FirstOrDefault(c => c.Name == name);
    }
}
