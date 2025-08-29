package pr24_1;

public class ConcreteComplex2 implements Complex {
    private final int real;
    private final int image;

    public ConcreteComplex2(int real, int image) {
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
        return real + " - " + image + "i";
    }
}