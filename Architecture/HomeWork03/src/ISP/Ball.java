package ISP;

public class Ball implements iShape, iShape3D {
    private int radius;

    public Ball(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getVolume() {
        return (double) 4 / 3 * Math.PI * Math.pow(radius, 3);
    }
}
