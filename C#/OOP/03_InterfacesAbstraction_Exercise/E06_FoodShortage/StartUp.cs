using FoodShortage.Model;
using FoodShortage.Model.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;

namespace FoodShortage;

public class StartUp
{
    static void Main(string[] args)
    {
        List<IBuyer> buyers = new();

        int n = int.Parse(Console.ReadLine());

        for (int i = 0; i < n; i++)
        {
            string[] token = Console.ReadLine().Split(' ', StringSplitOptions.RemoveEmptyEntries);

            if (token.Length == 4)
            {
                IBuyer citizen = new Citizen(token[0], int.Parse(token[1]), token[2], token[3]);
                buyers.Add(citizen);
            }
            else
            {
                IBuyer rebel = new Rebel(token[0], int.Parse(token[1]), token[2]);
                buyers.Add(rebel);
            }
        }

        string line = Console.ReadLine();

        while (line != "End")
        {
            buyers.FirstOrDefault(b => b.Name == line)?.BuyFood();

            line = Console.ReadLine();
        }

        Console.WriteLine(buyers.Sum(b => b.Food));
    }
}
