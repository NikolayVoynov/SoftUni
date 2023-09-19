int rows = int.Parse(Console.ReadLine());

int[][] matrix = new int[rows][];

for (int r = 0; r < rows; r++)
{
    int[] rowValues = Console.ReadLine().Split().Select(int.Parse).ToArray();
    matrix[r] = rowValues;
}

string command = Console.ReadLine().ToLower();

while (command != "end")
{
    string[] input = command.Split();
    int row = int.Parse(input[1]);
    int col = int.Parse(input[2]);
    int value = int.Parse(input[3]);

    if (row < 0 || col < 0 || row >= matrix.Length || col >= matrix[row].Length)
    {
        Console.WriteLine("Invalid coordinates");
    }
    else
    {
        if (input[0] == "add")
        {
            matrix[row][col] += value;
        }

        else
        {
            matrix[row][col] -= value;
        }
    }

    command = Console.ReadLine().ToLower();
}


for (int r = 0; r < matrix.Length; r++)
{
    for (int c = 0; c < matrix[r].Length; c++)
    {
        Console.Write($"{matrix[r][c]} ");
    }

    Console.WriteLine();
}
