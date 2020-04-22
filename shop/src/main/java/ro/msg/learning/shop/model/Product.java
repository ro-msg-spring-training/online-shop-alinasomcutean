package ro.msg.learning.shop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "product", schema = "shop_schema")
public class Product implements IPrimaryKey{

    @Id
    private int id;

    private String name;

    private String description;

    private double price;

    private double weight;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Supplier supplier;

    private String image_url;

    @OneToMany(mappedBy = "product")
    private List<Stock> stock;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetail;
}
