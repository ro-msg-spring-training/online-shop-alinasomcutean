package ro.msg.learning.shop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "order", schema = "shop_schema")
public class Order implements IPrimaryKey{

    @Id
    private int id;

    @ManyToOne
    private Location shippedFrom;

    @ManyToOne
    private Customer customer;

    private Date createdAt;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetail;
}
