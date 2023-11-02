using Froggy;
using System;
using System.Collections.Generic;
using System.Linq;

List<int> stones = Console.ReadLine()
    .Split(", ", StringSplitOptions.RemoveEmptyEntries)
    .Select(int.Parse)
    .ToList();

Lake lake = new Lake(stones);

Console.WriteLine(String.Join(", ",lake));