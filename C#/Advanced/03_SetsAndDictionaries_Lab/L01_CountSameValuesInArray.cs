List<double> numbers = Console.ReadLine()
                       .Split(" ", StringSplitOptions.RemoveEmptyEntries)
                       .Select(double.Parse)
                       .ToList();

Dictionary<double, int> countOccurrences = new Dictionary<double, int>();

foreach (double number in numbers)
{
    if(!countOccurrences.ContainsKey(number))
    {
        countOccurrences.Add(number, 1);
    }
    else
    {
        countOccurrences[number]++;
    }
}


foreach (var entry in countOccurrences)
{
    Console.WriteLine($"{entry.Key} - {entry.Value} times");
}