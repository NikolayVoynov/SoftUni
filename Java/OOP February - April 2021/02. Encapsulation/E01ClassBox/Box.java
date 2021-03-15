package E01ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (Validator.isNotValidSide(length)) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }

        this.length = length;
    }

    private void setWidth(double width) {
        if (Validator.isNotValidSide(width)) {
            throw new IllegalStateException("Width cannot be zero or negative.");
        }

        this.width = width;
    }

    private void setHeight(double height) {
        if (Validator.isNotValidSide(height)) {
            throw new IllegalStateException("Width cannot be zero or negative.");
        }

        this.height = height;
    }


    public double calculateSurfaceArea() {
        return 2 * (this.height * this.length + this.length * this.width + this.width * this.height);
    }

    public double calculateLateralSurfaceArea() {
        return 2 * (this.height * this.length + this.width * this.height);
    }

    public double calculateVolume() {
        return this.height * this.length * this.width;
    }
}
