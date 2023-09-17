int n = int.Parse(Console.ReadLine());
Stack<int> stack = new Stack<int>();

for (int i = 0; i < n; i++)
{
    int[] commandInfo = Console.ReadLine().Split().Select(int.Parse).ToArray();

    int command = commandInfo[0];

    if(command == 1)
    {
        stack.Push(commandInfo[1]);
    }
    else if(command == 2)
    {
        stack.Pop();
    }
    else if(command == 3)
    {
        Console.WriteLine(stack.Max());
    }
    else if (command == 4)
    {
        Console.WriteLine(stack.Min());
    }
}

Console.WriteLine(string.Join(", ", stack));