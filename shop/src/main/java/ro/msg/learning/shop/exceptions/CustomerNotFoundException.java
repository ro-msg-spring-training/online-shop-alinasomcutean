package ro.msg.learning.shop.exceptions;

import java.util.function.Supplier;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException (String message) {
        super(message);
    }
}
