package ro.msg.learning.shop.model;

import lombok.*;

import javax.persistence.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "stock", schema = "shop_schema")
public class Stock {

    @EmbeddedId
    private StockId stockId;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ToString.Exclude
    private Product product;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ToString.Exclude
    private Location location;

    private Integer quantity;
}
