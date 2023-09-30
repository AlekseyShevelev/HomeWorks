package ISP;

public class Circle implements iShape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return 2 * Math.PI * radius;
    }
}
