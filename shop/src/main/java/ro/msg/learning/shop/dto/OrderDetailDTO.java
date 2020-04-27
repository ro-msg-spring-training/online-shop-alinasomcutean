package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.msg.learning.shop.model.OrderDetail;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderDetailDTO {

    private LocationDTO location;

    private ProductDTO product;

    private Integer quantity;

    public OrderDetailDTO(OrderDetail orderDetail) {
        this.location = new LocationDTO(orderDetail.getLocation());
        this.product = new ProductDTO(orderDetail.getProduct());
        this.quantity = orderDetail.getQuantity();
    }
}
