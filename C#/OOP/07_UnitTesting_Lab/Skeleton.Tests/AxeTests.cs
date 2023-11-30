using NUnit.Framework;
using System;

namespace Skeleton.Tests
{
    [TestFixture]
    public class AxeTests
    {
        [Test]
        public void AxeLoosesDurabilityAfterAttack()
        {
            Axe axe = new Axe(10,10);
            Dummy dummy = new Dummy(10, 10);

            axe.Attack(dummy);

            Assert.That(axe.DurabilityPoints, Is.EqualTo(9), "Axe Durability doesn't change after attack.");
        }

        [Test]
        public void AttackingWithBrokenWeaponThrowsException()
        {
            Axe axe = new Axe(10, -10);
            Dummy dummy = new Dummy(10, 10);

            InvalidOperationException exception = Assert.Throws<InvalidOperationException>(() => axe.Attack(dummy));

            Assert.AreEqual("Axe is broken.", exception.Message);
        }
    }
}