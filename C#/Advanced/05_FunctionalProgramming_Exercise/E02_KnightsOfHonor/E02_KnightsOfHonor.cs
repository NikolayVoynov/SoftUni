using System;

Action<string, string[]> printNamesAndTitles = (title, names) =>
{
    foreach (var name in names)
    {
        Console.WriteLine($"{title} {name}");
    }
};

string[] names = Console.ReadLine()
    .Split(" ", StringSplitOptions.RemoveEmptyEntries);

printNamesAndTitles("Sir", names);
