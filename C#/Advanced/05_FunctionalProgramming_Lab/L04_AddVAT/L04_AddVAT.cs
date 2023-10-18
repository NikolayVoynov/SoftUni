double[] pricesVAT = Console.ReadLine()
    .Split(new string[] { ", " }, StringSplitOptions.RemoveEmptyEntries)
    .Select(n => double.Parse(n))
    .Select(n => n * 1.2)
    .ToArray();


foreach (var price in pricesVAT)
{
    Console.WriteLine(price);
}

