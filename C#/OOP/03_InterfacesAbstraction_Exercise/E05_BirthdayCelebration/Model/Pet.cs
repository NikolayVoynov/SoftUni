using BirthdayCelebration.Model.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BirthdayCelebration.Model
{
    public class Pet : INameable, IBirthable
    {
        public Pet(string name, string birthday)
        {
            Name = name;
            Birthday = birthday;
        }
        public string Name { get; set; }

        public string Birthday { get; set; }
    }
}
