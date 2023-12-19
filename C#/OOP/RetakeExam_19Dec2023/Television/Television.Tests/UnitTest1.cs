namespace Television.Tests
{
    using System;
    using System.Diagnostics;
    using NUnit.Framework;
    public class Tests
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void ConstructorWorksCorrectly()
        {
            TelevisionDevice tv = new TelevisionDevice("Sony", 750.00, 120, 60);

            Assert.AreEqual("Sony", tv.Brand);
            Assert.AreEqual(750.00, tv.Price);
            Assert.AreEqual(120, tv.ScreenWidth);
            Assert.AreEqual(60, tv.ScreenHeigth);
        }

        [Test]
        public void SwitchOnTest()
        {
            TelevisionDevice tv = new TelevisionDevice("Sony", 750.00, 120, 60);
            string expected = "Cahnnel 0 - Volume 13 - Sound On";
            Assert.AreEqual(expected,tv.SwitchOn());

        }

        [Test]
        public void ChangeChannelThrowException()
        {
            TelevisionDevice tv = new TelevisionDevice("Sony", 750.00, 120, 60);

            Assert.Throws<ArgumentException>(()=>tv.ChangeChannel(-10));
        }

        [Test]
        public void ChangeChannelWorksCorrectly()
        {
            TelevisionDevice tv = new TelevisionDevice("Sony", 750.00, 120, 60);

            Assert.AreEqual(10,tv.ChangeChannel(10));
        }

        [Test]
        public void VolumeChangeUPTest()
        {
            TelevisionDevice tv = new TelevisionDevice("Sony", 750.00, 120, 60);
            string expected = "Volume: 23";
            Assert.AreEqual(expected, tv.VolumeChange("UP", 10));
        }

        [Test]
        public void VolumeChangeUPWhenOver100Test()
        {
            TelevisionDevice tv = new TelevisionDevice("Sony", 750.00, 120, 60);
            string expected = "Volume: 100";
            Assert.AreEqual(expected, tv.VolumeChange("UP", 100));
        }

        [Test]
        public void VolumeChangeDOWNTest()
        {
            TelevisionDevice tv = new TelevisionDevice("Sony", 750.00, 120, 60);
            string expected = "Volume: 10";
            Assert.AreEqual(expected, tv.VolumeChange("DOWN", 3));
        }

        [Test]
        public void VolumeChangeDOWNWhenUnderZeroTest()
        {
            TelevisionDevice tv = new TelevisionDevice("Sony", 750.00, 120, 60);
            string expected = "Volume: 0";
            Assert.AreEqual(expected, tv.VolumeChange("DOWN", 45));
        }

        [Test]
        public void ToStringMethodTest()
        {
            TelevisionDevice tv = new TelevisionDevice("Sony", 750.00, 120, 60);
            string expected = $"TV Device: Sony, Screen Resolution: 120x60, Price 750$";
            Assert.AreEqual(expected, tv.ToString());
        }

        [Test]
        public void MuteDeviceChangeToTrue()
        {
            TelevisionDevice tv = new TelevisionDevice("Sony", 750.00, 120, 60);

            Assert.AreEqual(true, tv.MuteDevice());
        }

   }
}