using CollectionType;
using System;
using System.Collections.Generic;
using System.Linq;

List<string> list = Console.ReadLine()
    .Split(' ', StringSplitOptions.RemoveEmptyEntries)
    .Skip(1)
    .ToList();


ListyIterator<string> listyIterator = new(list);

string command = string.Empty;

while ((command = Console.ReadLine()) != "END")
{
    switch (command)
    {
        case "Move":
            Console.WriteLine(listyIterator.Move());
            break;
        case "HasNext":
            Console.WriteLine(listyIterator.HasNext());
            break;
        case "Print":
            try
            {
                listyIterator.Print();
            }
            catch (InvalidOperationException exception)
            {
                Console.WriteLine(exception.Message);
            }

            break;
        case "PrintAll":
            foreach(var item in listyIterator)
            {
                Console.Write($"{item} ");
            }

            Console.WriteLine();
            break;
    }
}

