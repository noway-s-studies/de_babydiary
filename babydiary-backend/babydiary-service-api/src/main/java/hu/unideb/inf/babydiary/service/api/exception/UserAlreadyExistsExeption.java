package hu.unideb.inf.babydiary.service.api.exception;

public class UserAlreadyExistsExeption extends RuntimeException {

    public UserAlreadyExistsExeption(String message) {
        super(message);
    }
}
