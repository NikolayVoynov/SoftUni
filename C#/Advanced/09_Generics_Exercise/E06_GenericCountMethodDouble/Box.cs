using System;
using System.Collections.Generic;
using System.Text;

namespace GenericCountMethodDouble;

public class Box<T> where T : IComparable<T>
{
    private List<T> items;

    public Box()
    {
        items = new List<T>();
    }

    public void Add(T item)
    {
        items.Add(item);
    }

    public override string ToString()
    {
        StringBuilder sb = new();

        foreach (T item in items)
        {
            sb.AppendLine($"{typeof(T)}: {item}");
        }

        return sb.ToString().TrimEnd();
    }

    public int Count(T itemToCompare)
    {
        int count = 0;

        foreach (var item in items)
        {
            if (item.CompareTo(itemToCompare) > 0)
            {
                count++;
            }
        }

        return count;
    }
}


