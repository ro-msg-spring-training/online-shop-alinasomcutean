package ro.msg.learning.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.ProductCategoryDto;
import ro.msg.learning.shop.model.Category;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.Supplier;
import ro.msg.learning.shop.repository.CategoryRepo;
import ro.msg.learning.shop.repository.OrderDetailRepo;
import ro.msg.learning.shop.repository.ProductRepo;
import ro.msg.learning.shop.repository.StockRepo;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;
    private final StockRepo stockRepo;
    private final OrderDetailRepo orderDetailRepo;

    @Override
    public List<Product> getAllProducts() {
        return  productRepo.findAll();
    }

    @Override
    public Product getProduct(Integer id) {
        return productRepo.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional
    @Override
    public Product createProduct(ProductCategoryDto product) {
        Category category = categoryRepo.findByName(product.getCategoryName());

        // Create category if not exists
        if (category == null) {
            category = Category.builder().name(product.getCategoryName())
                    .description(product.getCategoryDescription()).build();
            categoryRepo.save(category);
        }

        // Create a new product
        Product newProduct = Product.builder().name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .weight(product.getWeight())
                .imageUrl(product.getImageUrl())
                .category(category).build();
        productRepo.save(newProduct);

        return newProduct;
    }

    @Transactional
    @Override
    public Product updateProduct(Integer id, ProductCategoryDto product) {
        // Find the existing product with the same id
        Product prod = productRepo.findById(id).orElseThrow(RuntimeException::new);
        Category category = prod.getCategory();

        // Update data from product
        prod.setName(product.getName());
        prod.setDescription(product.getDescription());
        prod.setPrice(product.getPrice());
        prod.setWeight(product.getWeight());
        prod.setImageUrl(product.getImageUrl());

        // Update data for category
        category.setName(product.getCategoryName());
        category.setDescription(product.getCategoryDescription());

        // Save the new data
        categoryRepo.save(category);
        productRepo.save(prod);

        return prod;
    }

    @Transactional
    @Override
    public void deleteProduct(Integer id) {
        Product product = productRepo.findById(id).orElseThrow(RuntimeException::new);
        Category category = product.getCategory();
        Supplier supplier = product.getSupplier();

        // Delete product from category
        for (int i = 0; i < category.getProducts().size(); i++) {
            if (category.getProducts().get(i).getId().equals(id)) {
                category.getProducts().remove(product);
            }
        }

        // Delete product from supplier
        for (int i = 0; i < supplier.getProducts().size(); i++) {
            if (supplier.getProducts().get(i).getId().equals(id)) {
                supplier.getProducts().remove(product);
            }
        }

        // Delete product from stock
        stockRepo.deleteByProductId(id);

        // Delete product from order detail
        orderDetailRepo.deleteByProductId(id);

        // Delete product from db
        productRepo.deleteById(id);
    }
}
