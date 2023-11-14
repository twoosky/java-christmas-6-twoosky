package christmas.utils;

public class IntegerConverter {
    private IntegerConverter() {

    }

    public static int convert(String value, String errorMessage) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
