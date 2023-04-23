package com.abcinsitute.advisor;

import com.abcinsitute.exception.DuplicateKeyException;
import com.abcinsitute.exception.NotFoundException;
import com.abcinsitute.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException e){
        return new ResponseEntity<StandardResponse>(new StandardResponse(404, "Error", e.getMessage()), HttpStatus.NOT_FOUND) {
        };
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<StandardResponse> handleDuplicateKeyException(DuplicateKeyException e){
        return new ResponseEntity<StandardResponse>(new StandardResponse(400, "Error", e.getMessage()), HttpStatus.ALREADY_REPORTED) {
        };
    }
}
