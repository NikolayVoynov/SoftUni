Func<List<int>, List<int>> reverse = numbers =>
{
    List<int> result = new List<int>();

    for (int i = numbers.Count -1; i >= 0; i--)
    {
        result.Add(numbers[i]);
    }

    return result;
};

Func<List<int>, Predicate<int>, List<int>> devideAndExclude = (numbers, predicate) =>
{
    List<int> result = new List<int>();

    foreach (int num in numbers)
    {
        if (!predicate(num))
        {
            result.Add(num);
        }
    }

    return result;
};

List<int> numbers = Console.ReadLine()
    .Split(" ", StringSplitOptions.RemoveEmptyEntries)
    .Select(int.Parse)
    .ToList();

int divider = int.Parse(Console.ReadLine());

Predicate<int> predicate = num =>
num % divider == 0;

numbers = devideAndExclude(numbers, predicate);
numbers = reverse(numbers);

Console.WriteLine(string.Join(" ", numbers));


