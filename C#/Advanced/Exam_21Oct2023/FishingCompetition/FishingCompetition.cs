using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

public class OffroadChallenge
{
    static void Main(string[] args)
    {
        int dimensions = int.Parse(Console.ReadLine());

        string[,] fishingArea = new string[dimensions, dimensions];

        int positionRow = -1;
        int positionCol = -1;

        int shipCatch = 0;

        for (int r = 0; r < fishingArea.GetLength(0); r++)
        {
            string currentLine = Console.ReadLine();

            for (int c = 0; c < fishingArea.GetLength(1); c++)
            {
                if (currentLine[c].ToString() == "S")
                {
                    positionRow = r;
                    positionCol = c;
                    fishingArea[r, c] = "-";
                    continue;
                }

                fishingArea[r, c] = currentLine[c].ToString();
            }
        }

        string command;

        while ((command = Console.ReadLine()) != "collect the nets")
        {
            if (MoveIsOutOfArea(dimensions, positionRow, positionCol, command))
            {
                if (command == "up" || command == "down")
                {
                    positionRow = ResetRow(dimensions, command);
                }

                if (command == "right" || command == "left")
                {
                    positionCol = ResetCol(dimensions, command);
                }
            }
            else
            {
                if (command == "up")
                {
                    positionRow--;
                }
                else if (command == "down")
                {
                    positionRow++;
                }
                else if (command == "left")
                {
                    positionCol--;
                }
                else
                {
                    positionCol++;
                }
            }

            if (Char.IsDigit(fishingArea[positionRow, positionCol][0]))
            {
                shipCatch += int.Parse(fishingArea[positionRow, positionCol]);
                fishingArea[positionRow, positionCol] = "-";
                continue;
            }

            if (fishingArea[positionRow, positionCol] == "W")
            {
                Console.WriteLine($"You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [{positionRow},{positionCol}]");
                Environment.Exit(0);
            }
        }

        if (shipCatch >= 20)
        {
            Console.WriteLine("Success! You managed to reach the quota!");
        }
        else
        {
            int lackOfFish = 20 - shipCatch;

            Console.WriteLine($"You didn't catch enough fish and didn't reach the quota! You need {lackOfFish} tons of fish more.");
        }

        if (shipCatch > 0)
        {
            Console.WriteLine($"Amount of fish caught: {shipCatch} tons.");
        }

        fishingArea[positionRow, positionCol] = "S";

        for (int r = 0; r < fishingArea.GetLength(0); r++)
        {
            for (int c = 0; c < fishingArea.GetLength(1); c++)
            {
                Console.Write(fishingArea[r, c]);
            }
            Console.WriteLine();
        }
    }

    private static int ResetCol(int dimensions, string command)
    {
        if (command == "left")
        {
            return dimensions - 1;
        }

        return 0;
    }

    private static int ResetRow(int dimensions, string command)
    {
        if (command == "up")
        {
            return dimensions - 1;
        }

        return 0;
    }

    public static bool MoveIsOutOfArea(int dimensions, int positionRow, int positionCol, string command)
    {
        if (command == "up" && positionRow == 0 ||
            command == "down" && positionRow == dimensions - 1 ||
            command == "left" && positionCol == 0 ||
            command == "right" && positionCol == dimensions - 1)
        {
            return true;
        }

        return false;
    }
}









