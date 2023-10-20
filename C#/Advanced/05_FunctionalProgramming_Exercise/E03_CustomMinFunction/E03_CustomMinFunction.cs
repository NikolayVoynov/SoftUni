using System;

Func<HashSet<int>, int> min = numbers =>
{
    int minNum = int.MaxValue;

    foreach (int num in numbers)
    {
        if (num < minNum) 
        { 
          minNum = num;
        }
    }

    return minNum;
};

HashSet<int> numbers = Console.ReadLine()
    .Split(" ", StringSplitOptions.RemoveEmptyEntries)
    .Select(int.Parse)
    .ToHashSet();

Console.WriteLine(min(numbers));
