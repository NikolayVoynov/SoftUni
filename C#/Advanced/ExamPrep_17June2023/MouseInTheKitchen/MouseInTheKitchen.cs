using System;
using System.Linq;

int[] dimensions = Console.ReadLine()
    .Split(",", StringSplitOptions.RemoveEmptyEntries)
    .Select(int.Parse).ToArray();

int rows = dimensions[0];
int cols = dimensions[1];

char[,] cupboard = new char[rows, cols];

int mouseRow = 0;
int mouseCol = 0;
int cheeseAmount = 0;

for (int r = 0; r < rows; r++)
{
    string currentRow = Console.ReadLine();

    for (int c = 0; c < cols; c++)
    {
        cupboard[r, c] = currentRow[c];

        if (currentRow[c] == 'M')
        {
            mouseRow = r;
            mouseCol = c;
            cupboard[mouseRow, mouseCol] = '*';
        }

        if (currentRow[c] == 'C')
        {
            cheeseAmount++;
        }
    }
}

string command;

while ((command = Console.ReadLine()) != "danger")
{
    if (command == "left")
    {
        if (mouseCol == 0)
        {
            Console.WriteLine("No more cheese for tonight!");
            break;
        }

        if (cupboard[mouseRow, mouseCol - 1] == '@')
        {
            continue;
        }

        mouseCol--;
    }

    else if (command == "right")
    {
        if (mouseCol == cols - 1)
        {
            Console.WriteLine("No more cheese for tonight!");
            break;
        }

        if (cupboard[mouseRow, mouseCol + 1] == '@')
        {
            continue;
        }

        mouseCol++;
    }

    else if (command == "up")
    {
        if (mouseRow == 0)
        {
            Console.WriteLine("No more cheese for tonight!");
            break;
        }

        if (cupboard[mouseRow - 1, mouseCol] == '@')
        {
            continue;
        }

        mouseRow--;
    }

    else if (command == "down")
    {
        if (mouseRow == rows - 1)
        {
            Console.WriteLine("No more cheese for tonight!");
            break;
        }

        if (cupboard[mouseRow + 1, mouseCol] == '@')
        {
            continue;
        }

        mouseRow++;
    }

    if (cupboard[mouseRow, mouseCol] == 'C')
    {
        cheeseAmount--;
        cupboard[mouseRow, mouseCol] = '*';

        if (cheeseAmount == 0)
        {
            Console.WriteLine("Happy mouse! All the cheese is eaten, good night!");
            break;
        }

        //continue;
    }

    if (cupboard[mouseRow, mouseCol] == 'T')
    {
        Console.WriteLine("Mouse is trapped!");
        break;
    }
}

if (command == "danger")
{
    Console.WriteLine("Mouse will come back later!");
}

cupboard[mouseRow, mouseCol] = 'M';

for(int r = 0; r < rows; r++)
{
    for(int c = 0; c < cols; c++)
    {
        Console.Write(cupboard[r,c]);
    }
    Console.WriteLine();
}
