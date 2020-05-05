package ro.msg.learning.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.dto.LocationDto;
import ro.msg.learning.shop.dto.OrderDto;
import ro.msg.learning.shop.dto.OrderDetailDto;
import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.model.Address;
import ro.msg.learning.shop.model.Order;
import ro.msg.learning.shop.model.OrderDetail;
import ro.msg.learning.shop.services.OrderServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderServiceImpl orderService;

    @PostMapping("/orders")
    public List<OrderDetailDto> createOrder(@RequestBody OrderDto orderDTO) {
        Address address = new Address(orderDTO.getCountry(), orderDTO.getCounty(), orderDTO.getCity(), orderDTO.getStreetAddress());
        List<Order> order = orderService.createOrder(address, orderDTO.getOrderedProducts());

        List<OrderDetailDto> orderDetailDtos = new ArrayList<>();

        for(Order o : order) {
            List<OrderDetail> orderDetails = o.getOrderDetail();
            LocationDto locationDTO = new LocationDto(o.getShippedFrom());
            for(OrderDetail orderDetail : orderDetails) {
                ProductDto productDTO = new ProductDto((orderDetail.getProduct()));
                OrderDetailDto orderDetailDTO = new OrderDetailDto(locationDTO, productDTO, orderDetail.getQuantity());
                orderDetailDtos.add(orderDetailDTO);
            }
        }

        return orderDetailDtos;
    }

}
