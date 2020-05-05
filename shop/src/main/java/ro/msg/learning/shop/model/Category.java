package ro.msg.learning.shop.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "category", schema = "shop_schema")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "category")
    @Builder.Default
    @ToString.Exclude
    private List<Product> products = new ArrayList<>();
}
