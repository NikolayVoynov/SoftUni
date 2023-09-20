using System;
using System.Linq;

int rows = int.Parse(Console.ReadLine());

int[][] jaggedArray = new int[rows][];

for (int row = 0; row < rows; row++)
{
    int[] input = Console.ReadLine()
        .Split(" ", StringSplitOptions.RemoveEmptyEntries)
        .Select(int.Parse)
        .ToArray();

    jaggedArray[row] = input;
}

for (int row = 0; row < rows - 1; row++)
{
    if (jaggedArray[row].Length == jaggedArray[row + 1].Length)
    {
        for (int col = 0; col < jaggedArray[row].Length; col++)
        {
            jaggedArray[row][col] *= 2;
            jaggedArray[row + 1][col] *= 2;
        }
    }
    else
    {
        for (int col = 0; col < jaggedArray[row].Length; col++)
        {
            jaggedArray[row][col] /= 2;
        }
        for (int col = 0; col < jaggedArray[row + 1].Length; col++)
        {
            jaggedArray[row + 1][col] /= 2;
        }
    }
}

string commandInfo = Console.ReadLine();

while (commandInfo != "End")
{
    string[] splitCommand = commandInfo.Split(" ", StringSplitOptions.RemoveEmptyEntries).ToArray();

    string command = splitCommand[0];
    int row = int.Parse(splitCommand[1]);
    int col = int.Parse(splitCommand[2]);
    int value = int.Parse(splitCommand[3]);

    bool areValidIndeces = row >= 0 && col >= 0 && row < jaggedArray.Length && col < jaggedArray[row].Length;

    if (areValidIndeces)
    {
        if (command == "Add")
        {
            jaggedArray[row][col] += value;
        }
        else if (command == "Subtract")
        {
            jaggedArray[row][col] -= value;
        }
    }

    commandInfo = Console.ReadLine();
}

for (int row = 0; row < rows; row++)
{
    for (int col = 0; col < jaggedArray[row].Length; col++)
    {
        Console.Write($"{jaggedArray[row][col]} ");
    }

    Console.WriteLine();
}

