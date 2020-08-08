package com.alchuk.nerd_test_task;

public class InvalidInputException extends RuntimeException {

    private final String message;

    public InvalidInputException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
