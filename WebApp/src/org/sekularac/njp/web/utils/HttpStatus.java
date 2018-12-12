package org.sekularac.njp.web.utils;

public enum HttpStatus {

    SUCCESS(200),
    NOT_FOUND(404),
    CREATED(201),
    FORBIDDEN(403);

    private final int value;

    HttpStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
