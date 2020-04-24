package ro.msg.learning.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.OrderDetailDTO;
import ro.msg.learning.shop.exceptions.CustomerNotFoundException;
import ro.msg.learning.shop.exceptions.UnavailableStockException;
import ro.msg.learning.shop.model.*;
import ro.msg.learning.shop.repository.*;
import ro.msg.learning.shop.services.strategyPattern.Context;
import ro.msg.learning.shop.services.strategyPattern.SingleLocation;
import ro.msg.learning.shop.services.strategyPattern.Strategy;
import sun.util.locale.LocaleSyntaxException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Transactional
    @Override
    public Order createOrder(OrderDTO orderDTO) throws LocaleSyntaxException {
        Context context = new Context(new SingleLocation());

        List<OrderDetailDTO> orderDetailDTOS = context.executeStrategy(orderDTO.getOrderedProducts());

        // Create address object from the given input
        Address address = Address.builder().country(orderDTO.getCountry())
                .county(orderDTO.getCounty())
                .city(orderDTO.getCity())
                .streetAddress(orderDTO.getStreetAddress()).build();
        addressRepo.save(address);

        Customer customer = customerRepo.findByUsername("alina");
        if (customer == null) {
            throw new CustomerNotFoundException("There is no customer with this username");
        }

        //Location location = locationRepo.findById(1).orElseThrow(RuntimeException::new);
        Location location = locationRepo.findById(orderDetailDTOS.get(0).getLocation().getId()).orElseThrow(RuntimeException::new);

        // Create order object from the given input
        Order order = Order.builder().createdAt(new Date())
                .address(address)
                .customer(customer)
                .shippedFrom(location).build();
        orderRepo.save(order);

        // List with the valid order details
        List<OrderDetail> orderDetailList = new ArrayList<>();

        // Check if ordered products are in stock
        for (Map.Entry map : orderDTO.getOrderedProducts().entrySet()) {
            // Get each product
            Product product = productRepo.findById((Integer) map.getKey()).orElseThrow(RuntimeException::new);

            // Find product's available stock
            Stock stock = stockRepo.findByProductIdAndLocationId(product.getId(), location.getId());

            // If user tries to order a greater quantity that it is available, order cannot be save
            if (stock.getQuantity() < (Integer) map.getValue()) {
                orderRepo.deleteById(order.getId());
                throw new UnavailableStockException("Product " + (Integer) map.getKey() + " doesn't have in stock " + (Integer) map.getValue() + " items");
            } else { // Add the valid products in a list
                // Create the id for order detail
                OrderDetailId orderDetailId = OrderDetailId.builder().orderId(order.getId())
                        .productId(product.getId()).build();

                // Create the order detail
                OrderDetail orderDetail = OrderDetail.builder().orderDetailId(orderDetailId)
                        .order(order)
                        .product(product)
                        .quantity((Integer) map.getValue()).build();

                // Add it to the list
                orderDetailList.add(orderDetail);
            }
        }

        // If the order has all products in stock save it
        for (OrderDetail o : orderDetailList) {
            orderDetailRepo.save(o);
        }

        return order;
    }
}
