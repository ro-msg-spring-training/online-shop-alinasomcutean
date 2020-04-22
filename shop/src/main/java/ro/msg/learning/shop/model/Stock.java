package ro.msg.learning.shop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "stock", schema = "shop_schema")
public class Stock implements IPrimaryKey{

    @EmbeddedId
    private StockId stockId;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Location location;

    private int quantity;
}
