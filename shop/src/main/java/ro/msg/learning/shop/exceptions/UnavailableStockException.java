package ro.msg.learning.shop.exceptions;

public class UnavailableStockException extends RuntimeException {

    public UnavailableStockException(String message) {
        super(message);
    }
}
