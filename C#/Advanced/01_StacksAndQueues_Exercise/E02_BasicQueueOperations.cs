int[] input = Console.ReadLine().Split().Select(int.Parse).ToArray();
int[] values = Console.ReadLine().Split().Select(int.Parse).ToArray();

int addInQueue = input[0];
int removeFromQueue = input[1];
int lookFor = input[2];

Queue<int> queue = new Queue<int>(values.Take(addInQueue));

while (queue.Count > 0 && removeFromQueue > 0)
{
    queue.Dequeue();
    removeFromQueue--;
}

if (queue.Count == 0)
{
    Console.WriteLine(0);
}
else if (queue.Contains(lookFor))
{
    Console.WriteLine("true");
}
else
{
    Console.WriteLine(queue.Min());
}
