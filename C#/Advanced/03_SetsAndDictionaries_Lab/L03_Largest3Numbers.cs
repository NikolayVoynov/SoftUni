List<int> numbers = Console.ReadLine()
    .Split(" ", StringSplitOptions.RemoveEmptyEntries)
    .Select(int.Parse)
    .OrderByDescending(n => n)
    .Take(3)
    .ToList();

Console.WriteLine(String.Join(" ", numbers));
