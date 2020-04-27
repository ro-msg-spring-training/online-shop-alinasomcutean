package ro.msg.learning.shop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "order_detail", schema = "shop_schema")
public class OrderDetail {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private OrderDetailId orderDetailId;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Location location;

    private Integer quantity;
}
