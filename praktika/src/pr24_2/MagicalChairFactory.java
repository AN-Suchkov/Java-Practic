package pr24_2;

public class MagicalChairFactory implements ChairFactory {
    @Override
    public Chair createChair() {
        return new MagicalChair();
    }
}
