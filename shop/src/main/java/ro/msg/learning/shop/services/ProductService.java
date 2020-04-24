package ro.msg.learning.shop.services;

import ro.msg.learning.shop.dto.ProductCategoryDTO;
import ro.msg.learning.shop.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProduct(Integer id);

    Product createProduct(ProductCategoryDTO product);

    Product updateProduct(Integer id, ProductCategoryDTO product);

    void deleteProduct(Integer id);
}
