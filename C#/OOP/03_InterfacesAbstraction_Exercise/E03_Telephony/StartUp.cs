using System.Reflection.PortableExecutable;
using System;
using ManufacturingPhones.Model.Interface;
using ManufacturingPhones.Model;

namespace ManufacturingPhones;

public class StartUp
{
    static void Main(string[] args)
    {
        string[] phoneNumbers = Console.ReadLine()
            .Split(' ', StringSplitOptions.RemoveEmptyEntries);

        string[] urls = Console.ReadLine()
            .Split(' ', StringSplitOptions.RemoveEmptyEntries);

        ICallable callable;

        foreach (var phoneNumber in phoneNumbers)
        {
            if (phoneNumber.Length == 10)
            {
                callable = new Smartphone();
            }
            else
            {
                callable = new StationaryPhone();
            }

            try
            {
                Console.WriteLine(callable.Call(phoneNumber));
            }
            catch(ArgumentException ex)
            {
                Console.WriteLine(ex.Message);
            }
        }

        IBrowsable browsable = new Smartphone();

        foreach (var url in urls)
        {
            try
            {
                Console.WriteLine(browsable.Browsing(url));
            }
            catch (ArgumentException ex)
            {
                Console.WriteLine(ex.Message);
            }
        }
    }
}
