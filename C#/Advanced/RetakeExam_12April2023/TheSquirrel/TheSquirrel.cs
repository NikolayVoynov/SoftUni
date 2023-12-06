using System;
using System.Collections.Generic;
using System.Linq;

int size = int.Parse(Console.ReadLine());
Queue<string> commands = new(Console.ReadLine().Split(", ", StringSplitOptions.RemoveEmptyEntries));

string[,] matrix = new string[size, size];

int sRow = -1;
int sCol = -1;

for (int r = 0; r < matrix.GetLength(0); r++)
{
    string currentRow = Console.ReadLine();

    for (int c = 0; c < matrix.GetLength(1); c++)
    {
        if (currentRow[c].ToString() == "s")
        {
            sRow = r;
            sCol = c;
            matrix[r, c] = "*";
        }

        matrix[r, c] = currentRow[c].ToString();
    }
}

int hazelnuts = 0;
bool isTrappedOrOut = false;

while (commands.Any() && hazelnuts < 3)
{
    string direction = commands.Dequeue();

    if (isOutOfBounds(direction, sRow, sCol, matrix) || isATrap(direction, sRow, sCol, matrix))
    {
        break;
    }

    switch (direction)
    {
        case "left":
            sCol--;
            break;
        case "right":
            sCol++;
            break;
        case "up":
            sRow--;
            break;
        case "down":
            sRow++;
            break;
    }

    if (matrix[sRow, sCol] == "h")
    {
        hazelnuts++;
        matrix[sRow, sCol] = "*";
    }
}

if (!isTrappedOrOut)
{
    if (hazelnuts == 3)
    {
        Console.WriteLine("Good job! You have collected all hazelnuts!");
    }
    else
    {
        Console.WriteLine("There are more hazelnuts to collect.");
    }
}

Console.WriteLine($"Hazelnuts collected: {hazelnuts}");

bool isATrap(string direction, int sRow, int sCol, string[,] matrix)
{
    switch (direction)
    {
        case "left":
            sCol--;
            break;
        case "right":
            sCol++;
            break;
        case "up":
            sRow--;
            break;
        case "down":
            sRow++;
            break;
    }

    if (matrix[sRow, sCol] == "t")
    {
        Console.WriteLine("Unfortunately, the squirrel stepped on a trap...");
        isTrappedOrOut = true;
        return true;
    }

    return false;
}

bool isOutOfBounds(string direction, int sRow, int sCol, string[,] matrix)
{
    if (direction == "left" && sCol == 0 ||
        direction == "right" && sCol == matrix.GetLength(1) - 1 ||
        direction == "up" && sRow == 0 ||
        direction == "down" && sRow == matrix.GetLength(0) - 1)
    {
        Console.WriteLine("The squirrel is out of the field.");
        isTrappedOrOut = true;
        return true;
    }

    return false;
}