using System;

Action<string[]> namesPrint = names =>
Console.WriteLine(string.Join(Environment.NewLine, names));

string[] names = Console.ReadLine()
    .Split(" ", StringSplitOptions.RemoveEmptyEntries);

namesPrint(names);