// See https://aka.ms/new-console-template for more information
Queue<string> customers = new Queue<string> ();

string command = Console.ReadLine();

while(command!="End") 
{
    if(command != "Paid")
    {
        customers.Enqueue(command);
    }
    else if(command == "Paid")
    {
        while(customers.Count > 0) 
        { 
        Console.WriteLine (customers.Dequeue());
        }
    }
    command = Console.ReadLine();
}

Console.WriteLine($"{customers.Count} people remaining.");
