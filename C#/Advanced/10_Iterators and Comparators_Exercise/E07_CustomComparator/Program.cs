﻿using System;
using System.Collections.Generic;
using System.Linq;


int[] numbers = Console.ReadLine()
    .Split(" ", StringSplitOptions.RemoveEmptyEntries)
    .Select(int.Parse)
    .ToArray();


public class CustomComparator : IComparer<int>
{
    public int Compare(int x, int y)
    {
        if (x % 2 == 0 && y % 2 != 0)
        {
            return -1;
        }

        if (x % 2 != 0 && y % 2 == 0)
        {
            return 1;
        }

        return x.CompareTo(y);
    }
}