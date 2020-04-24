package ro.msg.learning.shop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UnavailableStockHandler {

    @ExceptionHandler(UnavailableStockException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String unavailableStockHandler(UnavailableStockException e) {
        return e.getMessage();
    }
}
