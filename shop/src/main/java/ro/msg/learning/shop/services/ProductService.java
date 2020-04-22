package ro.msg.learning.shop.services;

import ro.msg.learning.shop.dto.ProductCategoryDTO;
import ro.msg.learning.shop.model.Product;

import java.util.List;

public interface ProductService {

    List<ProductCategoryDTO> getAllProduct();
    ProductCategoryDTO getProductById(int id);
    void createProduct(ProductCategoryDTO product);
    void updateProduct(int id, ProductCategoryDTO product);
    void deleteProduct(int id);
}
