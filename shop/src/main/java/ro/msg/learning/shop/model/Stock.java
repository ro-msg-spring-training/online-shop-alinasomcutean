package ro.msg.learning.shop.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Builder
@Data
@Entity
public class Stock implements IPrimaryKey{

    @EmbeddedId
    private StockId stockId;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    private Location location;

    private int quantity;
}
