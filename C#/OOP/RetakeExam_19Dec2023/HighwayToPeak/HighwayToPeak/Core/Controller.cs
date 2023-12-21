using HighwayToPeak.Core.Contracts;
using HighwayToPeak.Models;
using HighwayToPeak.Models.Contracts;
using HighwayToPeak.Repositories;
using HighwayToPeak.Repositories.Contracts;
using HighwayToPeak.Utilities.Messages;
using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace HighwayToPeak.Core
{
    public class Controller : IController
    {
        private IRepository<IPeak> peaks;
        private IRepository<IClimber> climbers;
        private BaseCamp baseCamp;

        public Controller()
        {
            this.peaks = new PeakRepository();
            this.climbers = new ClimberRepository();
            this.baseCamp = new BaseCamp();
        }

        public string AddPeak(string name, int elevation, string difficultyLevel)
        {
            IPeak peak = peaks.Get(name);
            if (peak != null)
            {
                return string.Format(OutputMessages.PeakAlreadyAdded, name);
            }

            if (difficultyLevel != "Extreme" && difficultyLevel != "Hard" && difficultyLevel != "Moderate")
            {
                return string.Format(OutputMessages.PeakDiffucultyLevelInvalid, difficultyLevel);
            }

            IPeak newPeak = new Peak(name, elevation, difficultyLevel);
            peaks.Add(newPeak);
            return string.Format(OutputMessages.PeakIsAllowed, name, nameof(PeakRepository));
        }

        public string NewClimberAtCamp(string name, bool isOxygenUsed)
        {
            IClimber climber = climbers.Get(name);
            if (climber != null)
            {
                return string.Format(OutputMessages.ClimberCannotBeDuplicated, name, nameof(ClimberRepository));
            }
            else
            {
                IClimber newClimber;
                if (isOxygenUsed)
                {
                    newClimber = new OxygenClimber(name);
                }
                else
                {
                    newClimber = new NaturalClimber(name);
                }

                climbers.Add(newClimber);
                baseCamp.ArriveAtCamp(name);
                return string.Format(OutputMessages.ClimberArrivedAtBaseCamp, name);
            }
        }

        public string AttackPeak(string climberName, string peakName)
        {
            IClimber climber = climbers.Get(climberName);
            if (climber == null)
            {
                return string.Format(OutputMessages.ClimberNotArrivedYet, climberName);
            }

            IPeak peak = peaks.Get(peakName);
            if (peak == null)
            {
                return string.Format(OutputMessages.PeakIsNotAllowed, peakName);
            }

            if (!baseCamp.Residents.Contains(climberName))
            {
                return string.Format(OutputMessages.ClimberNotFoundForInstructions, climberName, peakName);
            }

            if (peak.DifficultyLevel == "Extreme" && climber.GetType().Name == "NaturalClimber")
            {
                return string.Format(OutputMessages.NotCorrespondingDifficultyLevel, climberName, peakName);
            }

            baseCamp.LeaveCamp(climberName);
            climber.Climb(peak);

            if (climber.Stamina == 0)
            {
                return string.Format(OutputMessages.NotSuccessfullAttack, climberName);
            }
            else
            {
                baseCamp.ArriveAtCamp(climberName);
                return string.Format(OutputMessages.SuccessfulAttack, climberName, peakName);
            }
        }

        public string CampRecovery(string climberName, int daysToRecover)
        {

            if (!baseCamp.Residents.Contains(climberName))
            {
                return string.Format(OutputMessages.ClimberIsNotAtBaseCamp,climberName);
            }

            IClimber climber = climbers.Get(climberName);

            if(climber.Stamina == 10)
            {
                return string.Format(OutputMessages.NoNeedOfRecovery, climberName);
            }
            else 
            {
                climber.Rest(daysToRecover);
                return string.Format(OutputMessages.ClimberRecovered, climberName, daysToRecover);
            }
        }

        public string BaseCampReport()
        {
            StringBuilder sb = new StringBuilder();
           
            if (baseCamp.Residents.Count() == 0)
            {
                return "BaseCamp is currently empty.";
            }
            else
            {
                sb.AppendLine("BaseCamp residents:");

                foreach (var name in baseCamp.Residents)
                {
                    IClimber climber = climbers.Get(name);
                    sb.AppendLine($"Name: {climber.Name}, Stamina: {climber.Stamina}, Count of Conquered Peaks: {climber.ConqueredPeaks.Count}");
                }
            }

            return sb.ToString().TrimEnd();
        }

        public string OverallStatistics()
        {
            StringBuilder sb = new StringBuilder();
            sb.AppendLine("***Highway-To-Peak***");

            foreach(var climber in climbers.All.OrderByDescending(cl => cl.ConqueredPeaks.Count).ThenBy(cl => cl.Name))
            {
                sb.AppendLine(climber.ToString().TrimEnd());

                List<IPeak> climberPeaks = new List<IPeak>();
                IReadOnlyCollection<string> conqueredPeaksByString = climber.ConqueredPeaks;

                foreach (var stringPeak in conqueredPeaksByString)
                {
                    IPeak peak = peaks.Get(stringPeak);

                    if(peak != null)
                    {
                        climberPeaks.Add(peak);
                    }
                }


                foreach (var peak in climberPeaks.OrderByDescending(p=>p.Elevation))
                {
                    sb.AppendLine(peak.ToString());
                }
            }

            return sb.ToString().TrimEnd();
        }
    }
}
