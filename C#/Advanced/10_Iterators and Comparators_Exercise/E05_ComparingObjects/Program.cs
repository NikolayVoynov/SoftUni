using ComparingObjects;
using System;
using System.Collections.Generic;

List<Person> people = new List<Person>();

string command = Console.ReadLine();

while (command != "END")
{
    string[] token = command.Split(" ", StringSplitOptions.RemoveEmptyEntries);

    Person person = new Person()
    {
        Name = token[0],
        Age = int.Parse(token[1]),
        Town = token[2],
    };

    people.Add(person);

    command = Console.ReadLine();
}

int compareIndex = int.Parse(Console.ReadLine()) - 1;

Person personToCompare = people[compareIndex];

int equal = 0;
int different = 0;

foreach (var person in people)
{
    if (person.CompareTo(personToCompare) != 0)
    {
        different++;
    }
    else
    {
        equal++;
    }
}

if (equal == 1)
{
    Console.WriteLine("No matches");
}
else
{
    Console.WriteLine($"{equal} {different} {people.Count}");
}
