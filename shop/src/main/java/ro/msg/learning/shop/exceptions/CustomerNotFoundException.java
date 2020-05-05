package ro.msg.learning.shop.exceptions;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException (String message) {
        super(message);
    }
}
