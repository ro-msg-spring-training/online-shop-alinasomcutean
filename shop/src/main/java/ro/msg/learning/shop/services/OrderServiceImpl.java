package ro.msg.learning.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.OrderDetailDTO;
import ro.msg.learning.shop.exceptions.CustomerNotFoundException;
import ro.msg.learning.shop.model.*;
import ro.msg.learning.shop.repository.*;
import ro.msg.learning.shop.services.strategyPattern.Strategy;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Transactional
    @Override
    public Order createOrder(OrderDTO orderDTO) {

        Customer customer = customerRepo.findByUsername("alina");
        if (customer == null) {
            throw new CustomerNotFoundException("There is no customer with this username");
        }

        List<OrderDetailDTO> orderDetailDTOS = strategy.chooseStrategy(orderDTO.getOrderedProducts());

        // Create address object from the given input
        Address address = Address.builder().country(orderDTO.getCountry())
                .county(orderDTO.getCounty())
                .city(orderDTO.getCity())
                .streetAddress(orderDTO.getStreetAddress()).build();
        addressRepo.save(address);

        // Create order object from the given input
        Order order = Order.builder().createdAt(new Date())
                .address(address)
                .customer(customer).build();
        orderRepo.save(order);

        // List with the order details for the new order
        List<OrderDetail> orderDetails = new ArrayList<>();

        // Create the order detail objects and save them
        for (OrderDetailDTO o : orderDetailDTOS) {

            // Find the location where the products are shipped from
            Location location = locationRepo.findById(o.getLocation().getId()).orElseThrow(RuntimeException::new);

            // Create the id for order detail
            OrderDetailId orderDetailId = OrderDetailId.builder().orderId(order.getId())
                    .productId(o.getProduct().getId())
                    .locationId(location.getId()).build();

            // Find the product object
            Product product = productRepo.findById(o.getProduct().getId()).orElseThrow(RuntimeException::new);

            // Create order detail
            OrderDetail orderDetail = OrderDetail.builder().orderDetailId(orderDetailId)
                    .order(order)
                    .product(product)
                    .location(location)
                    .quantity(o.getQuantity()).build();
            orderDetailRepo.save(orderDetail);
            orderDetails.add(orderDetail);
        }

        order.setOrderDetail(orderDetails);
        orderRepo.save(order);

        return order;
    }
}
