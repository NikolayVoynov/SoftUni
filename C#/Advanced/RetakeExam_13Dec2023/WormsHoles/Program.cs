using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

Stack<int> worms = new Stack<int>(Console.ReadLine()
    .Split(" ")
    .Select(int.Parse));

Queue<int> holes = new Queue<int>(Console.ReadLine()
    .Split(" ")
    .Select(int.Parse));

int matches = 0;
bool notAllFit = false;


while (worms.Any() && holes.Any())
{
    int worm = worms.Peek();
    int hole = holes.Peek();

    if (worm == hole)
    {
        matches++;
        worm = worms.Pop();
        hole = holes.Dequeue();
    }
    else
    {
        notAllFit = true;
        
        hole = holes.Dequeue();

        worm = worms.Pop();
        int newWorm = worm - 3;

        if (newWorm > 0)
        {
            worms.Push(newWorm);
        }
    }
}

if(matches > 0)
{
    Console.WriteLine($"Matches: {matches}");
}
else
{
    Console.WriteLine("There are no matches.");
}


if (notAllFit && !worms.Any())
{
    Console.WriteLine("Worms left: none");
}
else if(!notAllFit && !worms.Any())
{
    Console.WriteLine("Every worm found a suitable hole!");
}
else
{
    Console.WriteLine($"Worms left: {String.Join(", ", worms)}");
}

if (!holes.Any())
{
    Console.WriteLine("Holes left: none");
}
else
{
    Console.WriteLine($"Holes left: {String.Join(", ", holes)}");
}