namespace FightingArena.Tests
{
    using NUnit.Framework;
    using System;
    using System.Linq;

    [TestFixture]
    public class ArenaTests
    {

        private Arena arena;

        [SetUp]
        public void SetUp()
        { 
            arena = new Arena();
        }

        [Test]
        public void ArenaConstructorMustWorkCorrectly()
        {
            Assert.NotNull(arena);
            Assert.NotNull(arena.Warriors);
        }

        [Test]
        public void ArenaCountMethodMustWorkCorrectly()
        {
            int expectedCount = 3;
            Warrior warrior1 = new Warrior("Nikolay", 10, 20);
            Warrior warrior2 = new Warrior("Dimitar", 15, 50);
            Warrior warrior3 = new Warrior("Martin", 5, 30);

            arena.Enroll(warrior1);
            arena.Enroll(warrior2);
            arena.Enroll(warrior3);

            Assert.AreEqual(expectedCount, arena.Count);
        }

        [Test]
        public void ArenaEnrollMethodMustWorkCorrectly()
        {
            Warrior warrior1 = new Warrior("Nikolay", 10, 20);
            arena.Enroll(warrior1);

            Assert.IsNotEmpty(arena.Warriors);
            Assert.AreEqual(warrior1, arena.Warriors.Single());
        }

        [Test]
        public void ArenaEnrollMethodMustThrowException()
        {
            Warrior warrior1 = new Warrior("Nikolay", 10, 20);
            arena.Enroll(warrior1);

            InvalidOperationException exception = Assert.Throws<InvalidOperationException>(() 
                => arena.Enroll(warrior1));

            Assert.AreEqual("Warrior is already enrolled for the fights!", exception.Message);
        }


    }
}
