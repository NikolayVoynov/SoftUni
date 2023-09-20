int[] dimensions = Console.ReadLine()
    .Split(" ", StringSplitOptions.RemoveEmptyEntries)
    .Select(int.Parse)
    .ToArray();

int rows = dimensions[0];
int cols = dimensions[1];

char[,] matrix = new char[rows, cols];

for (int row = 0; row < rows; row++)
{
    char[] symbols = Console.ReadLine()
        .Split(" ", StringSplitOptions.RemoveEmptyEntries)
        .Select(char.Parse)
        .ToArray();

    for (int col = 0; col < cols; col++)
    {
        matrix[row, col] = symbols[col];
    }
}

int countSquaresOfEqualChars = 0;

for (int row = 0; row < rows - 1; row++)
{
    for (int col = 0; col < cols - 1; col++)
    {
        char symbol = matrix[row, col];

        bool rightIsEqual = symbol == matrix[row, col + 1];
        bool downIsEqual = symbol == matrix[row + 1, col];
        bool diagonalIsEqual = symbol == matrix[row + 1, col + 1];

        if (rightIsEqual && downIsEqual && diagonalIsEqual)
        {
            countSquaresOfEqualChars++;
        }
    }
}

Console.WriteLine(countSquaresOfEqualChars);




