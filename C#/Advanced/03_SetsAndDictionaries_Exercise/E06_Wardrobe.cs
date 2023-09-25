using System;
using System.Collections.Generic;

int n = int.Parse(Console.ReadLine());

Dictionary<string, Dictionary<string, int>> wardrobe = new Dictionary<string, Dictionary<string, int>>();

for (int i = 0; i < n; i++)
{
    string[] input = Console.ReadLine().Split(new string[] { " -> ", "," }, StringSplitOptions.RemoveEmptyEntries);

    string color = input[0];

    if (!wardrobe.ContainsKey(color))
    {
        wardrobe.Add(color, new Dictionary<string, int>());
    }

    for (int j = 1; j < input.Length; j++)
    {
        if (!wardrobe[color].ContainsKey(input[j]))
        {
            wardrobe[color].Add(input[j], 0);
        }

        wardrobe[color][input[j]]++;
    }
}

string[] lookingFor = Console.ReadLine().Split(" ");

string colorLookingFor = lookingFor[0];
string itemLookingFor = lookingFor[1];

foreach (var entry in wardrobe)
{
    Console.WriteLine($"{entry.Key} clothes:");

    foreach (var item in wardrobe[entry.Key])
    {
        string printItem = $"* {item.Key} - {item.Value}";

        if (entry.Key == lookingFor[0] && item.Key == lookingFor[1])
        {
            printItem += " (found!)";
        }

        Console.WriteLine(printItem);
    }
}
