using System.Linq;

int n = int.Parse(Console.ReadLine());

Dictionary<string, List<decimal>> studentsAndGrades = new Dictionary<string, List<decimal>>();

for (int i = 0; i < n; i++)
{
    string[] nameGrade = Console.ReadLine()
        .Split(" ", StringSplitOptions.RemoveEmptyEntries)
        .ToArray();

    string name = nameGrade[0];
    decimal grade = decimal.Parse(nameGrade[1]);

    if (!studentsAndGrades.ContainsKey(name))
    {
        studentsAndGrades.Add(name, new List<decimal>());
    }

    studentsAndGrades[name].Add(grade);
}

foreach (var entry in studentsAndGrades)
{
    string name = entry.Key;
    List<decimal> grades = entry.Value;
    decimal avrgGrade = entry.Value.Average();

    Console.WriteLine($"{name} -> {String.Join(" ", grades.Select(grade => $"{grade:F2}"))} (avg: {avrgGrade:F2})");
}


