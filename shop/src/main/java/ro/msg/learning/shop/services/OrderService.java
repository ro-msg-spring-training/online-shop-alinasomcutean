package ro.msg.learning.shop.services;

import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.model.Order;
import sun.util.locale.LocaleSyntaxException;

public interface OrderService {

    Order createOrder(OrderDTO orderDTO) throws LocaleSyntaxException;
}
