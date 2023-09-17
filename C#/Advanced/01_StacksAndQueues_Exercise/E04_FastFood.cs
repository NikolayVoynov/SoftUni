int foodQuantity = int.Parse(Console.ReadLine());
int[] orders = Console.ReadLine().Split().Select(int.Parse).ToArray();
Queue<int> queueOrders = new Queue<int>(orders);

while (queueOrders.Count > 0 && foodQuantity > 0)
{
    int currentOrder = queueOrders.Peek();

    if (foodQuantity - currentOrder >= 0)
    {
        foodQuantity -= queueOrders.Dequeue();
    }
    else
    {
        break;
    }
}

if (queueOrders.Count == 0)
{
    Console.WriteLine("Orders complete");
}
else
{
    Console.WriteLine($"Orders left: {string.Join(" ", queueOrders)}");
}


