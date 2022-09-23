package homework.shapes;

public class Ball extends SolidOfRevolution {
    public Ball(double radius) {
        this.radius = radius;
        this.volume = Math.pow(this.radius, 3) * Math.PI * 4 / 3;
    }
}
