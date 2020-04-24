package ro.msg.learning.shop.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@Embeddable
public class OrderDetailId implements Serializable {

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "product_id")
    private Integer productId;
}
