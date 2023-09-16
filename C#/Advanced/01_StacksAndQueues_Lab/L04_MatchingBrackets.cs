// See https://aka.ms/new-console-template for more information
string expression = Console.ReadLine();

Stack<int> stack = new Stack<int>();

for (int i = 0; i < expression.Length; i++)
{

    if (expression[i] == '(') 
    {
        stack.Push(i);
    }

    if (expression[i] == ')') 
    { 
        int openBracketsIndex = stack.Pop();

        Console.WriteLine(expression.Substring(openBracketsIndex, i - openBracketsIndex +1));
    }
    
}