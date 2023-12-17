using ChristmasPastryShop.Models.Delicacies.Contracts;
using ChristmasPastryShop.Utilities.Messages;
using System;
using System.Collections.Generic;
using System.Text;

namespace ChristmasPastryShop.Models.Delicacies
{
    public abstract class Delicacy : IDelicacy
    {
        private string delicacyName;
        private double price;

        protected Delicacy(string delicacyName, double price)
        {
            Name = delicacyName;
            Price = price;
        }

        public string Name
        {
            get { return delicacyName; }
            private set 
            {
                if (String.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentException(ExceptionMessages.NameNullOrWhitespace);
                }

                delicacyName = value; 
            }
        }

        public double Price 
        { 
            get { return price; } 
            private set {  price = value; } 
        }

        public override string ToString()
        {
            return $"{Name} - {Price:f2} lv";
        }
    }
}
