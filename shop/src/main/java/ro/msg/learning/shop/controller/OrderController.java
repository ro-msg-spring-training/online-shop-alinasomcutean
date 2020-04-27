package ro.msg.learning.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.OrderDetailDTO;
import ro.msg.learning.shop.model.Order;
import ro.msg.learning.shop.model.OrderDetail;
import ro.msg.learning.shop.services.OrderServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;

    @PostMapping("/orders")
    public List<OrderDetailDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        Order order = orderService.createOrder(orderDTO);
        List<OrderDetailDTO> orderDetailDTOS = new ArrayList<>();

        for(OrderDetail o : order.getOrderDetail()) {
            orderDetailDTOS.add(new OrderDetailDTO(o));
        }

        return orderDetailDTOS;
    }

}
