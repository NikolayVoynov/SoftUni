package L02PointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public void setTopRight(Point topRight) {
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
        boolean isInHorizontal = bottomLeft.getX() <= point.getX() &&
                topRight.getX() >= point.getX();

        boolean isInVertical = bottomLeft.getY() <= point.getY() &&
                topRight.getY() >= point.getY();

        boolean isInRectangle = isInHorizontal && isInVertical;

        return isInRectangle;
    }

}
