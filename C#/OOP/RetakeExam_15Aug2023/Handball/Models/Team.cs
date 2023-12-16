using Handball.Models.Contracts;
using Handball.Utilities.Messages;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Handball.Models
{
    public class Team : ITeam
    {
        private string name;
        private int pointsEarned;
        private List<IPlayer> players;

        public Team(string name)
        {
            Name = name;
            this.pointsEarned = 0;
            this.players = new List<IPlayer>();
        }

        public string Name
        {
            get => name;
            private set
            {
                if (String.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentException(ExceptionMessages.TeamNameNull);
                }

                name = value;
            }
        }

        public int PointsEarned
        {
            get { return pointsEarned; }
            private set { pointsEarned = value; }
        }

        public double OverallRating
        {
            get
            {
                if (players.Count == 0)
                {
                    return 0;
                }
                return Math.Round(this.players.Average(p => p.Rating), 2);
            }
        }

        public IReadOnlyCollection<IPlayer> Players
        {
            get { return this.players.AsReadOnly(); }
        }
        public void Draw()
        {
            PointsEarned += 1;

            IPlayer goalKeeper = players.FirstOrDefault(p => p is Goalkeeper);

            if (goalKeeper != null)
            {
                goalKeeper.IncreaseRating();
            }
        }

        public void Lose()
        {
            foreach (var player in this.Players)
            {
                player.DecreaseRating();
            }
        }

        public void SignContract(IPlayer player)
        {
            this.players.Add(player);
        }

        public void Win()
        {
            PointsEarned += 3;
            foreach (var player in this.players)
            {
                player.IncreaseRating();
            }
        }

        public override string ToString()
        {
            string playersNames = "none";

            if (this.players.Count > 0)
            {
                playersNames = String.Join(", ", this.players.Select(p => p.Name));
            }
 
            StringBuilder sb = new StringBuilder();

            sb.AppendLine($"Team: {Name} Points: {PointsEarned}");
            sb.AppendLine($"--Overall rating: {OverallRating}");
            sb.AppendLine($"--Players: {playersNames}");

            return sb.ToString().TrimEnd();
        }
    }
}
