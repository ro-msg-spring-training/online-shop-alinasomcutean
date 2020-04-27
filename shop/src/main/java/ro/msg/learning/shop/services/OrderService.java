package ro.msg.learning.shop.services;

import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.model.Order;

public interface OrderService {

    Order createOrder(OrderDTO orderDTO);
}
