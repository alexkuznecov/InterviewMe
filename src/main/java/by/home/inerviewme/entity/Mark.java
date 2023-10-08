package by.home.inerviewme.entity;

import java.util.HashMap;
import java.util.Map;

public enum Mark {
    NOT_ANSWERED("1"),
    ANSWERED_PARTLY("2"),
    ANSWERED_CORRECT("3");

    private static final Map<String, Mark> BY_VALUE = new HashMap<>();

    static {
        for (Mark e: values()) {
            BY_VALUE.put(e.value, e);
        }
    }

    public final String value;

    Mark(final String value) {
        this.value = value;
    }

    public static Mark getByValue(String value) {
        return BY_VALUE.get(value);
    }
}
