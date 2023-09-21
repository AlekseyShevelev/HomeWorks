package ModelElements;

import Stuff.Angle3D;
import Stuff.Point3D;

public class Camera {
    public Point3D location;
    public Angle3D angle;

    public Camera(Point3D location, Angle3D angle) {
        this.location = location;
        this.angle = angle;
    }

    public void rotate(Angle3d angle) {

    }

    public void move(Point3D location) {

    }
}
