using System;
using System.Collections.Generic;
using System.Linq;

Queue<int> times = new Queue<int>(Console.ReadLine()
    .Split(" ", StringSplitOptions.RemoveEmptyEntries)
    .Select(int.Parse));

Stack<int> tasks = new Stack<int>(Console.ReadLine()
    .Split(" ", StringSplitOptions.RemoveEmptyEntries)
    .Select(int.Parse));

Dictionary<string, int> numberDucksByType = new Dictionary<string, int>()
{
    {"Darth Vader Ducky", 0 },
    {"Thor Ducky", 0 },
    {"Big Blue Rubber Ducky", 0 },
    {"Small Yellow Rubber Ducky", 0 }
};

while (times.Any() && tasks.Any())
{
    int result = times.Peek() * tasks.Peek();

    if ((result >= 0) && (result <= 240))
    {
        if ((result >= 0) && (result <= 60))
        {
            numberDucksByType["Darth Vader Ducky"]++;
        }
        else if ((result >= 61) && (result <= 120))
        {
            numberDucksByType["Thor Ducky"]++;
        }
        else if ((result >= 121) && (result <= 180))
        {
            numberDucksByType["Big Blue Rubber Ducky"]++;
        }
        else if ((result >= 181) && (result <= 240))
        {
            numberDucksByType["Small Yellow Rubber Ducky"]++;
        }

        times.Dequeue();
        tasks.Pop();
    }
    else
    {
        int task = tasks.Pop() - 2;
        tasks.Push(task);

        int time = times.Dequeue();
        times.Enqueue(time);
    }
}

Console.WriteLine("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
foreach (var duck in numberDucksByType)
{
    Console.WriteLine($"{duck.Key}: {duck.Value}");
}

