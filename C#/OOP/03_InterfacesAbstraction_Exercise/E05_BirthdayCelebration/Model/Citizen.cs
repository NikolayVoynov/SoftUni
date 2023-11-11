using BirthdayCelebration.Model.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BirthdayCelebration.Model
{
    public class Citizen : IIdentifiable, INameable, IBirthable
    {
        public Citizen(string name, int age, string id, string birthday)
        {
            Name = name;
            Age = age;
            Id = id;
            Birthday = birthday;
        }

        public string Id { get; private set; }

        public string Name { get; private set; }

        public string Birthday { get; private set; }

        public int Age { get; private set; }
    }
}
