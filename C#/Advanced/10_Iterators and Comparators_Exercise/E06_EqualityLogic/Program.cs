
using EqualityLogic;
using System;
using System.Collections.Generic;

HashSet<Person> hashSet = new();
SortedSet<Person> sortedSet = new();

int count = int.Parse(Console.ReadLine());

for (int i = 0; i < count; i++)
{
    string[] input = Console.ReadLine().Split(' ');

    Person person = new Person()
    {
        Name = input[0],
        Age = int.Parse(input[1])
    };

    hashSet.Add(person);
    sortedSet.Add(person); 
}

Console.WriteLine(hashSet.Count);
Console.WriteLine(sortedSet.Count);