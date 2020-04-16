package ro.msg.learning.shop.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Builder
@Data
@Entity
public class Category implements IPrimaryKey{

    @Id
    private int id;

    private String name;

    private String description;

    @OneToMany
    private List<Product> products;
}
