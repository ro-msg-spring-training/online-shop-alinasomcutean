package ro.msg.learning.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.exceptions.CustomerNotFoundException;
import ro.msg.learning.shop.model.*;
import ro.msg.learning.shop.repository.*;
import ro.msg.learning.shop.services.strategyPattern.Strategy;

import javax.transaction.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final CustomerRepo customerRepo;
    private final ProductRepo productRepo;
    private final AddressRepo addressRepo;
    private final LocationRepo locationRepo;
    private final OrderRepo orderRepo;
    private final OrderDetailRepo orderDetailRepo;
    private final StockRepo stockRepo;
    private final Strategy strategy;

    private Order orderExists(List<Order> orders, Location location) {
        for(Order o : orders) {
            if(o.getShippedFrom().equals(location)) {
                return o;
            }
        }
        return null;
    }

    private Integer getOrderedQuantity(Integer productId, HashMap<Integer, Integer> orderedProducts) {
        for(Map.Entry<Integer, Integer> map : orderedProducts.entrySet()) {
            if(map.getKey().compareTo(productId) == 0) {
                return map.getValue();
            }
        }
        return -1;
    }

    @Transactional
    @Override
    public List<Order> createOrder(Address address, HashMap<Integer, Integer> orderedProducts) {

        Customer customer = customerRepo.findByUsername("alina");
        if (customer == null) {
            throw new CustomerNotFoundException("There is no customer with this username");
        }

        HashMap<Product, Stock> orderShippedFrom = strategy.chooseStrategy(orderedProducts);
        List<Order> orders = new ArrayList<>();

        // Create address object from the given input
        Address newAddress = Address.builder().country(address.getCountry())
                .county(address.getCounty())
                .city(address.getCity())
                .streetAddress(address.getStreetAddress()).build();
        addressRepo.save(address);

        // Create the orders and order detail objects and save them
        for (Map.Entry<Product, Stock> map : orderShippedFrom.entrySet()) {
            Order order = orderExists(orders, map.getValue().getLocation());

            if(order == null) {
                // Create a new order if it doesn't exist already
                order = Order.builder().address(newAddress)
                        .createdAt(new Date())
                        .orderDetail(new ArrayList<>())
                        .customer(customer)
                        .shippedFrom(map.getValue().getLocation()).build();
                orderRepo.save(order);
                orders.add(order);
            }

            // Create a new order detail and save it
            OrderDetailId orderDetailId = OrderDetailId.builder().orderId(order.getId())
                    .productId(map.getKey().getId()).build();
            OrderDetail orderDetail = OrderDetail.builder().orderDetailId(orderDetailId)
                    .order(order).product(map.getKey()).quantity(map.getValue().getQuantity()).build();
            orderDetailRepo.save(orderDetail);

            // Update the order detail list of an order
            List<OrderDetail> orderDetails = order.getOrderDetail();
            orderDetails.add(orderDetail);
            order.setOrderDetail(orderDetails);
            orderRepo.save(order);

            Integer newQuantity = map.getValue().getQuantity() - getOrderedQuantity(map.getKey().getId(), orderedProducts);
            Stock stock = map.getValue();
            stock.setQuantity(newQuantity);
            stockRepo.save(stock);
        }

        return orders;
    }
}
