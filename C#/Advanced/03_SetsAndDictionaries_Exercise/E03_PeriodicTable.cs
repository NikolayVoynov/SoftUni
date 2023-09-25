int n = int.Parse(Console.ReadLine());

SortedSet<string> elements = new SortedSet<string>();

for (int i = 0; i < n; i++)
{
    string[] inputArr = Console.ReadLine()
        .Split(" ", StringSplitOptions.RemoveEmptyEntries);

    elements.UnionWith(inputArr);
}

Console.WriteLine(String.Join(" ", elements));

