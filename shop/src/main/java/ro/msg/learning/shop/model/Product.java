package ro.msg.learning.shop.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@Entity
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

    private String imageURL;

    @OneToMany(mappedBy = "product")
    private List<Stock> stock;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetail;
}
