package L02Shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.setRadius(radius);
    }

    public final Double getRadius() {
        return this.radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(2 * Math.PI * this.radius);
    }

    @Override
    protected void calculateArea() {
        setArea(Math.PI * this.radius * this.radius);
    }
}
