package com.accenture.academy.priest;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class PriestGlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(PriestNotFoundException.class)
    String priestNotFoundExceptionHandler(PriestNotFoundException priestNotFoundException) {
        return priestNotFoundException.getMessage();
    }

    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    List<String> bindExceptionHandler(BindException bindException) {
        List<FieldError> fieldErrors = bindException.getBindingResult().getFieldErrors();
        List<String> stringList = new ArrayList<>();
        for (FieldError fieldError : fieldErrors) {
            stringList.add(fieldError.getDefaultMessage());
        }
        return stringList;
    }
}

