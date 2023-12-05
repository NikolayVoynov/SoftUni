using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ClothesMagazine
{
    public class Magazine
    {
        public Magazine(string type, int capacity)
        {
            Type = type;
            Capacity = capacity;
            Clothes = new List<Cloth>();
        }

        public string Type { get; private set; }
        public int Capacity { get; private set; }
        public List<Cloth> Clothes { get; private set; }

        public void AddCloth(Cloth cloth)
        {
            if (Clothes.Count < Capacity)
            {
                Clothes.Add(cloth);
            }
        }

        public bool RemoveCloth(string color)
        {
            return Clothes.Remove(Clothes.FirstOrDefault(clth => clth.Color == color));
        }

        public Cloth GetSmallestCloth()
        {
            return Clothes.MinBy(clth => clth.Size);
        }

        public Cloth GetCloth(string color)
        {
            return Clothes.FirstOrDefault(clth=> clth.Color == color);
        }

        public int GetClothCount()
        {
            return Clothes.Count;
        }

        public string Report()
        {
            StringBuilder sb = new StringBuilder();

            sb.AppendLine($"{Type} magazine contains:");

            sb.AppendLine(string.Join("\n",Clothes.OrderBy(clth=>clth.Size)));

            return sb.ToString().TrimEnd();
        }
    }
}
