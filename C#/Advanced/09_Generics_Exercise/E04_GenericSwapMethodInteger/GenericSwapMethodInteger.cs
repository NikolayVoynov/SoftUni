using System;
using System.Collections.Generic;
using System.Linq;

List<int> items = new();

int count = int.Parse(Console.ReadLine());

for (int i = 0; i < count; i++)
{
    int item = int.Parse(Console.ReadLine());

    items.Add(item);
}

int[] indices = Console.ReadLine()
    .Split(' ', StringSplitOptions.RemoveEmptyEntries)
    .Select(int.Parse)
    .ToArray();

Swap(indices[0], indices[1], items);

static void Swap<T>(int firstIndex, int secondIndex, List<T> items)
{
    (items[firstIndex], items[secondIndex]) = (items[secondIndex], items[firstIndex]);
}

foreach (int item in items)
{
    Console.WriteLine($"{typeof(int)}: {item}");
}

