namespace DatabaseExtended.Tests
{
    using ExtendedDatabase;
    using NUnit.Framework;
    using System;

    [TestFixture]
    public class ExtendedDatabaseTests
    {
        private Database database;

        [SetUp]
        public void SetUp()
        {
            Person[] persons =
            {
                new Person(1, "usnm1"),
                new Person(2, "usnm2"),
                new Person(3, "usnm3"),
                new Person(4, "usnm4"),
                new Person(5, "usnm5"),
                new Person(6, "usnm6"),
                new Person(7, "usnm7"),
                new Person(8, "usnm8"),
                new Person(9, "usnm9"),
                new Person(10, "usnm10"),
                new Person(11, "UsNm2")
            };

            database = new Database(persons);
        }

        [Test]
        public void DatabaseMethodCountMustWorkCorrectly()
        {
            int expectedResult = 11;
            int actualResult = database.Count;

            Assert.AreEqual(expectedResult, actualResult);
        }

        [Test]
        public void DatabaseCreatingMustThrowExceptionWhenCountMoreThan16()
        {
            Person[] persons =
            {
                new Person(1, "usnm1"),
                new Person(2, "usnm2"),
                new Person(3, "usnm3"),
                new Person(4, "usnm4"),
                new Person(5, "usnm5"),
                new Person(6, "usnm6"),
                new Person(7, "usnm7"),
                new Person(8, "usnm8"),
                new Person(9, "usnm9"),
                new Person(10, "usnm10"),
                new Person(11, "usnm11"),
                new Person(12, "usnm12"),
                new Person(13, "usnm13"),
                new Person(14, "usnm14"),
                new Person(15, "usnm15"),
                new Person(16, "usnm16"),
                new Person(17, "usnm17")
            };

            ArgumentException exception = Assert.Throws<ArgumentException>(()
            => database = new Database(persons));

            Assert.AreEqual("Provided data length should be in range [0..16]!", exception.Message);
        }

        [Test]
        public void DatabaseAddMethodMustWorkCorrectly()
        {
            Person person = new Person(12, "usm12");

            database.Add(person);

            int expectedResult = 12;

            Assert.AreEqual(expectedResult, database.Count);
        }

        [Test]
        public void DatabaseAddMethodMustThrowExceptionWhenCountMoreThan16()
        {
            
            Person person1 = new Person(12, "usnm12");
            Person person2 = new Person(13, "usnm13");
            Person person3 = new Person(14, "usnm14");
            Person person4 = new Person(15, "usnm15");
            Person person5 = new Person(16, "usnm16");

            database.Add(person1);
            database.Add(person2);
            database.Add(person3);
            database.Add(person4);
            database.Add(person5);

            InvalidOperationException exception = Assert.Throws<InvalidOperationException>(()
            => database.Add(new Person(17, "usnm17")));

            Assert.AreEqual("Array's capacity must be exactly 16 integers!", exception.Message);
        }

        [Test]
        public void DatabaseAddMethodMustThrowExceptionWhenPersonWithSameNameIsAdded()
        {

            InvalidOperationException exception = Assert.Throws<InvalidOperationException>(()
            => database.Add(new Person(11, "usnm10")));

            Assert.AreEqual("There is already user with this username!", exception.Message);
        }

        [Test]
        public void DatabaseAddMethodMustThrowExceptionWhenPersonWithSameId()
        {

            InvalidOperationException exception = Assert.Throws<InvalidOperationException>(()
            => database.Add(new Person(10, "usnm12")));

            Assert.AreEqual("There is already user with this Id!", exception.Message);
        }

        [Test]
        public void DatabaseRemoveMethodMustWorkCorrectly()
        {
            int expectedResult = 10;
            database.Remove();

            Assert.AreEqual(expectedResult, database.Count);
        }

        [Test]
        public void DatabaseRemoveMethodMustThrowExceptionIfDatabaseIsEmpty()
        {
            Database database = new Database();

            Assert.Throws<InvalidOperationException>(() => database.Remove());
        }

        [Test]
        public void DatabaseMethodFindByUserNameMustWorkCorrectly()
        {
            string expectedResult = "usnm2";
            string actualResult = database.FindByUsername("usnm2").UserName;

            Assert.AreEqual(expectedResult, actualResult);
        }

        [Test]
        [TestCase("")]
        [TestCase(null)]
        public void DatabaseMethodFindByUserNameMustThrowExceptionWhenInputNullOrEmpty(string input)
        {
            ArgumentNullException exception = Assert.Throws<ArgumentNullException>(()
                => database.FindByUsername(input));

            Assert.AreEqual("Username parameter is null!", exception.ParamName);
        }

        [Test]
        [TestCase("Nikolay")]
        public void DatabaseMethodFindByUserNameMustThrowExceptionWhenInputIsNotFound(string input)
        {
            InvalidOperationException exception = Assert.Throws<InvalidOperationException>(()
                => database.FindByUsername(input));

            Assert.AreEqual("No user is present by this username!", exception.Message);
        }

        [Test]
        public void DatabaseFindByUsernameMethodShouldBeCaseSensitive()
        {
            string expectedResult = "UsNm2";
            string actualResult = database.FindByUsername("usnm2").UserName;

            Assert.AreNotEqual(expectedResult, actualResult);
        }

        [Test]
        public void DatabaseFindByIdMethodMustWorkCorrectly()
        {
            string expectedResult = "usnm4";
            string actualResult = database.FindById(4).UserName;

            Assert.AreEqual(expectedResult,actualResult);
        }

        [Test]
        public void DatabaseFindByIdMethodMustThrowExceptionIfIdIsNegative()
        {
            ArgumentOutOfRangeException exception = Assert.Throws<ArgumentOutOfRangeException>(() 
                => database.FindById(-1));
            
            Assert.AreEqual("Id should be a positive number!", exception.ParamName);
        }

        [Test]
        public void DatabaseFindByIdMethodShouldThrowExceptionIfIdIsNotFound()
        {
            InvalidOperationException exception = Assert.Throws<InvalidOperationException>(()
                => database.FindById(25));

            Assert.AreEqual("No user is present by this ID!", exception.Message);
        }


    }
}