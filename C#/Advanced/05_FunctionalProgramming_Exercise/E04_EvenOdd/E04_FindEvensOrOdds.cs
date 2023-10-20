using System;
using System.Collections.Generic;
using System.Linq;

Func<int, int, List<int>> generateRange = (start, end) =>
{
    List<int> range = new List<int>();

    for (int i = start; i <= end; i++)
    {
        range.Add(i);
    }

    return range;
};

Func<string, int, bool> matchEvenOdd = (condition, number) =>
{
    if (condition == "even")
    {
        return number % 2 == 0;
    }
    else
    {
        return number % 2 != 0;
    }
};

int[] ranges = Console.ReadLine()
    .Split(" ", StringSplitOptions.RemoveEmptyEntries)
    .Select(int.Parse)
    .ToArray();

string condition = Console.ReadLine();

int start = ranges[0];
int end = ranges[1];

List<int> range = generateRange(start, end);

foreach (var num in range)
{

    if (matchEvenOdd(condition, num))
    {
        Console.Write($"{num} ");
    }
}




