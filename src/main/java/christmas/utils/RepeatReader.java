package christmas.utils;

import java.util.function.Supplier;

public class RepeatReader {
    private RepeatReader() {

    }

    public static <T> T repeatRead(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return repeatRead(supplier);
        }
    }
}
