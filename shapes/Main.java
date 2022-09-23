package homework.shapes;

public class Main {
    public static void main(String[] args) {
        Box box = new Box(1000.0);
        Cylinder c = new Cylinder(1, 3);
        box.add(c);
        Ball ball = new Ball(5);
        box.add(ball);
        Pyramid p = new Pyramid(13, 10);
        System.out.println("Pyramid: " + box.add(p));
        System.out.println(box.getVolume());
    }
}
