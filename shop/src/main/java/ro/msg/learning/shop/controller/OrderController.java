package ro.msg.learning.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.services.OrderServiceImpl;

@RestController
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;

    @PostMapping("/orders")
    public ResponseEntity<Object> createOrder(@RequestBody OrderDTO orderDTO) {
        orderService.createOrder(orderDTO);
        return new ResponseEntity<>("Order created successfully", HttpStatus.CREATED);
    }

}
