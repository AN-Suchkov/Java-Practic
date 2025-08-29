package pr6;

interface Convertable {
    double convert(double value);
}

class CelsiusToKelvinConverter implements Convertable {
    @Override
    public double convert(double celsius) {
        return celsius + 273.15;
    }
}

class CelsiusToFahrenheitConverter implements Convertable {
    @Override
    public double convert(double celsius) {
        return (celsius * 9/5) + 32;
    }
}

