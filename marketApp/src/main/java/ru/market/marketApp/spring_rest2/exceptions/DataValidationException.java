package ru.market.marketApp.spring_rest2.exceptions;

import java.util.List;

public class DataValidationException extends RuntimeException {
    private List<String> messages;

    public List<String> getMessages() {
        return messages;
    }

    public DataValidationException(List<String> messages) {
        this.messages = messages;
    }
}
