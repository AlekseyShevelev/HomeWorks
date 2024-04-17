package ru.geekbrains.bookingservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception ex, WebRequest request) {
        String logMessage = String.format("Exception: %s, message: %s, request: %s",
                ex.getClass().getName(), ex.getMessage(), request.getDescription(false));

        logger.log(Level.FINE, logMessage, ex);

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
