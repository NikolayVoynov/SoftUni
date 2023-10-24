using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedRacing
{
    public class StartUp
    {
        static void Main(string[] args)
        {
            Dictionary<string, Car> carsByName = new Dictionary<string, Car>();

            int count = int.Parse(Console.ReadLine());

            for (int i = 0; i < count; i++)
            {
                string[] carProps = Console.ReadLine()
                .Split(" ", StringSplitOptions.RemoveEmptyEntries);

                Car newCar = new Car(carProps[0],
                    double.Parse(carProps[1]),
                    double.Parse(carProps[2]));

                carsByName.Add(newCar.Model, newCar);
            }

            string command = Console.ReadLine();

            while (command != "End")
            {
                string[] tokens = command.Split(" ",
                    StringSplitOptions.RemoveEmptyEntries);

                string model = tokens[1];
                double amountOfKm = double.Parse(tokens[2]);


                Car car = carsByName[model];

                car.Drive(amountOfKm);

                command = Console.ReadLine();
            }


            foreach (Car car in carsByName.Values)
            {
                Console.WriteLine($"{car.Model} {car.FuelAmount:f2} {car.TravelledDistance}");
            }

        }
    }
}
