package pr6;

public class TemperatureConverter {
    public static void main(String[] args) {
        double celsiusTemperature = 25.0;

        Convertable toKelvin = new CelsiusToKelvinConverter();
        Convertable toFahrenheit = new CelsiusToFahrenheitConverter();

        System.out.println("Температура по Цельсию: " + celsiusTemperature + "°C");
        System.out.println("В Кельвинах: " + toKelvin.convert(celsiusTemperature) + "K");
        System.out.println("В Фаренгейтах: " + toFahrenheit.convert(celsiusTemperature) + "°F");
    }
}
