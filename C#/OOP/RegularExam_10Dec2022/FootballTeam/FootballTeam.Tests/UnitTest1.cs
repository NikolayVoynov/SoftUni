using NUnit.Framework;
using System.Collections.Generic;
using System;

namespace FootballTeam.Tests
{
    public class Tests
    {
        [SetUp]
        public void Setup()
        {

        }

        [Test]
        public void CreateFootballTeamWithValidParams()
        {
            FootballTeam team = new FootballTeam("Levski", 23);

            Assert.AreEqual("Levski", team.Name);
            Assert.AreEqual(23, team.Capacity);
            Assert.AreEqual(0, team.Players.Count);

            Type t = team.Players.GetType();
            Type expectedType = typeof(List<FootballPlayer>);

            Assert.AreEqual(t, expectedType);
        }

        [Test]
        public void CreateFootballTeamWithInvalidNameAndThrowException()
        {
            FootballTeam team;

            Assert.Throws<ArgumentException>(() => team = new FootballTeam(null, 23));
        }

        [Test]
        public void CreateFootballTeamWithInvalidCapacityAndThrowException()
        {
            FootballTeam team;

            Assert.Throws<ArgumentException>(() => team = new FootballTeam("Levski", 10));
        }

        [Test]
        public void AddNewPlayerWithValidParams()
        {
            FootballTeam team = new FootballTeam("Levski", 23);
            FootballPlayer player = new FootballPlayer("Nikolay Voynov", 10, "Midfielder");

            string expectedOutput = "Added player Nikolay Voynov in position Midfielder with number 10";
            string actualOutput = team.AddNewPlayer(player);

            Assert.AreEqual(expectedOutput,actualOutput);
        }

        [Test]
        public void AddNewPlayerWhenFullCapacity()
        {
            FootballTeam team = new FootballTeam("Levski", 15);
            FootballPlayer player1 = new FootballPlayer("Player1", 1, "Goalkeeper");
            FootballPlayer player2 = new FootballPlayer("Player2", 2, "Midfielder");
            FootballPlayer player3 = new FootballPlayer("Player3", 3, "Midfielder");
            FootballPlayer player4 = new FootballPlayer("Player4", 4, "Midfielder");
            FootballPlayer player5 = new FootballPlayer("Player5", 5, "Midfielder");
            FootballPlayer player6 = new FootballPlayer("Player6", 6, "Midfielder");
            FootballPlayer player7 = new FootballPlayer("Player7", 7, "Midfielder");
            FootballPlayer player8 = new FootballPlayer("Player8", 8, "Midfielder");
            FootballPlayer player9 = new FootballPlayer("Player9", 9, "Forward");
            FootballPlayer player10 = new FootballPlayer("Player10", 10, "Midfielder");
            FootballPlayer player11 = new FootballPlayer("Player11", 11, "Midfielder");
            FootballPlayer player12 = new FootballPlayer("Player12", 12, "Midfielder");
            FootballPlayer player13 = new FootballPlayer("Player13", 13, "Midfielder");
            FootballPlayer player14 = new FootballPlayer("Player14", 14, "Forward");
            FootballPlayer player15 = new FootballPlayer("Player15", 15, "Forward");
            FootballPlayer player16 = new FootballPlayer("Player16", 16, "Forward");

            team.AddNewPlayer(player1);
            team.AddNewPlayer(player2);
            team.AddNewPlayer(player3);
            team.AddNewPlayer(player4);
            team.AddNewPlayer(player5);
            team.AddNewPlayer(player6);
            team.AddNewPlayer(player7);
            team.AddNewPlayer(player8);
            team.AddNewPlayer(player9);
            team.AddNewPlayer(player10);
            team.AddNewPlayer(player11);
            team.AddNewPlayer(player12);
            team.AddNewPlayer(player13);
            team.AddNewPlayer(player14);
            team.AddNewPlayer(player15);
            
            string actualOutput = team.AddNewPlayer(player16);
            string expectedOutput = "No more positions available!";
           
            Assert.AreEqual(expectedOutput, actualOutput);
        }

        [Test]
        public void PickPlayerWithValidName()
        {
            FootballTeam team = new FootballTeam("Levski", 23);
            FootballPlayer player = new FootballPlayer("Nikolay Voynov", 10, "Midfielder");
            FootballPlayer player2 = new FootballPlayer("Aleksandar Voynov", 9, "Forward");

            team.AddNewPlayer(player);
            team.AddNewPlayer(player2);

            var expectedPlayer = team.PickPlayer("Nikolay Voynov");

            Assert.AreEqual(expectedPlayer, player);
        }

        [Test]
        public void PlayerScore_IncreasesStatistics()
        {
            FootballTeam team = new FootballTeam("Levski", 23);
            FootballPlayer player = new FootballPlayer("Nikolay Voynov", 10, "Midfielder");
            FootballPlayer player2 = new FootballPlayer("Aleksandar Voynov", 9, "Forward");

            team.AddNewPlayer(player);
            team.AddNewPlayer(player2);

            string actualOutput = team.PlayerScore(9);

            var expectedOutput = "Aleksandar Voynov scored and now has 1 for this season!";

            Assert.AreEqual(actualOutput, expectedOutput);
        }
    }
}