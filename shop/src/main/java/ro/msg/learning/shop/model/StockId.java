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
public class StockId implements Serializable {

    @Column(name = "product_id")
    private int productId;

    @Column(name = "location_id")
    private int locationId;

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof StockId)) return false;
        StockId stockId = (StockId) o;
        return Objects.equals(getProductId(), stockId.getProductId()) &&
                Objects.equals(getLocationId(), stockId.getLocationId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getLocationId());
    }
}
