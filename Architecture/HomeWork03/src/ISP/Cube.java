package ISP;

public class Cube implements iShape, iShape3D {
    int side;

    public Cube(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    @Override
    public double getArea() {
        return side * side * 6;
    }

    @Override
    public double getVolume() {
        return Math.pow(side, 3);
    }
}
