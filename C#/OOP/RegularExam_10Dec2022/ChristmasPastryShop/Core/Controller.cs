﻿using ChristmasPastryShop.Core.Contracts;
using ChristmasPastryShop.Models.Booths;
using ChristmasPastryShop.Models.Booths.Contracts;
using ChristmasPastryShop.Models.Cocktails;
using ChristmasPastryShop.Models.Cocktails.Contracts;
using ChristmasPastryShop.Models.Delicacies;
using ChristmasPastryShop.Models.Delicacies.Contracts;
using ChristmasPastryShop.Repositories;
using ChristmasPastryShop.Repositories.Contracts;
using ChristmasPastryShop.Utilities.Messages;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ChristmasPastryShop.Core
{
    public class Controller : IController
    {
        private IRepository<IBooth> booths;

        public Controller()
        {
            this.booths = new BoothRepository();
        }
        public string AddBooth(int capacity)
        {
            int boothId = this.booths.Models.Count + 1;

            IBooth newBooth = new Booth(boothId, capacity);
            this.booths.AddModel(newBooth);

            return string.Format(OutputMessages.NewBoothAdded, boothId, capacity);
        }

        public string AddCocktail(int boothId, string cocktailTypeName, string cocktailName, string size)
        {
            if (cocktailTypeName != nameof(Hibernation) && cocktailTypeName != nameof(MulledWine))
            {
                return string.Format(OutputMessages.InvalidCocktailType, cocktailTypeName);
            }

            if (size != "Large" && size != "Middle" && size != "Small")
            {
                return string.Format(OutputMessages.InvalidCocktailSize, size);
            }

            if (this.booths.Models.Any(b => b.CocktailMenu.Models.Any(c => c.Name == cocktailName && c.Size == size)))
            {
                return string.Format(OutputMessages.CocktailAlreadyAdded, size, cocktailName);
            }

            ICocktail cocktail;
            if (cocktailTypeName == nameof(Hibernation))
            {
                cocktail = new Hibernation(cocktailName, size);
            }
            else
            {
                cocktail = new MulledWine(cocktailName, size);
            }

            IBooth booth = this.booths.Models.FirstOrDefault(b => b.BoothId == boothId);
            booth.CocktailMenu.AddModel(cocktail);

            return string.Format(OutputMessages.NewCocktailAdded, size, cocktailName, cocktailTypeName);
        }

        public string AddDelicacy(int boothId, string delicacyTypeName, string delicacyName)
        {
            if (delicacyTypeName != nameof(Gingerbread) && delicacyTypeName != nameof(Stolen))
            {
                return string.Format(OutputMessages.InvalidDelicacyType, delicacyTypeName);
            }

            if (this.booths.Models.Any(b => b.DelicacyMenu.Models.Any(d => d.Name == delicacyName)))
            {
                return string.Format(OutputMessages.DelicacyAlreadyAdded, delicacyName);
            }

            IDelicacy delicacy;
            if (delicacyTypeName == nameof(Gingerbread))
            {
                delicacy = new Gingerbread(delicacyName);
            }
            else
            {
                delicacy = new Stolen(delicacyName);
            }

            IBooth booth = this.booths.Models.FirstOrDefault(b => b.BoothId == boothId);
            booth.DelicacyMenu.AddModel(delicacy);

            return string.Format(OutputMessages.NewDelicacyAdded, delicacyTypeName, delicacyName);
        }

        public string BoothReport(int boothId)
        {
            return this.booths.Models.FirstOrDefault(b => b.BoothId == boothId).ToString().TrimEnd();
        }

        public string LeaveBooth(int boothId)
        {
            IBooth booth = this.booths.Models.FirstOrDefault(b => b.BoothId == boothId);

            StringBuilder sb = new StringBuilder();
            sb.AppendLine($"Bill {booth.CurrentBill:f2} lv");

            booth.Charge();
            booth.ChangeStatus();
            
            sb.AppendLine($"Booth {boothId} is now available!");

            return sb.ToString().TrimEnd();
        }

        public string ReserveBooth(int countOfPeople)
        {
            IBooth booth = this.booths.Models
                .Where(b => b.IsReserved == false && b.Capacity >= countOfPeople)
                .OrderBy(b => b.Capacity)
                .OrderByDescending(b => b.BoothId)
                .FirstOrDefault();

            if (booth == null)
            {
                return string.Format(OutputMessages.NoAvailableBooth, countOfPeople);
            }

            booth.ChangeStatus();
            return string.Format(OutputMessages.BoothReservedSuccessfully, booth.BoothId, countOfPeople);

        }

        public string TryOrder(int boothId, string order)
        {
            IBooth booth = this.booths.Models.FirstOrDefault(b => b.BoothId == boothId);

            string[] orderParamArr = order.Split('/');

            string itemTypeName = orderParamArr[0];

            if (itemTypeName != nameof(Hibernation) &&
                itemTypeName != nameof(MulledWine) &&
                itemTypeName != nameof(Gingerbread) &&
                itemTypeName != nameof(Stolen))
            {
                return string.Format(OutputMessages.NotRecognizedType, itemTypeName);
            }

            string itemName = orderParamArr[1];

            if (!booth.CocktailMenu.Models.Any(c => c.Name == itemName) &&
                !booth.DelicacyMenu.Models.Any(d => d.Name == itemName))
            {
                return string.Format(OutputMessages.NotRecognizedItemName, itemTypeName, itemName);
            }

            int countOfOrderedPieces = int.Parse(orderParamArr[2]);

            if (itemTypeName == nameof(MulledWine) || itemTypeName == nameof(Hibernation))
            {
                string size = orderParamArr[3];

                ICocktail desiredCocktail = booth
                    .CocktailMenu.Models
                    .FirstOrDefault(c => c.GetType().Name == itemTypeName && c.Name == itemName && c.Size == size);

                if (desiredCocktail == null)
                {
                    return string.Format(OutputMessages.CocktailStillNotAdded, size, itemName);
                }

                booth.UpdateCurrentBill(desiredCocktail.Price * countOfOrderedPieces);
                return string.Format(OutputMessages.SuccessfullyOrdered, boothId, countOfOrderedPieces, itemName);
            }
            else
            {
                IDelicacy desiredDelicacy = booth
                    .DelicacyMenu.Models
                    .FirstOrDefault(d=>d.GetType().Name == itemTypeName && d.Name == itemName);

                if (desiredDelicacy == null)
                {
                    return string.Format(OutputMessages.DelicacyStillNotAdded,itemTypeName, itemName);
                }

                booth.UpdateCurrentBill(desiredDelicacy.Price * countOfOrderedPieces);
                return string.Format(OutputMessages.SuccessfullyOrdered, boothId, countOfOrderedPieces, itemName);
            }
        }
    }
}
