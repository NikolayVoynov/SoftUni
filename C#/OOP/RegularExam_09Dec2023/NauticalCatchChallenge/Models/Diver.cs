using NauticalCatchChallenge.Models.Contracts;
using NauticalCatchChallenge.Utilities.Messages;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NauticalCatchChallenge.Models
{
    public abstract class Diver : IDiver
    {
        private string name;
        private int oxygenLevel;
        private List<string> catchList;
        private double competitionPoints;
        private bool hasHealthIssues;

        protected Diver(string name, int oxygenLevel)
        {
            Name = name;
            OxygenLevel = oxygenLevel;
            catchList = new List<string>();
            competitionPoints = 0;
            hasHealthIssues = false;
        }

        public string Name
        {
            get => name;
            private set
            {
                if (string.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentException(ExceptionMessages.DiversNameNull);
                }
                name = value;
            }
        }

        public int OxygenLevel
        {
            get => oxygenLevel;
            protected set
            {
                oxygenLevel = Math.Max(value, 0);
            }
        }

        public IReadOnlyCollection<string> Catch => catchList.AsReadOnly();

        public double CompetitionPoints => Math.Round(competitionPoints, 1);

        public bool HasHealthIssues => hasHealthIssues;

        public void Hit(IFish fish)
        {
            OxygenLevel -= fish.TimeToCatch;
            catchList.Add(fish.Name);
            competitionPoints += Math.Round(fish.Points, 1, MidpointRounding.AwayFromZero);
        }

        public abstract void Miss(int TimeToCatch);

        public abstract void RenewOxy();

        public void UpdateHealthStatus()
        {
            hasHealthIssues = !hasHealthIssues;
        }

        public override string ToString()
        {
            return $"Diver [ Name: {Name}, Oxygen left: {OxygenLevel}, Fish caught: {catchList.Count}, Points earned: {CompetitionPoints} ]";
        }
    }
}
