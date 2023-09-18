int greenLightSeconds = int.Parse(Console.ReadLine());
int freeWindow = int.Parse(Console.ReadLine());

Queue<string> cars = new Queue<string>();

int passedCars = 0;

string command = Console.ReadLine();

while (command != "END")
{
    if (command != "green")
    {
        cars.Enqueue(command);
        command = Console.ReadLine();
        continue;
    }

    int currentGreenLightSeconds = greenLightSeconds;

    while (cars.Count > 0 && currentGreenLightSeconds > 0)
    {
        string car = cars.Dequeue();

        if (currentGreenLightSeconds - car.Length >= 0)
        {
            currentGreenLightSeconds -= car.Length;
            passedCars++;
            continue;
        }
        else if (currentGreenLightSeconds + freeWindow - car.Length >= 0)
        {
            passedCars++;
            break;
        }
        else
        {
            char hittedLetter = car[currentGreenLightSeconds + freeWindow];
            Console.WriteLine("A crash happened!");
            Console.WriteLine($"{car} was hit at {hittedLetter}.");

            Environment.Exit(0);
        }
    }

    command = Console.ReadLine();
}

Console.WriteLine("Everyone is safe.");
Console.WriteLine($"{passedCars} total cars passed the crossroads.");
