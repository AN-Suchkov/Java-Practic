package pr6;

public class Convertable_Tester {
    public static void main(String[] args) {
        double celsiusTemperature = 100.0;

        Convertable toKelvin = new CelsiusToKelvinConverter();
        Convertable toFahrenheit = new CelsiusToFahrenheitConverter();

        double kelvinResult = toKelvin.convert(celsiusTemperature);
        System.out.println("Перевод " + celsiusTemperature + "°C в Кельвины: " + kelvinResult + "K");

        double fahrenheitResult = toFahrenheit.convert(celsiusTemperature);
        System.out.println("Перевод " + celsiusTemperature + "°C в Фаренгейты: " + fahrenheitResult + "°F");

    }
}
