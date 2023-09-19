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

string commandInfo = Console.ReadLine();

while (commandInfo != "END")
{
    if (isValidCommand(commandInfo, rows, cols))
    {

        string[] splittedCommand = commandInfo.Split(" ");
        int row1 = int.Parse(splittedCommand[1]); 
        int col1 = int.Parse(splittedCommand[2]); 
        int row2 = int.Parse(splittedCommand[3]); 
        int col2 = int.Parse(splittedCommand[4]);

        int firstElement = matrix[row1, col1];
        int secondElement = matrix[row2, col2];

        matrix[row1, col1] = secondElement;
        matrix[row2, col2] = firstElement;

        printMatrix(matrix);
    }
    else
    {
        Console.WriteLine("Invalid input!");
    }

    commandInfo = Console.ReadLine();
}

void printMatrix(int[,] matrix)
{

    //matrix.GetLength(0) -> брой на редовете на матрица
    //matrix.GetLength(1) -> брой на колоните на матрица

    for (int row = 0; row < matrix.GetLength(0); row++)
    {
        for (int col = 0; col < matrix.GetLength(1); col++)
        {
            Console.Write(matrix[row, col] + " ");
        }

        Console.WriteLine();
    }
}

bool isValidCommand(string commandInfo, int rows, int cols)
{
    string[] splitCommandInfo = commandInfo.Split(' ');

    bool isValidCommandName = splitCommandInfo[0] == "swap";
    bool isValidCountElements = splitCommandInfo.Length == 5;

    bool isValidRowsAndCols = false;

    if(isValidCommandName && isValidCountElements)
    {
        int row1 = int.Parse(splitCommandInfo[1]); 
        int col1 = int.Parse(splitCommandInfo[2]); 
        int row2 = int.Parse(splitCommandInfo[3]); 
        int col2 = int.Parse(splitCommandInfo[4]); 

        isValidRowsAndCols = row1 >= 0 && row1 < rows
                                && col1 >= 0 && col1 < cols
                                && row2 >= 0 && row2 < rows
                                && col2 >= 0 && col2 < cols;
    }

    return isValidCommandName && isValidCountElements && isValidRowsAndCols;
}