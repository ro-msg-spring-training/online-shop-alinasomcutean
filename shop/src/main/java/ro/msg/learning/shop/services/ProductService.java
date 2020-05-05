package ro.msg.learning.shop.services;

import ro.msg.learning.shop.dto.ProductCategoryDto;
import ro.msg.learning.shop.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProduct(Integer id);

    Product createProduct(ProductCategoryDto product);

    Product updateProduct(Integer id, ProductCategoryDto product);

    void deleteProduct(Integer id);
}
