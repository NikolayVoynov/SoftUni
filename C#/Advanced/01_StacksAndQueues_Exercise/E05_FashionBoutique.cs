int[] input = Console.ReadLine().Split().Select(int.Parse).ToArray();
Stack<int> stack = new Stack<int>(input);

int rackCapacity = int.Parse(Console.ReadLine());
int usedRacks = 1;
int currentCapacity = 0;

while (stack.Count > 0)
{
    int currentValue = stack.Pop();
    
    if(currentValue + currentCapacity <= rackCapacity)
    {
        currentCapacity += currentValue;
    }
    else
    {
        usedRacks++;
        currentCapacity = currentValue;
    }
}

Console.WriteLine(usedRacks);
