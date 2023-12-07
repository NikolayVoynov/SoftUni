using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;

namespace SoftUniKindergarten
{
    public class Kindergarten
    {
        public Kindergarten(string name, int capacity)
        {
            Name = name;
            Capacity = capacity;
            Registry = new List<Child>();
        }

        public string Name { get; private set; }
        public int Capacity { get; private set; }
        public List<Child> Registry { get; private set; }

        public bool AddChild(Child child)
        {
            if (ChildrenCount < Capacity)
            {
                Registry.Add(child);
                return true;
            }

            return false;
        }

        public bool RemoveChild(string childFullName)
        {
            string[] names = childFullName.Split(" ");
            string firstName = names[0];
            string lastName = names[1];

            return Registry.Remove(Registry.FirstOrDefault(child => child.FirstName == firstName && child.LastName == lastName));
        }

        public int ChildrenCount
        {
            get { return Registry.Count; }
        }

        public Child GetChild(string childFullName)
        {
            string[] names = childFullName.Split(" ");
            string firstName = names[0];
            string lastName = names[1];

            Child child = Registry.FirstOrDefault(child => child.FirstName == firstName && child.LastName == lastName);

            if (child != null)
            {
                return child;
            }

            return null;
        }

        public string RegistryReport()
        {
            StringBuilder sb = new StringBuilder();

            sb.AppendLine($"Registered children in {Name}:");

            foreach (var child in Registry
                .OrderByDescending(child=> child.Age)
                .ThenBy(chd=> chd.LastName)
                .ThenBy(ch=>ch.FirstName)
               )
            {
                sb.AppendLine(child.ToString());
            }

            return sb.ToString().TrimEnd();
        }
    }
}
