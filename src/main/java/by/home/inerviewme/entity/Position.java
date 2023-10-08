package by.home.inerviewme.entity;

import java.util.HashMap;
import java.util.Map;

public enum Position {
    JUNIOR("1"),
    JUNIOR_PLUS("2"),
    MIDDLE("3"),
    MIDDLE_PLUS("4"),
    SENIOR("5");

    private static final Map<String, Position> BY_VALUE = new HashMap<>();

    static {
        for (Position e: values()) {
            BY_VALUE.put(e.value, e);
        }
    }

    public final String value;

    Position(final String value) {
        this.value = value;
    }

    public static Position getByValue(String value) {
        return BY_VALUE.get(value);
    }

}
