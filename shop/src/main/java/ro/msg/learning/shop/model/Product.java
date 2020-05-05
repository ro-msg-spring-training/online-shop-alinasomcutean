package ro.msg.learning.shop.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "product", schema = "shop_schema")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private Double price;

    private Double weight;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Supplier supplier;

    private String imageUrl;

    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    private List<Stock> stock;

    @OneToMany(mappedBy = "order")
    @ToString.Exclude
    private List<OrderDetail> orderDetail;
}
