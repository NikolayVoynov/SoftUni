using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BoxOfString
{
    public class StartUp
    {

        static void Main(string[] args)
        {
            Box<string> box = new();

            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                string item = Console.ReadLine();

                box.Add(item);
            }

            Console.WriteLine(box.ToString());
        }
    }
}
