package ro.msg.learning.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductCategoryDTO;
import ro.msg.learning.shop.services.ProductService;

import java.util.List;

@RestController
public class ProductServiceController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<ProductCategoryDTO> getProducts() {
        return productService.getAllProduct();
    }

    @GetMapping("/products/{id}")
    public ProductCategoryDTO getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping(value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createProduct(@RequestBody ProductCategoryDTO productCategoryDTO) {
        productService.createProduct(productCategoryDTO);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }
}
