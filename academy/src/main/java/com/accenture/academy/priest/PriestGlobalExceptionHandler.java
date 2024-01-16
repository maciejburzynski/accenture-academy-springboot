package com.accenture.academy.priest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class PriestGlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(PriestNotFoundException.class)
    String priestNotFoundExceptionHandler(PriestNotFoundException priestNotFoundException){
        return priestNotFoundException.getMessage();
    }

}

