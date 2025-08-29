package pr13;

import java.util.StringTokenizer;

public class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String building;
    private String apartment;

    public void parseAddressWithSplit(String address) {
        String[] parts = address.split("\\s*,\\s*");
        assignFields(parts);
    }

    public void parseAddressWithTokenizer(String address) {
        StringTokenizer tokenizer = new StringTokenizer(address, ",.;");
        String[] parts = new String[tokenizer.countTokens()];
        int index = 0;
        while (tokenizer.hasMoreTokens()) {
            parts[index++] = tokenizer.nextToken().trim();
        }
        assignFields(parts);
    }

    private void assignFields(String[] parts) {
        this.country = parts.length > 0 ? parts[0] : "";
        this.region = parts.length > 1 ? parts[1] : "";
        this.city = parts.length > 2 ? parts[2] : "";
        this.street = parts.length > 3 ? parts[3] : "";
        this.house = parts.length > 4 ? parts[4] : "";
        this.building = parts.length > 5 ? parts[5] : "";
        this.apartment = parts.length > 6 ? parts[6] : "";
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", building='" + building + '\'' +
                ", apartment='" + apartment + '\'' +
                '}';
    }

    public static void main(String[] args) {
        String address1 = "Россия , Московская область , Москва , Арбат , 10 , 2 , 45";
        String address2 = "США. Калифорния. Сан-Франциско. Ломбард-стрит. 100. 5. 12";
        String address3 = "Канада; Онтарио; Торонто; Кинг-стрит; 200; ; 8";
        String address4 = "Германия, Бавария, Мюнхен, Карлплац, 50";

        Address addr = new Address();

        System.out.println("Метод split():");
        addr.parseAddressWithSplit(address1);
        System.out.println(addr);

        System.out.println("\nМетод StringTokenizer:");
        addr.parseAddressWithTokenizer(address2);
        System.out.println(addr);

        addr.parseAddressWithTokenizer(address3);
        System.out.println(addr);

        addr.parseAddressWithTokenizer(address4);
        System.out.println(addr);
    }
}
