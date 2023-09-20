int n = int.Parse(Console.ReadLine());

int[,] matrix = new int[n, n];

for (int row = 0; row < n; row++)
{
    int[] numbers = Console.ReadLine()
        .Split(" ", StringSplitOptions.RemoveEmptyEntries)
        .Select(n => int.Parse(n))
        .ToArray();

    for (int col = 0; col < n; col++)
    {
        matrix[row, col] = numbers[col];
    }
}

int primaryDiagonal = 0;
int secondaryDiagonal = 0;

for (int i = 0; i < n; i++)
{
    primaryDiagonal += matrix[i, i];
    secondaryDiagonal += matrix[i, n - 1 - i];
}

Console.WriteLine(Math.Abs(primaryDiagonal - secondaryDiagonal));
