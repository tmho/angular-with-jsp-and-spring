package com.orucs.smarta.controller;

public class Response<T> {
    private T response;
    private Error error;

    public Response(T response) {
        this.response = response;
    }

    public Response () {
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

}
