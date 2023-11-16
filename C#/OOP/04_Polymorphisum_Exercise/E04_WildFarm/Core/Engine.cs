using WildFarm.Core.Interfaces;
using WildFarm.Factories.Interfaces;
using WildFarm.IO.Interfaces;
using WildFarm.Models.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WildFarm.Core
{
    public class Engine : IEngine
    {
        private readonly IReader reader;
        private readonly IWriter writer;
        private readonly IAnimalFactory animalFactory;
        private readonly IFoodFactory foodFactory;

        private readonly ICollection<IAnimal> animals;


        public Engine(IReader reader, IWriter writer, IAnimalFactory animalFactory, IFoodFactory foodFactory)
        {
            this.reader = reader;
            this.writer = writer;

            this.animalFactory = animalFactory;
            this.foodFactory = foodFactory;
            animals = new List<IAnimal>();
        }
        public void Run()
        {

            string command;

            while((command = reader.ReadLine()) != "End")
            {
                IAnimal animal = null;

                try
                {
                    animal = CreateAnimal(command);

                    IFood food = CreateFood();

                    writer.WriteLine(animal.ProduceSound());

                    animal.Eat(food);
                }
                catch (ArgumentException ex)
                {
                    writer.WriteLine(ex.Message);
                }
                catch(Exception)
                {
                    throw;
                }

                animals.Add(animal);
            }

            foreach(IAnimal animal in animals)
            {
                writer.WriteLine(animal);
            }
        }

        private IFood CreateFood()
        {
            string[] foodToken = reader.ReadLine().Split(" ", StringSplitOptions.RemoveEmptyEntries);

            string foodType = foodToken[0];
            int foodQuantity = int.Parse(foodToken[1]);

            IFood food = foodFactory.CreateFood(foodType, foodQuantity);
            
            return food;
        }

        private IAnimal CreateAnimal(string command)
        {
            string[] animalToken = command.Split(' ', StringSplitOptions.RemoveEmptyEntries);

            IAnimal animal = animalFactory.CreateAnimal(animalToken);

            return animal;
        }
    }
}
