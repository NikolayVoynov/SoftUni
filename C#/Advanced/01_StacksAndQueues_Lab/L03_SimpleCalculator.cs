// See https://aka.ms/new-console-template for more information
Queue<string> queue = new Queue<string>(Console.ReadLine().Split());

int result = 0;



while (queue.Count > 0)
{
    string element = queue.Dequeue();

    if (element == "-")
    {
        result -= int.Parse(queue.Dequeue());
    } 
    else if (element == "+")
    {
        result += int.Parse(queue.Dequeue());
    }
    else
    {
        result += int.Parse(element);
    }
}

Console.WriteLine(result);