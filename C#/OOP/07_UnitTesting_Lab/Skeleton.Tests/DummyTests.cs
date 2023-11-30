using NUnit.Framework;
using System;

namespace Skeleton.Tests
{
    [TestFixture]
    public class DummyTests
    {
        [Test]
        public void DummyLoosesHealthIfAttacked()
        {
            Axe axe = new Axe(10, 85);
            Dummy dummy = new Dummy(65, 32);

            int expectedHealthDummy = 55;

            axe.Attack(dummy);

            Assert.AreEqual(expectedHealthDummy, dummy.Health);
        }

        [TestCase(0)]
        [TestCase(-40)]
        public void DeadDummyThrowsExceptionIfAttacked(int health)
        {
            Axe axe = new Axe(10, 85);
            Dummy dummy = new Dummy(health, 32);

            InvalidOperationException exception = Assert.Throws<InvalidOperationException>(() => axe.Attack(dummy));

            Assert.AreEqual("Dummy is dead.", exception.Message);


        }

        [TestCase(0)]
        [TestCase(-40)]
        public void DeadDummyCanGiveExperience(int health)
        {
            Dummy dummy = new Dummy(health, 32);

            int expectedExperienceDummy = 32;

            Assert.AreEqual(expectedExperienceDummy, dummy.GiveExperience());
        }

        [Test]
        public void AliveDummyCantGiveExperience()
        {
            Dummy dummy = new Dummy(84, 32);

            InvalidOperationException exception = Assert.Throws<InvalidOperationException>(() => dummy.GiveExperience());

            Assert.AreEqual("Target is not dead.", exception.Message);
        }
    }
}