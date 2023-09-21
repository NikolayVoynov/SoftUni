SortedDictionary<string, Dictionary<string, double>> productShop = new SortedDictionary<string, Dictionary<string, double>>(); 

string command = Console.ReadLine();

while(command != "Revision")
{
    string[] input = command.Split(", ");
    string shop = input[0];
    string product = input[1];
    double price = double.Parse(input[2]);

    if (!productShop.ContainsKey(shop))
    {
        productShop.Add(shop, new Dictionary<string, double>());
    }

    productShop[shop].Add(product, price);

    command = Console.ReadLine();
}


foreach(var entry in productShop)
{
    Console.WriteLine($"{entry.Key}->");

    foreach(var product in entry.Value)
    {
        Console.WriteLine($"Product: {product.Key}, Price: {product.Value}");
    }
}
