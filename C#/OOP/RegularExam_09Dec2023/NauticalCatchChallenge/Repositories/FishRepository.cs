using NauticalCatchChallenge.Models.Contracts;
using NauticalCatchChallenge.Repositories.Contracts;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NauticalCatchChallenge.Repositories
{
    public class FishRepository : IRepository<IFish>
    {
        private List<IFish> fishList;

        public FishRepository()
        {
            this.fishList = new List<IFish>();
        }

        public IReadOnlyCollection<IFish> Models => fishList.AsReadOnly();

        public void AddModel(IFish model)
        {
            fishList.Add(model);
        }

        public IFish GetModel(string name) => Models.FirstOrDefault(f => f.Name == name);
    }
}
