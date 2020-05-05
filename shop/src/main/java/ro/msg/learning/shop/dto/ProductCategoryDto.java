package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.msg.learning.shop.model.Category;
import ro.msg.learning.shop.model.Product;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductCategoryDto {

    private Integer id;

    private String name;

    private String description;

    private Double price;

    private Double weight;

    private String imageUrl;

    private String categoryName;

    private String categoryDescription;

    public ProductCategoryDto(Product product, Category category) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.weight = product.getWeight();
        this.imageUrl = product.getImageUrl();
        this.categoryName = category.getName();
        this.categoryDescription = category.getDescription();
    }
}
