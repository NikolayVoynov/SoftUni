int size = int.Parse(Console.ReadLine());

int[,] matrix = new int[size,size];

for (int row = 0; row < size; row++)
{
    int[] rowValues = Console.ReadLine().Split().Select(int.Parse).ToArray();
    for (int col = 0; col < size; col++)
    {
        matrix[row, col] = rowValues[col];
    }
}

int sumDiagonal = 0;

for (int i = 0; i < size; i++)
{
    sumDiagonal += matrix[i,i];
}

Console.WriteLine(sumDiagonal);
