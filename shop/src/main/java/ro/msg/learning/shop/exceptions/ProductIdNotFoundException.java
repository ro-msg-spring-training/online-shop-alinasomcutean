package ro.msg.learning.shop.exceptions;

public class ProductIdNotFoundException extends RuntimeException {

    public ProductIdNotFoundException(String message) {
        super(message);
    }
}
