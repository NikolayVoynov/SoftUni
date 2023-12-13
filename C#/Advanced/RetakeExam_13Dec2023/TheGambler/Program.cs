using System;
using System.Collections.Generic;
using System.Linq;

int dimension = int.Parse(Console.ReadLine());

string[,] board = new string[dimension, dimension];

int rowGambler = -1;
int colGambler = -1;

int amount = 100;
bool winJackpot = false;
bool leftBoard = false;
bool negativeAmount = false;

for (int r = 0; r < board.GetLength(0); r++)
{
    string currentRow = Console.ReadLine();

    for (int c = 0; c < board.GetLength(1); c++)
    {
        if (currentRow[c].ToString() == "G")
        {
            rowGambler = r;
            colGambler = c;
            board[r, c] = "-";
        }
        else
        {
            board[r, c] = currentRow[c].ToString();
        }

    }
}

string direction;

while ((direction = Console.ReadLine()) != "end")
{
    if (isOutOfBounds(direction, rowGambler, colGambler, board))
    {
        leftBoard = true;
        break;
    }

    switch (direction)
    {
        case "left":
            colGambler--;
            break;
        case "right":
            colGambler++;
            break;
        case "up":
            rowGambler--;
            break;
        case "down":
            rowGambler++;
            break;
    }

    if (board[rowGambler, colGambler] == "W")
    {
        amount += 100;
        board[rowGambler, colGambler] = "-";
    }

    if (board[rowGambler, colGambler] == "P")
    {
        amount -= 200;
        board[rowGambler, colGambler] = "-";

        if (amount <= 0)
        {
            negativeAmount = true;
            break;
        }
    }

    if (board[rowGambler, colGambler] == "J")
    {
        amount += 100000;
        board[rowGambler, colGambler] = "-";
        winJackpot = true;

        break;
    }
}

bool isOutOfBounds(string direction, int rowGambler, int colGambler, string[,] board)
{
    if (direction == "left" && colGambler == 0 ||
         direction == "right" && colGambler == board.GetLength(1) - 1 ||
         direction == "up" && rowGambler == 0 ||
         direction == "down" && rowGambler == board.GetLength(0) - 1)
    {
        return true;
    }

    return false;
}

if (leftBoard || negativeAmount)
{
    Console.WriteLine("Game over! You lost everything!");
}

else if (winJackpot)
{
    Console.WriteLine("You win the Jackpot!");
    Console.WriteLine($"End of the game. Total amount: {amount}$");
}
else
{
    Console.WriteLine($"End of the game. Total amount: {amount}$");
}

if (amount > 0)
{
    board[rowGambler, colGambler] = "G";

    for (int r = 0; r < dimension; r++)
    {
        for (int c = 0; c < dimension; c++)
        {
            Console.Write(board[r, c]);
        }

        Console.WriteLine();
    }
}