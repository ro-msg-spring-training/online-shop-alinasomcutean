package ro.msg.learning.shop.dto;

import lombok.*;
import ro.msg.learning.shop.model.Category;
import ro.msg.learning.shop.model.Product;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductCategoryDTO {

    private int id;

    private String name;

    private String description;

    private double price;

    private double weight;

    private String image_url;

    private String categoryName;

    private String categoryDescription;

    public ProductCategoryDTO(Product product, Category category) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.weight = product.getWeight();
        this.image_url = product.getImage_url();
        this.categoryName = category.getName();
        this.categoryDescription = category.getDescription();
    }
}
