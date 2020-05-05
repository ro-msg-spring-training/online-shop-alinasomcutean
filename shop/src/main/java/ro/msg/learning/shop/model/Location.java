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
@Table(name = "location", schema = "shop_schema")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "location")
    private List<Stock> stock;

    @OneToMany(mappedBy = "location")
    private List<Revenue> revenue;

    @OneToMany(mappedBy = "shippedFrom")
    private List<Order> orders;
}
