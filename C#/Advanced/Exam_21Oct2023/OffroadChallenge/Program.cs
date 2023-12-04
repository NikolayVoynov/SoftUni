using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

Stack<int> initialFuel = new Stack<int>(Console.ReadLine()
    .Split(" ", StringSplitOptions.RemoveEmptyEntries)
    .Select(int.Parse));

Queue<int> additionalConsumption = new Queue<int>(Console.ReadLine()
    .Split(" ", StringSplitOptions.RemoveEmptyEntries)
    .Select(int.Parse));

Queue<int> amountFuelNeeded = new Queue<int>(Console.ReadLine()
    .Split(" ", StringSplitOptions.RemoveEmptyEntries)
    .Select(int.Parse));

List<string> altitudes = new List<string>();
int altitude = 0;
bool proceed = true;

while (amountFuelNeeded.Any() && proceed)
{
    int fuel = initialFuel.Pop();
    int consumption = additionalConsumption.Dequeue();

    int result = fuel - consumption;

    int neededFuel = amountFuelNeeded.Dequeue();

    if (result < neededFuel)
    {
        altitude++;

        Console.WriteLine($"John did not reach: Altitude {altitude}");
        proceed = false;
    }
    else if (result >= neededFuel)
    {
        altitude++;
        altitudes.Add($"Altitude {altitude}");
        Console.WriteLine($"John has reached: Altitude {altitude}");
    }
}

StringBuilder sb = new StringBuilder();

if (amountFuelNeeded.Count == 0)
{
    sb.AppendLine("John has reached all the altitudes and managed to reach the top!");
}
else if (amountFuelNeeded.Count > 0 && altitudes.Count > 0)
{
    sb.AppendLine("John failed to reach the top.");
    sb.AppendLine($"Reached altitudes: {String.Join(", ", altitudes)}");
}
else
{
    sb.AppendLine("John failed to reach the top.");
    sb.AppendLine($"John didn't reach any altitude.");
}

Console.WriteLine(sb.ToString());