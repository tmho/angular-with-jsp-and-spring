package com.orucs.smarta.controller;

public class ResourceNotFound extends Exception {
    public ResourceNotFound(Throwable cause) {
        super(cause);
    }

    public ResourceNotFound() {
        super();
    }

    public ResourceNotFound(String message) {
        super(message);
    }
}
