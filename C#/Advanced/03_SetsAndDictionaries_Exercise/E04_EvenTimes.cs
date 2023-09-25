int n = int.Parse(Console.ReadLine());

Dictionary<int, int> numAppear = new Dictionary<int, int>();

for (int i = 0; i < n; i++)
{
    int number = int.Parse(Console.ReadLine());

    if (!numAppear.ContainsKey(number))
    {
        numAppear.Add(number, 0);
    }

    numAppear[number]++;
}

foreach (var entry in numAppear)
{
    if (entry.Value % 2 == 0)
    {
        Console.WriteLine(entry.Key);
    }
}

