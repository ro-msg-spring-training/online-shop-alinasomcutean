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
@Table(name = "customer", schema = "shop_schema")
public class Customer implements IPrimaryKey{

    @Id
    private int id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    @OneToMany
    private List<Order> orders;
}
