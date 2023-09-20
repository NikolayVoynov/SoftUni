int size = int.Parse(Console.ReadLine());

if (size < 3)
{
    Console.WriteLine(0);
    return;
}

char[,] matrix = new char[size, size];

for (int row = 0; row < size; row++)
{
    char[] symbols = Console.ReadLine().ToArray();

    for (int col = 0; col < size; col++)
    {
        matrix[row, col] = symbols[col];
    }
}

int countMinimumRemoved = 0;

while (true)
{

    int maxAttack = 0;
    int maxRow = 0;
    int maxCol = 0;

    for (int row = 0; row < size; row++)
    {
        for (int col = 0; col < size; col++)
        {
            char currentElement = matrix[row, col];
            if (currentElement == 'K')
            {
                int countAttackedKnights = calculateAttackedKnights(row, col, size, matrix);

                if (countAttackedKnights > maxAttack)
                {
                    maxAttack = countAttackedKnights;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }
    }

    if (maxAttack == 0)
    {
        break;
    }
    else
    {
        matrix[maxRow, maxCol] = '0';
        countMinimumRemoved++;
    }
}

Console.WriteLine(countMinimumRemoved);


int calculateAttackedKnights(int row, int col, int size, char[,] matrix)
{
    int count = 0;

    if (isValid(row - 2, col - 1, size))
    {
        if (matrix[row - 2, col - 1] == 'K')
        {
            count++;
        }
    }

    if (isValid(row - 2, col + 1, size))
    {
        if (matrix[row - 2, col + 1] == 'K')
        {
            count++;
        }
    }

    if (isValid(row - 1, col + 2, size))
    {
        if (matrix[row - 1, col + 2] == 'K')
        {
            count++;
        }
    }

    if (isValid(row + 1, col + 2, size))
    {
        if (matrix[row + 1, col + 2] == 'K')
        {
            count++;
        }
    }

    if (isValid(row + 2, col + 1, size))
    {
        if (matrix[row + 2, col + 1] == 'K')
        {
            count++;
        }
    }

    if (isValid(row + 2, col - 1, size))
    {
        if (matrix[row + 2, col - 1] == 'K')
        {
            count++;
        }
    }

    if (isValid(row - 1, col - 2, size))
    {
        if (matrix[row - 1, col - 2] == 'K')
        {
            count++;
        }
    }

    if (isValid(row - 1, col - 2, size))
    {
        if (matrix[row - 1, col - 2] == 'K')
        {
            count++;
        }
    }

    return count;
}

bool isValid(int row, int col, int size)
{
    return row >= 0 && col >= 0 && row < size && col < size;
}