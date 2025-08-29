package pr24_1;

public class ConcreteComplex1 implements Complex {
    private final int real;
    private final int image;

    public ConcreteComplex1(int real, int image) {
        this.real = real;
        this.image = image;
    }

    @Override
    public double getReal() {
        return real;
    }

    @Override
    public double getImage() {
        return image;
    }

    @Override
    public String toString() {
        return real + " + " + image + "i";
    }
}