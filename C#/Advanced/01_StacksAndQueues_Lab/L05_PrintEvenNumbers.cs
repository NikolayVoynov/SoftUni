// See https://aka.ms/new-console-template for more information

using System.Text;

int[] arr = Console.ReadLine().Split().Select(int.Parse).ToArray();

Queue<int> queue = new Queue<int>();

for (int i = 0; i < arr.Length; i++)
{
    if (arr[i]%2 == 0) 
    {
        queue.Enqueue(arr[i]);
    } 
}

StringBuilder sb = new StringBuilder();

while (queue.Count > 1)
{
    sb.Append(queue.Dequeue())
        .Append(", ");
}

sb.Append(queue.Dequeue());

Console.WriteLine(sb.ToString());

