package homework.shapes;

public class Box extends Shape {

    public Box(double volume) {
        this.volume = volume;
    }

    public boolean add(Shape shape) {
        this.volume -= shape.getVolume();
        return this.volume >= 0;
    }
}
