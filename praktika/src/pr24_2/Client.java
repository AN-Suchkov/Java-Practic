package pr24_2;

public class Client {
    private Chair chair;

    public Client(ChairFactory chairFactory) {
        this.chair = chairFactory.createChair();
    }

    public void sit() {
        chair.sit();
    }
}
