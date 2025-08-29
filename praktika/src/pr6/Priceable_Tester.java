package pr6;

public class Priceable_Tester {
    public static void main(String[] args) {
        Priceable apple = new Product("Apple", 0.5);
        Priceable smartphone = new Device("Smartphone Model X", 999.99);
        Priceable cleaningService = new Service("House Cleaning", 80.0);

        System.out.println("Product: " + ((Product) apple).getName() + ", Price: $" + apple.getPrice());
        System.out.println("Device: " + ((Device) smartphone).getModel() + ", Price: $" + smartphone.getPrice());
        System.out.println("Service: " + ((Service) cleaningService).getDescription() + ", Price: $" + cleaningService.getPrice());
    }
}
