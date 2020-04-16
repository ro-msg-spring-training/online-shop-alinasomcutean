package ro.msg.learning.shop.model;

import lombok.Builder;
import lombok.Data;
import org.aspectj.weaver.ast.Or;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Builder
@Data
@Entity
public class Location implements IPrimaryKey{

    @Id
    private int id;

    private String name;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "location")
    private List<Stock> stock;

    @OneToMany
    private List<Order> order;

    @OneToMany
    private List<Revenue> revenue;
}
