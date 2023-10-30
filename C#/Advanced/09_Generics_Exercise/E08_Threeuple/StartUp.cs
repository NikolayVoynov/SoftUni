using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tuple;

public class StartUp
{
    static void Main(string[] args)
    {
        string[] personTokens = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries);
        string[] drinkTokens = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries);
        string[] numberTokens = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries);

        CustomTuple<string, string> nameAddress = new($"{personTokens[0]} {personTokens[1]}", personTokens[2]);

        CustomTuple<string, int> nameBeer = new(drinkTokens[0], int.Parse(drinkTokens[1]));

        CustomTuple<int, double> numbers = new(int.Parse(numberTokens[0]), double.Parse(numberTokens[1]));

        Console.WriteLine(nameAddress);
        Console.WriteLine(nameBeer);
        Console.WriteLine(numbers);
    }
}
