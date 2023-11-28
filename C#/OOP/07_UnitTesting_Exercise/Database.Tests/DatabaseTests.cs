namespace Database.Tests
{
    using NUnit.Framework;
    using System;

    [TestFixture]
    public class DatabaseTests
    {
        private Database database;

        [SetUp]
        public void SetUp()
        {
            database = new Database(1, 2);
        }

        [Test]
        public void CreatedDatabaseCountMustBeCorrect()
        {
            int expectedResult = 2;
            int actualResult = database.Count;

            Assert.NotNull(database);
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestCase(new int[] { 1, 2, 3, 4, 5, 6 })]
        [TestCase(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 })]
        public void CreatingDatabaseMustAddElementsCorrectly(int[] data)
        {
            database = new Database(data);
            int[] actualResult = database.Fetch();

            Assert.AreEqual(data, actualResult);
        }

        [TestCase(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 })]
        [TestCase(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 })]
        public void CreatingDatabaseMustThrowExceptionWhenCountMoreThan16(int[] data)
        {
            InvalidOperationException exception = Assert.Throws<InvalidOperationException>(()
                => database = new Database(data));

            Assert.AreEqual("Array's capacity must be exactly 16 integers!", exception.Message);
        }

        [Test]
        public void DatabaseCountShouldWorkCorrectly()
        {
            int expectedResult = 2;
            int actualResult = database.Count;

            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestCase(-20)]
        [TestCase(4)]
        public void DatabaseAddMethodMustIncreaseCountCorrectly(int element)
        {
            int expectedResult = 3;
            database.Add(element);
            Assert.AreEqual(expectedResult, database.Count);
        }

        [TestCase(new int[] { 1, 2, 3, 4, 5 })]
        public void DatabaseMustAddElementsCorrectly(int[] elements)
        {
            database = new Database();

            foreach (int element in elements)
            {
                database.Add(element);
            }

            int[] actualResult = database.Fetch();

            Assert.AreEqual(elements, actualResult);
        }

        [Test]
        public void DatabaseAddMethodMustThrowExceptionWhenCountIsMoreThan16()
        {
            for (int i = 0; i < 14; i++)
            {
                database.Add(i);
            }

            InvalidOperationException exception = Assert.Throws<InvalidOperationException>(()
                => database.Add(15), "Array's capacity must be exactly 16 integers!");

            Assert.AreEqual(exception.Message, "Array's capacity must be exactly 16 integers!");
        }

        [Test]
        public  void DatabaseRemoveMethodMustThrowExceptionWhenDatabaseIsEmpty()
        {
            database.Remove();
            database.Remove();

            InvalidOperationException exception = Assert.Throws<InvalidOperationException>(()
                => database.Remove());

            Assert.AreEqual("The collection is empty!", exception.Message);
        }

        [Test]
        public void DatabaseRemoveMethodMustDecreaseCount()
        {
            int expectedResult = 1;

            database.Remove();

            Assert.AreEqual(expectedResult, database.Count);
        }

        [Test]
        public void DatabaseRemoveMethodMustRemoveElementsCorrectly()
        {
            int[] expectedResult = new int[] { };

            database.Remove();
            database.Remove();

            int[] actualResult = database.Fetch();

            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestCase(new int[] { 1, 2, 3, 4, 5 })]
        public void DatabaseFetchMethodMustReturnCorrectCollection(int[] data)
        {
            database = new Database(data);
            int[] actualResult = database.Fetch();

            Assert.AreEqual(data, actualResult);
        }
    }
}
