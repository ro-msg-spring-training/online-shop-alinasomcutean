package ro.msg.learning.shop.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@RequiredArgsConstructor
@Getter
@Embeddable
public class OrderDetailId implements Serializable {

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "product_id")
    private int productId;

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof OrderDetailId)) return false;
        OrderDetailId orderDetailId = (OrderDetailId) o;
        return Objects.equals(getOrderId(), orderDetailId.getOrderId()) &&
                Objects.equals(getProductId(), orderDetailId.getProductId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getOrderId());
    }
}
