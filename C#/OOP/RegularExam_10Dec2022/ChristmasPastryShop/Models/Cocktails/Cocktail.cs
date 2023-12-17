using ChristmasPastryShop.Models.Cocktails.Contracts;
using ChristmasPastryShop.Utilities.Messages;
using System;
using System.Collections.Generic;
using System.Text;

namespace ChristmasPastryShop.Models.Cocktails
{
    public abstract class Cocktail : ICocktail
    {
        private string cocktailName;
        private string size;
        private double price;

        protected Cocktail(string cocktailName, string size, double price)
        {
            Name = cocktailName;
            Size = size;
            Price = price;
        }

        public string Name
        {
            get { return cocktailName; }
            private set
            {
                if (String.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentException(ExceptionMessages.NameNullOrWhitespace);
                }

                cocktailName = value;
            }
        }

        public string Size { get; private set; }

        public double Price
        {
            get { return price; }
            private set
            {
                switch (this.Size)
                {
                    case "Large":
                        price = value;
                        break;
                    case "Middle":
                        price = (2 * value) / 3;
                        break;
                    case "Small":
                        price = value / 3;
                        break;
                }
            }
        }

        public override string ToString()
        {
            return $"{Name} ({Size}) - {Price:f2} lv";
        }
    }
}
