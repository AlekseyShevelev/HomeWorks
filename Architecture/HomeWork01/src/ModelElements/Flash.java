package ModelElements;

import Stuff.Angle3D;
import Stuff.Point3D;

public class Flash {
    public Point3D location;
    public Angle3D angle;
    public java.awt.Color color;
    public float power;

    public Flash(Point3D location, Angle3D angle, Color color, float power) {
        this.location = location;
        this.angle = angle;
        this.color = color;
        this.power = power;
    }

    public void rotate(Angle3d angle) {

    }

    public void move(Point3D location) {

    }
}
