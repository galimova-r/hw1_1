package homework.shapes;

public class Cylinder extends SolidOfRevolution {
    double height;

    public Cylinder(double height, double radius) {
        this.height = height;
        this.radius = radius;
        this.volume = Math.pow(this.radius, 2) * Math.PI * this.height;
    }

    public double getHeight() {
        return height;
    }


}
