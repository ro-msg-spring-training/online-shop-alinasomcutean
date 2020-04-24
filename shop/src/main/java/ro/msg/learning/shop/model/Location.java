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

    @OneToMany(mappedBy = "shippedFrom")
    private List<Order> order;

    @OneToMany(mappedBy = "location")
    private List<Revenue> revenue;
}
