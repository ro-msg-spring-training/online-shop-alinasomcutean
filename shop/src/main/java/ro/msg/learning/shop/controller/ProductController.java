package ro.msg.learning.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductCategoryDto;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.services.ProductService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<ProductCategoryDto> getProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductCategoryDto> productCategoryDtos = new ArrayList<>();

        for (Product product : products) {
            productCategoryDtos.add(new ProductCategoryDto(product, product.getCategory()));
        }
        return productCategoryDtos;
    }

    @GetMapping("/products/{id}")
    public ProductCategoryDto getProduct(@PathVariable int id) {
        Product product = productService.getProduct(id);
        return new ProductCategoryDto(product, product.getCategory());
    }

    @PostMapping(value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createProduct(@RequestBody ProductCategoryDto productCategoryDTO) {
        productService.createProduct(productCategoryDTO);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable int id, @RequestBody ProductCategoryDto product) {
        productService.updateProduct(id, product);
        return new ResponseEntity<>("Product was updated successfully", HttpStatus.OK);
    }
}
