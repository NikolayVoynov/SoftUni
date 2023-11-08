
using PizzaCalories.Model;
using System;

try
{
    string[] pizzaToken = Console.ReadLine()
        .Split(" ", StringSplitOptions.RemoveEmptyEntries);

    string[] doughToken = Console.ReadLine()
        .Split(" ", StringSplitOptions.RemoveEmptyEntries);

    Dough dough = new Dough(doughToken[1], doughToken[2], double.Parse(doughToken[3]));

    Pizza pizza = new Pizza(pizzaToken[1], dough);

    string input = Console.ReadLine();

    while (input != "END")
    {
        string[] toppingToken = input.Split(" ");

        Topping topping = new Topping(toppingToken[1], double.Parse(toppingToken[2]));

        pizza.AddTopping(topping);

        input = Console.ReadLine();
    }

    Console.WriteLine(pizza.ToString());
}
catch (Exception ex)
{
    Console.WriteLine(ex.Message);
}