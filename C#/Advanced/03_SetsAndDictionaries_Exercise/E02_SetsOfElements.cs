using System;
using System.Collections.Generic;

int[] input = Console.ReadLine()
    .Split(" ", StringSplitOptions.RemoveEmptyEntries)
    .Select(int.Parse)
    .ToArray();

int n = input[0];
int m = input[1];

HashSet<int> first = new HashSet<int>();
HashSet<int> second = new HashSet<int>();

for (int i = 0; i < n; i++)
{
    int number = int.Parse(Console.ReadLine());
    first.Add(number);
}

for (int i = 0; i < m; i++)
{
    int number = int.Parse(Console.ReadLine());
    second.Add(number);
}

first.IntersectWith(second);

Console.WriteLine(string.Join(" ", first));

