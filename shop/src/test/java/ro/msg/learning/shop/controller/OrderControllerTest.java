package ro.msg.learning.shop.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ro.msg.learning.shop.dto.OrderDto;
import ro.msg.learning.shop.dto.OrderDetailDto;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
class OrderControllerTest {

    @Autowired
    private OrderController orderController;

    @Test
    void createOrder() {
        HashMap<Integer, Integer> orderedProducts = new HashMap<>();
        orderedProducts.put(1, 2);
        orderedProducts.put(2, 2);

        OrderDto orderDTO = OrderDto.builder().country("Romania").county("Maramures").city("Baia Mare").streetAddress("street")
                .createdAt(new Date()).orderedProducts(orderedProducts).build();

        List<OrderDetailDto> orderDetailDtos = orderController.createOrder(orderDTO);
        for (OrderDetailDto orderDetailDTO : orderDetailDtos) {
            System.out.println(orderDetailDTO.getProduct().getName());
        }
        assertNotNull(orderDetailDtos);
        assertEquals(2, orderDetailDtos.size());
    }
}