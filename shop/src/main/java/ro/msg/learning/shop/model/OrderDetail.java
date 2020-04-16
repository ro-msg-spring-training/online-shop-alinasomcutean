package ro.msg.learning.shop.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Builder
@Data
@Entity
public class OrderDetail implements IPrimaryKey {

    @EmbeddedId
    private OrderDetailId orderDetailId;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    private int quantity;
}
