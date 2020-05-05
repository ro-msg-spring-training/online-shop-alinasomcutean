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
@Table(name = "supplier", schema = "shop_schema")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "supplier")
    @ToString.Exclude
    private List<Product> products;
}
