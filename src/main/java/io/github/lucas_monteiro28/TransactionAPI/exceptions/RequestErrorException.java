package io.github.lucas_monteiro28.TransactionAPI.exceptions;

public class RequestErrorException extends RuntimeException {
    public RequestErrorException(String message) {
        super(message);
    }
}
