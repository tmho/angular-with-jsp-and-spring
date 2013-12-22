package com.orucs.smarta.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class BaseController {

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public
    @ResponseBody
    Response<Void> handleResourceNotFound(ResourceNotFound e) {
        Response response = new Response();
        response.setError(new Error(e.getMessage()));
        return response;
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public
    @ResponseBody
    Response handleInternalServerError(Exception e) {
        Response response = new Response();
        response.setError(new Error(e.getMessage()));
        return response;
    }
}
