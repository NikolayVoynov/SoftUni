int[] cupsInput = Console.ReadLine().Split().Select(int.Parse).ToArray();
int[] bottlesInput = Console.ReadLine().Split().Select(int.Parse).ToArray();

Queue<int> cups = new Queue<int>(cupsInput);
Stack<int> bottles = new Stack<int>(bottlesInput);

int wastedWater = 0;

while (cups.Count > 0 && bottles.Count > 0)
{
    int currentBottle = bottles.Pop();
    int currentCup = cups.Dequeue();

    if (currentBottle > currentCup)
    {
        wastedWater += currentBottle - currentCup;
        continue;
    }
    else
    {
        currentCup -= currentBottle;

        while (currentCup > 0)
        {
            currentCup -= bottles.Pop();

            if (currentCup < 0)
            {
                wastedWater += currentCup * -1;
            }
        }
    }
}

if(cups.Count > 0)
{
    Console.WriteLine($"Cups: {cups.Count}");
}
else
{
    Console.WriteLine($"Bottles: {bottles.Count}");
}

Console.WriteLine($"Wasted litters of water: {wastedWater}");