using System;
using System.Collections.Generic;
using System.Linq;

string[] dimensions = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries);

int n = int.Parse(dimensions[0]);
int m = int.Parse(dimensions[1]);

string[,] playground = new string[n, m];

int bRow = -1;
int bCol = -1;

int moves = 0;
int touchedOpponets = 0;

for (int r = 0; r < n; r++)
{
    string[] currentRow = Console.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries);

    for (int c = 0; c < m; c++)
    {
        playground[r, c] = currentRow[c].ToString();
        if (playground[r, c] == "B")
        {
            bRow = r;
            bCol = c;
            playground[r, c] = "-";
        }
    }
}

string direction;

while ((direction = Console.ReadLine()) != "Finish")
{
    if ((direction == "left" && bCol == 0) ||
        (direction == "right" && bCol == playground.GetLength(1) - 1) ||
            (direction == "up" && bRow == 0) ||
        (direction == "down" && bRow == playground.GetLength(0) - 1))
    {
        continue;
    }

    switch (direction)
    {
        case "left":
            if (playground[bRow, bCol - 1] == "O")
            {
                continue;
            }
            break;
        case "right":
            if (playground[bRow, bCol + 1] == "O")
            {
                continue;
            }
            break;
        case "up":
            if (playground[bRow - 1, bCol] == "O")
            {
                continue;
            }
            break;
        case "down":
            if (playground[bRow + 1, bCol] == "O")
            {
                continue;
            }
            break;
    }

    moves++;
    switch (direction)
    {
        case "left":
            bCol--;
            break;
        case "right":
            bCol++;
            break;
        case "up":
            bRow--;
            break;
        case "down":
            bRow++;
            break;
    }

    if (playground[bRow, bCol] == "P")
    {
        touchedOpponets++;
        playground[bRow, bCol] = "-";

        if (touchedOpponets == 3)
        {
            break;
        }
    }
}

Console.WriteLine("Game over!");
Console.WriteLine($"Touched opponents: {touchedOpponets} Moves made: {moves}");
