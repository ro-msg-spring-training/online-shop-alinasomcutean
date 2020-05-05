package ro.msg.learning.shop.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "orders", schema = "shop_schema")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Location shippedFrom;

    @ManyToOne
    private Customer customer;

    private Date createdAt;

    @OneToOne(cascade = {CascadeType.ALL})
    private Address address;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetail = new ArrayList<>();
}
