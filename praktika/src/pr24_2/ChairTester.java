package pr24_2;

public class ChairTester {
    public static void main(String[] args) {
        // Создание фабрик
        ChairFactory victorianFactory = new VictorianChairFactory();
        ChairFactory multifunctionalFactory = new MultifunctionalChairFactory();
        ChairFactory magicalFactory = new MagicalChairFactory();

        // Клиент выбирает и использует стул через фабрику
        Client client1 = new Client(victorianFactory);
        client1.sit();

        Client client2 = new Client(multifunctionalFactory);
        client2.sit();

        Client client3 = new Client(magicalFactory);
        client3.sit();
    }
}
