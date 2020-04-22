package ro.msg.learning.shop.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "category", schema = "shop_schema")
public class Category implements IPrimaryKey{

    @Id
    private int id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
