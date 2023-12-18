namespace Railway.Tests
{
    using NUnit.Framework;
    using System;
    using System.Linq;
    using System.Collections.Generic;
    public class Tests
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void CreateStationWithCorrectParams()
        {
            RailwayStation railwayStation = new RailwayStation("Ovcha Kupel");

            Type tA = railwayStation.ArrivalTrains.GetType();
            Type tD = railwayStation.DepartureTrains.GetType();
            Type expectedType = typeof(Queue<string>);

            Assert.AreEqual("Ovcha Kupel", railwayStation.Name);
            Assert.AreEqual(expectedType, tA);
            Assert.AreEqual(expectedType, tD);
        }

        [Test]
        public void CreateStationWithNullName()
        {
            Assert.Throws<ArgumentException>(() => { RailwayStation railwayStation = new RailwayStation(null); });
        }

        [Test]
        public void CreateStationWithWhitespaceName()
        {
            Assert.Throws<ArgumentException>(() => { RailwayStation railwayStation = new RailwayStation(""); });
        }

        [Test]
        public void NewArrivalOnBoardWorksCorrectly()
        {
            RailwayStation railwayStation = new RailwayStation("Ovcha Kupel");
            railwayStation.NewArrivalOnBoard("OK-GB");

            Assert.AreEqual(railwayStation.ArrivalTrains.Count, 1);
        }

        [Test]
        public void CheckMessage_ThereAreOtherTrainsToArriveBefore()
        {
            RailwayStation railwayStation = new RailwayStation("Ovcha Kupel");
            railwayStation.NewArrivalOnBoard("OK-GB");
            railwayStation.NewArrivalOnBoard("GB-Lyulin");
            railwayStation.NewArrivalOnBoard("Lyulin-Poduyane");

            string expectedMessage = "There are other trains to arrive before GB-Lyulin.";

            Assert.AreEqual(expectedMessage, railwayStation.TrainHasArrived("GB-Lyulin"));
        }

        [Test]
        public void CheckMessage_IsOnThePlatformAndWillLeaveIn5Minutes()
        {
            RailwayStation railwayStation = new RailwayStation("Ovcha Kupel");
            railwayStation.NewArrivalOnBoard("OK-GB");
            railwayStation.NewArrivalOnBoard("GB-Lyulin");
            railwayStation.NewArrivalOnBoard("Lyulin-Poduyane");

            string expectedMessage = "OK-GB is on the platform and will leave in 5 minutes.";

            Assert.AreEqual(expectedMessage, railwayStation.TrainHasArrived("OK-GB"));
        }

        [Test]
        public void TrainHasLeftMustReturnTrue()
        {
            RailwayStation railwayStation = new RailwayStation("Ovcha Kupel");
            railwayStation.NewArrivalOnBoard("OK-GB");
            railwayStation.NewArrivalOnBoard("GB-Lyulin");
            railwayStation.NewArrivalOnBoard("Lyulin-Poduyane");

            railwayStation.TrainHasArrived("OK-GB");

            Assert.AreEqual(true, railwayStation.TrainHasLeft("OK-GB"));
        }

        [Test]
        public void TrainHasLeftMustReturnFalse()
        {
            RailwayStation railwayStation = new RailwayStation("Ovcha Kupel");
            railwayStation.NewArrivalOnBoard("OK-GB");
            railwayStation.NewArrivalOnBoard("GB-Lyulin");
            railwayStation.NewArrivalOnBoard("Lyulin-Poduyane");

            railwayStation.TrainHasArrived("OK-GB");

            Assert.AreEqual(false, railwayStation.TrainHasLeft("Lyulin-Poduyane"));
        }

        [Test]
        public void Validate_Method_TrainHasLeft_TrainDequeued()
        {
            RailwayStation station = new RailwayStation("Ovcha Kupel");

            station.NewArrivalOnBoard("OK-GB");
            station.TrainHasArrived("OK-GB");

            Assert.That(station.DepartureTrains.Count == 1);

            station.TrainHasLeft("OK-GB");

            Assert.That(station.DepartureTrains.Count == 0);
        }
    }
}