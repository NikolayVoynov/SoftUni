int[] dimensions = Console.ReadLine()
    .Split(" ", StringSplitOptions.RemoveEmptyEntries)
    .Select(int.Parse)
    .ToArray();

int rows = dimensions[0];
int cols = dimensions[1];

int[,] matrix = new int[rows, cols];

for (int row = 0; row < rows; row++)
{
    int[] numbers = Console.ReadLine()
        .Split(" ", StringSplitOptions.RemoveEmptyEntries)
        .Select(int.Parse)
        .ToArray();

    for (int col = 0; col < cols; col++)
    {
        matrix[row, col] = numbers[col];
    }
}

int maxSum = 0;
int maxStartRow = 0;
int maxStartCol = 0;

for (int row = 0; row < rows - 2; row++)
{
    for (int col = 0; col < cols - 2; col++)
    {
        int currentMaxSum = calculateCurrentSquareSum(row, col);

        if (currentMaxSum > maxSum)
        {
            maxSum = currentMaxSum;
            maxStartRow = row;
            maxStartCol = col;
        }

    }
}

Console.WriteLine($"Sum = {maxSum}");

for (int row = maxStartRow; row <= maxStartRow + 2; row++)
{
    for (int col = maxStartCol; col <= maxStartCol + 2; col++)
    {
        Console.Write(matrix[row, col] + " ");
    }

    Console.WriteLine();
}

int calculateCurrentSquareSum(int row, int col)
{
    int sum = 0;

    for (int r = row; r <= row + 2; r++)
    {
        for (int c = col; c <= col + 2; c++)
        {
            sum += matrix[r, c];
        }
    }

    return sum;
}
