int bulletPrice = int.Parse(Console.ReadLine());
int gunBarrelSize = int.Parse(Console.ReadLine());
int[] bulletsInput = Console.ReadLine().Split().Select(int.Parse).ToArray();
int[] locksInput = Console.ReadLine().Split().Select(int.Parse).ToArray();
int intelligence = int.Parse(Console.ReadLine());

Queue<int> locks = new Queue<int>(locksInput);
Stack<int> bullets = new Stack<int>(bulletsInput);

int tempBulletsInBarrel = gunBarrelSize;
int firedBullets = 0;

while (bullets.Count > 0 && locks.Count > 0)
{
    int currentBullet = bullets.Pop();
    int currentLock = locks.Peek();

    firedBullets++;

    if (currentBullet <= currentLock)
    {
        locks.Dequeue();
        Console.WriteLine("Bang!");
    }
    else
    {
        Console.WriteLine("Ping!");
    }

    tempBulletsInBarrel--;

    if (tempBulletsInBarrel == 0 && bullets.Count > 0)
    {
        Console.WriteLine("Reloading!");
        tempBulletsInBarrel = gunBarrelSize;
    }
}

if (bullets.Count == 0 && locks.Count > 0)
{
    Console.WriteLine($"Couldn't get through. Locks left: {locks.Count}");
}
else
{
    Console.WriteLine($"{bullets.Count} bullets left. Earned ${intelligence - (firedBullets * bulletPrice)}");
}

