package com.oracle.HomeTheater.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public String doubleBooking() {
        return "reservation/doubleBooking";
    }
}
