using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DateModifier
{
    public class StartUp
    {

        static void Main(string[] args)
        {
            string startDate = Console.ReadLine();
            string endDate = Console.ReadLine();

            int differenceInDays = DateModifier.GetDifferenceInDays(startDate, endDate);
            
            Console.WriteLine(differenceInDays);
        }
    }
}
