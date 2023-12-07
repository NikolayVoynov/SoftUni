using System;
using System.Collections.Generic;
using System.Linq;

Queue<int> textiles = new Queue<int>(Console.ReadLine()
    .Split(" ", StringSplitOptions.RemoveEmptyEntries)
    .Select(int.Parse));

Stack<int> medicaments = new Stack<int>(Console.ReadLine()
    .Split(" ", StringSplitOptions.RemoveEmptyEntries)
    .Select(int.Parse));

Dictionary<int, string> table = new Dictionary<int, string>()
{
    { 30, "Patch"},
    { 40, "Bandage"},
    { 100, "MedKit"}
};

Dictionary<string, int> items = new Dictionary<string, int>();

while (textiles.Any() && medicaments.Any())
{
    int textile = textiles.Peek();
    int medicament = medicaments.Peek();

    int sum = textile + medicament;

    if (table.Any(item => item.Key == sum))
    {
        if (!items.Any(item => item.Key == table[sum]))
        {
            items.Add(table[sum], 0);
        }

        items[table[sum]]++;

        textiles.Dequeue();
        medicaments.Pop();
    }
    else
    {
        if (sum > 100)
        {
            if (!items.Any(item => item.Key == "MedKit"))
            {
                items.Add("MedKit", 0);
            }

            items["MedKit"]++;

            sum -= 100;
            medicaments.Pop();
            medicaments.Push(medicaments.Pop() + sum);
            textiles.Dequeue();
        }
        else
        {
            medicaments.Push(medicaments.Pop() + 10);
            textiles.Dequeue();
        }
    }
}

if (!textiles.Any() && !medicaments.Any())
{
    Console.WriteLine("Textiles and medicaments are both empty.");
}
else if (!textiles.Any())
{
    Console.WriteLine("Textiles are empty.");
}
else
{
    Console.WriteLine("Medicaments are empty.");
}

foreach (var item in items.OrderByDescending(item => item.Value).ThenBy(itm => itm.Key))
{
    Console.WriteLine($"{item.Key} - {item.Value}");
}

if (textiles.Any())
{
    Console.WriteLine($"Textiles left: {String.Join(", ", textiles)}");
}

if (medicaments.Any())
{
    Console.WriteLine($"Medicaments left: {String.Join(", ", medicaments)}");
}
