package ro.msg.learning.shop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "location", schema = "shop_schema")
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
