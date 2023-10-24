using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DefiningClasses;

public class StartUp
{

    static void Main(string[] args)
    {
        List<Person> peopleOver30 = new List<Person>();

        int n = int.Parse(Console.ReadLine());

        for (int i = 0; i < n; i++)
        {
            string[] input = Console.ReadLine().Split(' ');

            string name = input[0];
            int age = int.Parse(input[1]);

            if (age > 30)
            {
                Person person = new Person(name, age);
                peopleOver30.Add(person);
            }
        }

        List<Person> orderedPeople = peopleOver30.OrderBy(p => p.Name).ToList();

        foreach (Person person in orderedPeople)
        {
            Console.WriteLine($"{person.Name} - {person.Age}");
        }


    }

}
