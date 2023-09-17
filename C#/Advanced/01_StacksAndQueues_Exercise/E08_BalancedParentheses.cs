string parentheses = Console.ReadLine();

Stack<char> stackOfParentheses = new Stack<char>();

foreach (char elem in parentheses)
{
    if (elem == '(' || elem == '[' || elem == '{')
    {
        stackOfParentheses.Push(elem);
    }

    if (stackOfParentheses.Count == 0)
    {
        stackOfParentheses.Push(elem);
        break;
    }

    if (elem == ')' && stackOfParentheses.Peek() == '(' )
    {
        stackOfParentheses.Pop();
    }

    if (elem == ']' && stackOfParentheses.Peek() == '[')
    {
        stackOfParentheses.Pop();
    }

    if (elem == '}' && stackOfParentheses.Peek() == '{')
    {
        stackOfParentheses.Pop();
    }
}

if(stackOfParentheses.Count == 0)
{
    Console.WriteLine("YES");
}
else
{
    Console.WriteLine("NO");
}

