package ru.atom.geometry;

public class Bar implements Collider {
    private Point leftPoint;
    private Point rightPoint;

    public Bar(Point lP, Point rP) {
        int leftX;
        int leftY;
        int rightX;
        int rightY;
        if (lP.getX() < rP.getX()) {
            leftX = lP.getX();
            rightX = rP.getX();
        } else {
            leftX = rP.getX();
            rightX = lP.getX();
        }
        if (lP.getY() > rP.getY()) {
            leftY = lP.getY();
            rightY = rP.getY();
        } else {
            leftY = rP.getY();
            rightY = lP.getY();
        }
        leftPoint = new Point(leftX, leftY);
        rightPoint = new Point(rightX, rightY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        // cast from Object to Point
        Bar bar = (Bar) o;

        return (leftPoint.equals(((Bar) o).leftPoint)) && (rightPoint.equals(((Bar) o).rightPoint));
    }

    public boolean isColliding(Collider other) {

        if (this.equals(other)) return true;

        if (other == null) return false;

        if (other.getClass() == getClass()) {
            Bar bar = (Bar) other;

            return (leftPoint.getX() <= bar.rightPoint.getX())
                    && (rightPoint.getX() >= bar.leftPoint.getX())
                    && (rightPoint.getY() <= bar.leftPoint.getY())
                    && (leftPoint.getY() >= bar.rightPoint.getY());

        } else if (other.getClass() == leftPoint.getClass()) {
            Point point = (Point) other;
            return ((point.getX() >= leftPoint.getX()) && (point.getX() <= rightPoint.getX()))
                    && ((point.getY() <= leftPoint.getY()) && (point.getY() >= rightPoint.getY()));
        } else return false;
    }

    public Point getLeftPoint() {
        return leftPoint;
    }

    public Point getRightPoint() {
        return rightPoint;
    }
}
