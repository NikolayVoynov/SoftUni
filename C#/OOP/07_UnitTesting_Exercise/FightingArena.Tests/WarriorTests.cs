namespace FightingArena.Tests
{
    using NUnit.Framework;
    using System;

    [TestFixture]
    public class WarriorTests
    {

        [Test]
        public void WarriorConstructorMustWorkCorrectly()
        {
            Warrior warrior = new Warrior("Nikolay", 14, 100);

            string expectedName = "Nikolay";
            int expectedDamage = 14;
            int expectedHp = 100;

            Assert.AreEqual(expectedName, warrior.Name);
            Assert.AreEqual(expectedDamage, warrior.Damage);
            Assert.AreEqual(expectedHp, warrior.HP);
        }

        [TestCase(" ")]
        [TestCase("       ")]
        [TestCase("                          ")]
        [TestCase(null)]
        public void WarriorConstructorMustThrowExceptionWhenNameIsNullOrWhiteSpace(string name)
        {

            ArgumentException exception = Assert.Throws<ArgumentException>(()
                => new Warrior(name, 14, 100));

            Assert.AreEqual("Name should not be empty or whitespace!", exception.Message);

        }

        [TestCase(0)]
        [TestCase(-1)]
        [TestCase(-1000)]
        public void WarriorConstructorMustThrowExceptionWhenDamageIsZeroOrNegative(int damage)
        {

            ArgumentException exception = Assert.Throws<ArgumentException>(()
                => new Warrior("Nikolay", damage, 100));

            Assert.AreEqual("Damage value should be positive!", exception.Message);
        }

        [TestCase(-1)]
        [TestCase(-1000)]
        public void WarriorConstructorMustThrowExceptionWhenHPNegative(int HP)
        {

            ArgumentException exception = Assert.Throws<ArgumentException>(()
                => new Warrior("Nikolay", 14, HP));

            Assert.AreEqual("HP should not be negative!", exception.Message);
        }

        [Test]
        public void WarriorAttackMethodMustWorkCorrectly()
        {
            Warrior attacker = new Warrior("Nikolay", 14, 100);
            Warrior defender = new Warrior("George", 21, 85);

            int expectedAttackerHp = 79;
            int expectedDefenderHp = 71;

            attacker.Attack(defender);

            Assert.AreEqual(expectedAttackerHp, attacker.HP);
            Assert.AreEqual(expectedDefenderHp, defender.HP);
        }

        [TestCase(30)]
        [TestCase(29)]
        [TestCase(5)]
        public  void IfAttackerHpIsEqualOrLessThan30MustThrowException(int HP)
        {
            Warrior attacker = new Warrior("Nikolay", 14, HP);
            Warrior defender = new Warrior("George", 21, 85);

            InvalidOperationException exception = Assert.Throws<InvalidOperationException>(()
                => attacker.Attack(defender));

            Assert.AreEqual("Your HP is too low in order to attack other warriors!", exception.Message);
        }

        [TestCase(30)]
        [TestCase(29)]
        [TestCase(5)]
        public void IfDefenderHpIsEqualOrLessThan30MustThrowException(int HP)
        {
            Warrior attacker = new Warrior("Nikolay", 14, 100);
            Warrior defender = new Warrior("George", 21, HP);

            InvalidOperationException exception = Assert.Throws<InvalidOperationException>(()
                => attacker.Attack(defender));

            Assert.AreEqual("Enemy HP must be greater than 30 in order to attack him!", exception.Message);
        }

        [Test]
        public void AttackerMustNotAttackStrongerEnemy()
        {
            Warrior attacker = new("Nikolay", 10, 35);
            Warrior defender = new("George", 45, 100);

            InvalidOperationException exception = Assert.Throws<InvalidOperationException>(()
                => attacker.Attack(defender));

            Assert.AreEqual("You are trying to attack too strong enemy", exception.Message);
        }

        [Test]
        public void EnemyHpShouldBeSetToZeroIfWarriorDamageIsGreaterThanHisHp()
        {
            Warrior attacker = new("Nikolay", 50, 100);
            Warrior defender = new("George", 45, 40);

            int expectedAttackerHp = 55;
            int expectedDefenderHp = 0;

            attacker.Attack(defender);

            Assert.AreEqual(expectedAttackerHp, attacker.HP);
            Assert.AreEqual(expectedDefenderHp, defender.HP);
        }
    }
}