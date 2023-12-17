namespace SmartDevice.Tests
{
    using NUnit.Framework;
    using System;
    using System.Text;

    public class Tests
    {
        private Device device;
        private int memoryCapacity = 1000;
        private int photoSize = 100;
        private int appSize = 350;
        private string appName = "Uber";
        private string appName2 = "Uber2";

        [SetUp]
        public void Setup()
        {
            device = new Device(memoryCapacity);
        }

        [Test]
        public void ConstructorTestWorksCorrectly()
        {
            Assert.AreEqual(memoryCapacity, device.MemoryCapacity);
            Assert.AreEqual(memoryCapacity, device.AvailableMemory);
            Assert.AreEqual(0, device.Photos);
            Assert.AreEqual(0, device.Applications.Count);
        }

        [Test]
        public void TakePhotoMethodReturnTrue()
        {
            bool result = device.TakePhoto(photoSize);
            Assert.AreEqual(memoryCapacity, device.MemoryCapacity);
            Assert.AreEqual(memoryCapacity - photoSize, device.AvailableMemory);
            Assert.AreEqual(1, device.Photos);
            Assert.AreEqual(true, result);
        }

        [Test]
        public void TakePhotoMethodReturnFalse()
        {
            bool result = device.TakePhoto(photoSize + 2000);
            Assert.AreEqual(memoryCapacity, device.MemoryCapacity);
            Assert.AreEqual(memoryCapacity, device.AvailableMemory);
            Assert.AreEqual(0, device.Photos);
            Assert.AreEqual(false, result);
        }

        [Test]
        public void InstallAppWorksCorrectly()
        {
            string result = device.InstallApp(appName, appSize);
            string expectedResult = $"{appName} is installed successfully. Run application?";

            Assert.AreEqual(memoryCapacity, device.MemoryCapacity);
            Assert.AreEqual(memoryCapacity - appSize, device.AvailableMemory);
            Assert.AreEqual(true, device.Applications.Contains(appName));
            Assert.AreEqual(1, device.Applications.Count);
            Assert.AreEqual(expectedResult, result);
        }

        [Test]
        public void InstallAppWorksThrowsException()
        {
            Assert.Throws<InvalidOperationException>(() =>
            {
                device.InstallApp(appName, appSize + 2000);
            });
        }

        [Test]
        public void FormatMethodWorksCorrectly()
        {
            device.InstallApp(appName, appSize);
            device.TakePhoto(photoSize);

            device.FormatDevice();

            Assert.AreEqual(memoryCapacity, device.MemoryCapacity);
            Assert.AreEqual(memoryCapacity, device.AvailableMemory);
            Assert.AreEqual(0, device.Photos);
            Assert.AreEqual(0, device.Applications.Count);
        }

        [Test]
        public void GetDeviceStatusMethodWorksCorrectly()
        {
            device.InstallApp(appName, appSize);
            device.InstallApp(appName2, appSize);
            device.TakePhoto(photoSize);

            string result = device.GetDeviceStatus();

            StringBuilder sb = new StringBuilder();
            sb.AppendLine($"Memory Capacity: {memoryCapacity} MB, Available Memory: {memoryCapacity - appSize - appSize - photoSize} MB");
            sb.AppendLine("Photos Count: 1");
            sb.AppendLine("Applications Installed: Uber, Uber2");

            string expected = sb.ToString().TrimEnd();

            Assert.AreEqual(expected,result);
        }
    }
}