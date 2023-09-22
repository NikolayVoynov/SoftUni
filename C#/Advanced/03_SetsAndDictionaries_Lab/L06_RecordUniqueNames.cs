int n = int.Parse(Console.ReadLine());

HashSet<string> result = new HashSet<string>();

for (int i = 0; i < n; i++)
{
    string name = Console.ReadLine();

    result.Add(name);
}


foreach (string name in result)
{
    Console.WriteLine(name);
}