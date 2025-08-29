package pr18;

public class ThrowsDemo2 {
    public String getDetails(String key) {
        try {
            if (key == null) {
                throw new NullPointerException("null key in getDetails");
            }
            return "data for " + key;
        } catch (NullPointerException e) {
            return "Error: " + e.getMessage();  // Обработка исключения внутри метода
        }
    }

    public void printMessage(String key) {
        String message = getDetails(key);
        System.out.println(message);
    }
}
