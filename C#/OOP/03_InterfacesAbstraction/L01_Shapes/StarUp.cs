
using System.Drawing;
using System;
using Shapes;

var radius = int.Parse(Console.ReadLine());
IDrawable circle = new Circle(radius);

var width = int.Parse(Console.ReadLine());
var height = int.Parse(Console.ReadLine());
IDrawable rect = new Shapes.Rectangle(width, height);

circle.Draw();
rect.Draw();
