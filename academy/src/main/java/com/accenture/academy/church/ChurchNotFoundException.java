package com.accenture.academy.church;

public class ChurchNotFoundException extends RuntimeException {

    public ChurchNotFoundException() {
        super();
    }

    public ChurchNotFoundException(String message) {
        super(message);
    }
}
