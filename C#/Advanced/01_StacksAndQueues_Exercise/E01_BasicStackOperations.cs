int[] input = Console.ReadLine().Split().Select(int.Parse).ToArray();
int[] values = Console.ReadLine().Split().Select(int.Parse).ToArray();

int pushInStack = input[0];
int popFromStack = input[1];
int lookFor = input[2];

Stack<int> stack = new Stack<int>(values.Take(pushInStack));

while (stack.Count > 0 && popFromStack > 0)
{
    stack.Pop();
    popFromStack--;
}

if(stack.Count==0)
{
    Console.WriteLine(0);
}
else if(stack.Contains(lookFor))
{
    Console.WriteLine("true");
}
else
{
    Console.WriteLine(stack.Min());
}
