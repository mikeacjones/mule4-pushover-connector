package net.mikej.connectors.api;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Priority {
    NO_NOTIFICATION(-2),
    QUIET_NOTIFICATION(-1),
    NORMAL(0),
    HIGH_PRIORITY(1),
    REQUIRE_CONFIRMATION(2);

    private final int value;
    private Priority(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() { return value; }
}
