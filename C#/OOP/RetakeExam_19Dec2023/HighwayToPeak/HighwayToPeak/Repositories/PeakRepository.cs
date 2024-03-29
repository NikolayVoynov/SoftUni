﻿using HighwayToPeak.Models.Contracts;
using HighwayToPeak.Repositories.Contracts;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HighwayToPeak.Repositories
{
    public class PeakRepository : IRepository<IPeak>
    {
        private List<IPeak> peaks;

        public PeakRepository()
        {
            this.peaks = new List<IPeak>();
        }

        public IReadOnlyCollection<IPeak> All => peaks.AsReadOnly();

        public void Add(IPeak model)
        {
            peaks.Add(model);
        }

        public IPeak Get(string name) => All.FirstOrDefault(p => p.Name == name);
    }
}
