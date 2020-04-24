package ro.msg.learning.shop.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@RequiredArgsConstructor
@Getter
@Embeddable
public class StockId implements Serializable {

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "location_id")
    private Integer locationId;
}
