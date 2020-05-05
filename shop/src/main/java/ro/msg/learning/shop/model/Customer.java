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
@Table(name = "customer", schema = "shop_schema")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
