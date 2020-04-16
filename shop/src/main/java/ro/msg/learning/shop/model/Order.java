package ro.msg.learning.shop.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Builder
@Data
@Entity
public class Order implements IPrimaryKey{

    @Id
    private int id;

    @ManyToOne
    private Location shippedFrom;

    @ManyToOne
    private Customer customer;

    private Date createdAt;

    private Address address;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetail;
}
