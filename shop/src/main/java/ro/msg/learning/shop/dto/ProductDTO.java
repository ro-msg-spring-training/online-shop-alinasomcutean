package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.msg.learning.shop.model.Product;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductDTO {

    private Integer id;

    private String name;

    private String description;

    private Double price;

    private Double weight;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.weight = product.getWeight();
    }
}
