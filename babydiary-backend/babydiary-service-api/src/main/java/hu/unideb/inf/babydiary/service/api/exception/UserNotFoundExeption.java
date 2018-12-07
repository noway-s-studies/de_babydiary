package hu.unideb.inf.babydiary.service.api.exception;

public class UserNotFoundExeption extends RuntimeException {

    public UserNotFoundExeption(String message) {
        super(message);
    }
}
