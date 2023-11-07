using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassBoxData.Models
{
    public class Box
    {
        private const string PropertyValueExceptionMessage = "{0} cannot be zero or negative.";

        private double length;
        private double width;
        private double height;

        public Box(double length, double width, double height)
        {
            Length = length;
            Width = width;
            Height = height;
        }

        public double Length
        {
            get { return length; }
            set
            {
                if (value <= 0)
                {
                    throw new ArgumentException(String.Format(PropertyValueExceptionMessage, nameof(Length)));
                }

                length = value;
            }

        }

        public double Width
        {
            get { return width; }
            set
            {
                if (value <= 0)
                {
                    throw new ArgumentException(String.Format(PropertyValueExceptionMessage, nameof(Width)));
                }

                width = value;
            }
        }

        public double Height
        {
            get { return height; }
            set
            {
                if (value <= 0)
                {
                    throw new ArgumentException(String.Format(PropertyValueExceptionMessage, nameof(Height)));
                }

                height = value;
            }
        }

        public double SurfaceArea()
        {
            return 2 * (Length * Height + Length * Width + Height * Width);
        }

        public double LateralSurfaceArea()
        {
            return 2 * Length * Height + 2 * Width * Height;
        }

        public double Volume()
        {
            return Length * Height * Width;
        }

    }
}
