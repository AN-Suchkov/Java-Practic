package pr24_1;

public class ConcreteFactory2 implements ComplexAbstractFactory {
    @Override
    public Complex createComplex(int real, int image) {
        return new ConcreteComplex2(real, image);
    }
}