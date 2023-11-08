using FootballTeamGenerator.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FootballTeamGenerator
{
    public class StartUp
    {
        static void Main(string[] args)
        {
            List<Team> teams = new List<Team>();

            string input = Console.ReadLine();

            while (input != "END")
            {
                string[] tokens = input.Split(";");

                string command = tokens[0];

                try
                {
                    switch (command)
                    {
                        case "Team":
                            AddTeam(tokens[1], teams);
                            break;
                        case "Add":
                            AddPlayer(
                                tokens[1],
                                tokens[2],
                                int.Parse(tokens[3]),
                                int.Parse(tokens[4]),
                                int.Parse(tokens[5]),
                                int.Parse(tokens[6]),
                                int.Parse(tokens[7]),
                                teams);
                            break;
                        case "Remove":
                            RemovePlayer(
                                tokens[1],
                                tokens[2],
                                teams);
                            break;
                        case "Rating":
                            PrintRating(tokens[1], teams);
                            break;
                    }

                }
                catch (ArgumentException ex)
                {
                    Console.WriteLine(ex.Message);
                }


                input = Console.ReadLine();
            }
        }

        private static void PrintRating(string teamName, List<Team> teams)
        {
            Team team = teams.FirstOrDefault(t => t.Name == teamName);

            if (team == null)
            {
                throw new ArgumentException($"Team {teamName} does not exist.");
            }

            Console.WriteLine($"{teamName} - {team.Rating:f0}");
        }

        private static void RemovePlayer(string teamName, string playerName, List<Team> teams)
        {
            Team team = teams.FirstOrDefault(t => t.Name == teamName);

            if (team == null)
            {
                throw new ArgumentException($"Team {teamName} does not exist.");
            }

            team.RemovePlayer(playerName);
        }

        private static void AddPlayer(string teamName, string playerName, int endurance, int sprint, int dribble, int passing, int shooting, List<Team> teams)
        {
            Team team = teams.FirstOrDefault(t => t.Name == teamName);

            if (team == null)
            {
                throw new ArgumentException($"Team {teamName} does not exist.");
            }

            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);

            team.AddPlayer(player);
        }

        private static void AddTeam(string name, List<Team> teams)
        {
            teams.Add(new Team(name));
        }
    }
}
