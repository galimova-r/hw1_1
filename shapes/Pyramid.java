package homework.shapes;

public class Pyramid extends Shape {
    double s;
    double h;

    public Pyramid(double s, double h) {
        this.s = s;
        this.h = h;
        this.volume = Math.pow(s, 2) * h / 3;
    }
}
