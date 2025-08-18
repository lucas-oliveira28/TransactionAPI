package io.github.lucas_monteiro28.TransactionAPI.exceptions;

public class RequestNotFoundException extends RuntimeException {
    public RequestNotFoundException(String message) {
        super(message);
    }
}
