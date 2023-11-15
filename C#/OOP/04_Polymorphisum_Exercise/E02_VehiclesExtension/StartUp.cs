

using Vehicles.Factories.Interfaces;
using VehiclesExtension.Core;
using VehiclesExtension.Core.Interfaces;
using VehiclesExtension.Factories;
using VehiclesExtension.IO;
using VehiclesExtension.IO.Interfaces;

public class StartUp
{

    static void Main(string[] args)
    {

        IReader reader = new ConsoleReader();
        IWriter writer = new ConsoleWriter();
        IVehicleFactory vehicleFactory = new VehicleFactory();

        IEngine engine = new Engine(reader, writer, vehicleFactory);

        engine.Run();

    }
}


