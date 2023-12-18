using NauticalCatchChallenge.Core.Contracts;
using NauticalCatchChallenge.Models;
using NauticalCatchChallenge.Models.Contracts;
using NauticalCatchChallenge.Repositories;
using NauticalCatchChallenge.Repositories.Contracts;
using NauticalCatchChallenge.Utilities.Messages;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NauticalCatchChallenge.Core
{
    public class Controller : IController
    {
        private IRepository<IDiver> divers;
        private IRepository<IFish> fishList;

        public Controller()
        {
            this.divers = new DiverRepository();
            this.fishList = new FishRepository();
        }

        public string DiveIntoCompetition(string diverType, string diverName)
        {
            if (diverType != nameof(ScubaDiver) && diverType != nameof(FreeDiver))
            {
                return string.Format(OutputMessages.DiverTypeNotPresented, diverType);
            }

            if (divers.GetModel(diverName) != null)
            {
                return string.Format(OutputMessages.DiverNameDuplication, diverName, nameof(DiverRepository));
            }

            IDiver diver;
            if (diverType == nameof(FreeDiver))
            {
                diver = new FreeDiver(diverName);
            }
            else
            {
                diver = new ScubaDiver(diverName);
            }

            divers.AddModel(diver);
            return string.Format(OutputMessages.DiverRegistered, diverName, nameof(DiverRepository));
        }

        public string SwimIntoCompetition(string fishType, string fishName, double points)
        {
            if (fishType != nameof(ReefFish) && fishType != nameof(DeepSeaFish) && fishType != nameof(PredatoryFish))
            {
                return string.Format(OutputMessages.FishTypeNotPresented, fishType);
            }

            if (fishList.GetModel(fishName) != null)
            {
                return string.Format(OutputMessages.FishNameDuplication, fishName, nameof(FishRepository));
            }

            IFish newFish;
            if (fishType == nameof(ReefFish))
            {
                newFish = new ReefFish(fishName, points);
            }
            else if (fishType == nameof(DeepSeaFish))
            {
                newFish = new DeepSeaFish(fishName, points);
            }
            else
            {
                newFish = new PredatoryFish(fishName, points);
            }

            fishList.AddModel(newFish);
            return string.Format(OutputMessages.FishCreated, fishName);
        }

        public string ChaseFish(string diverName, string fishName, bool isLucky)
        {
            if (divers.GetModel(diverName) == null)
            {
                return string.Format(OutputMessages.DiverNotFound, nameof(DiverRepository), diverName);
            }

            if (fishList.GetModel(fishName) == null)
            {
                return string.Format(OutputMessages.FishNotAllowed, fishName);
            }

            IDiver diver = divers.GetModel(diverName);
            if (diver.HasHealthIssues)
            {
                return string.Format(OutputMessages.DiverHealthCheck, diverName);
            }

            IFish currFish = fishList.GetModel(fishName);
            if (diver.OxygenLevel < currFish.TimeToCatch)
            {
                diver.Miss(currFish.TimeToCatch);
                if (diver.OxygenLevel == 0)
                {
                    diver.UpdateHealthStatus();
                }
                return string.Format(OutputMessages.DiverMisses, diverName, fishName);
            }
            else if (diver.OxygenLevel == currFish.TimeToCatch && isLucky == false)
            {
                diver.Miss(currFish.TimeToCatch);
                if (diver.OxygenLevel == 0)
                {
                    diver.UpdateHealthStatus();
                }
                return string.Format(OutputMessages.DiverMisses, diverName, fishName);
            }
            else
            {
                {
                    diver.Hit(currFish);
                    if (diver.OxygenLevel == 0)
                    {
                        diver.UpdateHealthStatus();
                    }
                    return string.Format(OutputMessages.DiverHitsFish, diverName, currFish.Points, fishName);
                }
            }
        }

        public string HealthRecovery()
        {
            int counter = 0;

            foreach (var diver in divers.Models)
            {
                if (diver.HasHealthIssues)
                {
                    diver.UpdateHealthStatus();
                    diver.RenewOxy();
                    counter++;
                }
            }

            return string.Format(OutputMessages.DiversRecovered, counter.ToString());
        }
        public string DiverCatchReport(string diverName)
        {
            IDiver diver = divers.GetModel(diverName);

            StringBuilder sb = new StringBuilder();
            sb.AppendLine(diver.ToString());
            sb.AppendLine("Catch Report:");

            foreach (var fishName in diver.Catch)
            {
                IFish fish = fishList.GetModel(fishName);
                sb.AppendLine(fish.ToString());
            }

            return sb.ToString().TrimEnd();
        }
        public string CompetitionStatistics()
        {
            StringBuilder sb = new StringBuilder();
            sb.AppendLine("**Nautical-Catch-Challenge**");

            List<IDiver> selectedDivers = divers
                .Models
                .Where(d=>d.HasHealthIssues == false)
                .OrderByDescending(d=>d.CompetitionPoints)
                .ThenByDescending(d=>d.Catch.Count)
                .ThenBy(d=>d.Name)
                .ToList();

            foreach (var diver in selectedDivers)
            {
                sb.AppendLine(diver.ToString());
            }

            return sb.ToString().TrimEnd();
        }




    }
}
