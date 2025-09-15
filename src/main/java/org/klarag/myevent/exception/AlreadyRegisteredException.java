package org.klarag.myevent.exception;

public class AlreadyRegisteredException extends RuntimeException {
    public AlreadyRegisteredException(String email) {
        super("Nie można zarejestrować ponownie. Uczestnik o adresie e-mail: " + email + " jest już zarejestrowany na to wydarzenie.");
    }
}
