using System;
using System.Collections.Generic;

string word = Console.ReadLine();

SortedDictionary<char, int> letterOccurrences = new SortedDictionary<char, int>();

foreach (var letter in word)
{
    if (!letterOccurrences.ContainsKey(letter))
    {
        letterOccurrences.Add(letter, 0);
    }

    letterOccurrences[letter]++;
}

foreach (var entry in letterOccurrences)
{
    Console.WriteLine($"{entry.Key}: {entry.Value} time/s");
}

