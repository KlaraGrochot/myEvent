package org.klarag.myevent.exception;

public class RegistrationFullException extends RuntimeException {
    public RegistrationFullException(String eventName) {
        super("Rejestracja na wydarzenie: " + eventName + " nie jest możliwa. Osiągnięto limit uczestników");
    }
}
