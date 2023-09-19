int[] matrixDimensions = Console.ReadLine().Split(", ").Select(int.Parse).ToArray();

int rows = matrixDimensions[0];
int cols = matrixDimensions[1];

int[,] matrix = new int[rows, cols];

for (int r = 0; r < rows; r++)
{
    int[] row = Console.ReadLine().Split(", ").Select(int.Parse).ToArray();

    for (int c = 0; c < cols; c++)
    {
        matrix[r, c] = row[c];
    }
}

int sum = 0;

for (int r = 0; r < rows; r++)
{
    for (int c = 0; c < cols; c++)
    {
        sum += matrix[r, c];
    }
}

Console.WriteLine(rows);
Console.WriteLine(cols);
Console.WriteLine(sum);
