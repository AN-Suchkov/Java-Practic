package pr4_1;

abstract class Shape {
    public abstract String getType();

    public abstract double getArea();

    public abstract double getPerimeter();

    @Override
    public String toString() {
        return "Shape type: " + getType();
    }
}