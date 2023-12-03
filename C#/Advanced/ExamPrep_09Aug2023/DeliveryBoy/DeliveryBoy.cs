using System;
using System.Linq;

int[] dimensions = Console.ReadLine()
    .Split(" ", StringSplitOptions.RemoveEmptyEntries)
    .Select(int.Parse)
    .ToArray();

int rows = dimensions[0];
int cols = dimensions[1];

char[,] field = new char[rows, cols];

int initRowBoy = 0;
int initColBoy = 0;
int rowBoy = 0;
int colBoy = 0;

bool isOutsideTheField = false;

for (int r = 0; r < rows; r++)
{
    string currentRow = Console.ReadLine();
    for (int c = 0; c < cols; c++)
    {
        if (currentRow[c] == 'B')
        {
            rowBoy = r;
            colBoy = c;
            initRowBoy = r;
            initColBoy = c;
        }

        field[r, c] = currentRow[c];
    }
}

while (true)
{
    string command = Console.ReadLine();

    if (command == "left")
    {
        if (colBoy - 1 < 0)
        {
            Console.WriteLine("The delivery is late. Order is canceled.");

            isOutsideTheField = true;

            break;
        }

        if (field[rowBoy, colBoy - 1] == '*')
        {
            continue;
        }

        if (field[rowBoy, colBoy - 1] == '-' || field[rowBoy, colBoy - 1] == '.')
        {
            field[rowBoy, colBoy - 1] = '.';
        }

        colBoy--;
    }
    else if (command == "right")
    {
        if (colBoy + 1 >= cols)
        {
            Console.WriteLine("The delivery is late. Order is canceled.");

            isOutsideTheField = true;

            break;
        }

        if (field[rowBoy, colBoy + 1] == '*')
        {
            continue;
        }

        if (field[rowBoy, colBoy + 1] == '-' || field[rowBoy, colBoy + 1] == '.')
        {
            field[rowBoy, colBoy + 1] = '.';
        }

        colBoy++;
    }
    else if (command == "up")
    {
        if (rowBoy - 1 < 0)
        {
            Console.WriteLine("The delivery is late. Order is canceled.");

            isOutsideTheField = true;

            break;
        }

        if (field[rowBoy - 1, colBoy] == '*')
        {
            continue;
        }

        if (field[rowBoy - 1, colBoy] == '-' || field[rowBoy - 1, colBoy] == '.')
        {
            field[rowBoy - 1, colBoy] = '.';
        }

        rowBoy--;
    }
    else if (command == "down")
    {
        if (rowBoy + 1 >= rows)
        {
            Console.WriteLine("The delivery is late. Order is canceled.");

            isOutsideTheField = true;

            break;
        }

        if (field[rowBoy + 1, colBoy] == '*')
        {
            continue;
        }

        if (field[rowBoy + 1, colBoy] == '-' || field[rowBoy + 1, colBoy] == '.')
        {
            field[rowBoy + 1, colBoy] = '.';
        }

        rowBoy++;
    }

    if (field[rowBoy, colBoy] == 'P')
    {
        Console.WriteLine("Pizza is collected. 10 minutes for delivery.");

        field[rowBoy, colBoy] = 'R';

        continue;
    }

    if (field[rowBoy, colBoy] == 'A')
    {
        Console.WriteLine("Pizza is delivered on time! Next order...");

        field[rowBoy, colBoy] = 'P';

        break;
    }
}

if (isOutsideTheField)
{
    field[initRowBoy, initColBoy] = ' ';
}
else
{
    field[initRowBoy, initColBoy] = 'B';
}

for (int r = 0; r < rows; r++)
{
    for (int c = 0; c < cols; c++)
    {
        Console.Write(field[r, c]);
    }

    Console.WriteLine();
}