package ro.msg.learning.shop.services;

import ro.msg.learning.shop.model.Address;
import ro.msg.learning.shop.model.Order;

import java.util.HashMap;
import java.util.List;


public interface OrderService {

    List<Order> createOrder(Address address, HashMap<Integer, Integer> orderedProducts);
}
