int n = int.Parse(Console.ReadLine());

Dictionary<String, Dictionary<String, List<string>>> citiesByContinentAndCountries = new Dictionary<string, Dictionary<string, List<string>>>();


for (int i = 0; i < n; i++)
{
    string[] input = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries);

    string continent = input[0];
    string country = input[1];
    string city = input[2];

    if (!citiesByContinentAndCountries.ContainsKey(continent))
    {
        citiesByContinentAndCountries[continent] = new Dictionary<string, List<string>>();
    }
    

    if (!citiesByContinentAndCountries[continent].ContainsKey(country))
    {
        citiesByContinentAndCountries[continent][country] = new List<string>();
    }

    citiesByContinentAndCountries[continent][country].Add(city);
}

foreach(var entity in citiesByContinentAndCountries)
{
    Console.WriteLine($"{entity.Key}:");

    foreach (var countryCity in entity.Value)
    {
        Console.WriteLine($" {countryCity.Key} -> {String.Join(", ", countryCity.Value)}");
    }
}