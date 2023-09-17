int n = int.Parse(Console.ReadLine());

string text = string.Empty;

Stack<string> states = new Stack<string>();

for (int i = 0; i < n; i++)
{
    string[] commands = Console.ReadLine()
        .Split();

    if (commands[0] == "1")
    {
        states.Push(text);
        text += commands[1];
    }
    else if (commands[0] == "2")
    {
        states.Push(text);
        int count = int.Parse(commands[1]);
        text = text.Substring(0, text.Length - count);
    }
    else if (commands[0] == "3")
    {
        int index = int.Parse(commands[1]) - 1;
        Console.WriteLine(text[index]);
    }
    else if (commands[0] == "4")
    {
        text = states.Pop();
    }
}