package com.sudoku.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid input data")
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public void handleException() {
		
        System.out.println("Invalid Input");
        System.out.println("Enter valid positive integer 9X9 data only");
    }
	
}
