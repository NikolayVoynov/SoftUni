using BirthdayCelebration.Model;
using BirthdayCelebration.Model.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BirthdayCelebration
{
    public class StartUp
    {
        static void Main(string[] args)
        {
            List<IBirthable> society = new ();

            string input = Console.ReadLine();

            while (input != "End")
            {
                string[] token = input.Split(" ", StringSplitOptions.RemoveEmptyEntries);

                string command = token[0];

                switch (command)
                {
                    case "Citizen":
                        IBirthable citizen = new Citizen(token[1], int.Parse(token[2]), token[3], token[4]);
                        society.Add(citizen);
                        break;
                    case "Pet":
                        IBirthable pet = new Pet(token[1], token[2]);
                        society.Add (pet);
                        break;
                }

                input = Console.ReadLine();
            }

            string validYear = Console.ReadLine();

            foreach (var elem in society)
            {
                if (elem.Birthday.EndsWith(validYear))
                {
                    Console.WriteLine(elem.Birthday);
                }
            }
        }
    }
}
