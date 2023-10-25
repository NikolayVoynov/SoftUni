using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PokemonTrainer
{
    public class StartUp
    {
        static void Main(string[] args)
        {
            List<Trainer> trainers = new List<Trainer>();

            string line = Console.ReadLine();

            while (line != "Tournament")
            {

                string[] infoToken = line.Split(" ", StringSplitOptions.RemoveEmptyEntries);

                Trainer trainer = trainers.SingleOrDefault(t => t.Name == infoToken[0]);

                if (trainer == null)
                {
                    trainer = new Trainer(infoToken[0]);
                    trainer.Pokemons.Add(new(infoToken[1], infoToken[2], int.Parse(infoToken[3])));
                    trainers.Add(trainer);
                }
                else
                {
                    trainer.Pokemons.Add(new(infoToken[1], infoToken[2], int.Parse(infoToken[3])));
                }

                line = Console.ReadLine();
            }

            string command = Console.ReadLine();

            while (command != "End")
            {
                foreach (Trainer trainer in trainers)
                {
                    trainer.CheckPokemon(command);
                }

                command = Console.ReadLine();
            }

            List<Trainer> sortedTrainers = trainers.OrderByDescending(t => t.Badges).ToList();

            foreach (Trainer trainer in sortedTrainers)
            {
                Console.WriteLine($"{trainer.Name} {trainer.Badges} {trainer.Pokemons.Count}");
            }
        }
    }
}
