package ro.msg.learning.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.ProductCategoryDTO;
import ro.msg.learning.shop.model.*;
import ro.msg.learning.shop.repository.CategoryRepo;
import ro.msg.learning.shop.repository.OrderDetailRepo;
import ro.msg.learning.shop.repository.ProductRepo;
import ro.msg.learning.shop.repository.StockRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepo productRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    StockRepo stockRepo;

    @Autowired
    OrderDetailRepo orderDetailRepo;

    @Override
    public List<ProductCategoryDTO> getAllProduct() {
        List<Product> products = productRepo.findAll();

        if(products == null) {
            return null;
        } else {
            List<ProductCategoryDTO> productCategoryDTOS = new ArrayList<ProductCategoryDTO>();
            for (int i = 0; i < products.size(); i++) {
                productCategoryDTOS.add(new ProductCategoryDTO(products.get(i), products.get(i).getCategory()));
            }

            return productCategoryDTOS;
        }
    }

    @Override
    public ProductCategoryDTO getProductById(int id) {
        Product product = productRepo.findById(id);
        return new ProductCategoryDTO(product, product.getCategory());
    }

    @Override
    public void createProduct(ProductCategoryDTO product) {
        Category category = categoryRepo.findByName(product.getCategoryName());
        System.out.println("1");
        // Create category if not exists
        if(category == null) {
            category = Category.builder().name(product.getCategoryName())
                    .description(product.getCategoryDescription()).build();
            categoryRepo.save(category);
        };

        //System.out.println(category.getName());

        Product newProduct = Product.builder().name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .weight(product.getWeight())
                .image_url(product.getImage_url())
                .category(category).build();
        productRepo.save(newProduct);

        List<Product> list = new ArrayList<Product>();
        list.add(newProduct);
        category.setProducts(list);
    }

    @Override
    public void updateProduct(int id, ProductCategoryDTO product) {

    }

    @Override
    public void deleteProduct(int id) {
        Product product = productRepo.findById(id);
        Category category = product.getCategory();
        Supplier supplier = product.getSupplier();
        /*List<OrderDetail> orderDetails = product.getOrderDetail();
        List<Stock> stocks = product.getStock();*/

        //categoryRepo.deleteByProductId(id);

        // Delete product from category
        System.out.println(category.getProducts().size());
        for(int i = 0; i < category.getProducts().size(); i++) {
            if(category.getProducts().get(i).getId() == id) {
                category.getProducts().remove(product);
            }
        }

        stockRepo.deleteByProductId(id);
        orderDetailRepo.deleteByProductId(id);
        // Delete product from db
        productRepo.deleteById(id);

        // Delete product from supplier
        /*for(int i = 0; i < supplier.getProducts().size(); i++) {
            if(supplier.getProducts().get(i).getId() == id) {
                supplier.getProducts().remove(product);
            }
        }*/

        // Delete product from order detail
        /*for(int i = 0; i < orderDetails.size(); i++) {
            if(orderDetails.get(i).getProduct().equals(product)) {
                orderDetails.remove(orderDetails.get(i).getProduct());
            }
        }*/

        //Delete product from stock
        /*for(int i = 0; i < stocks.size(); i++) {
            if(stocks.get(i).getProduct().equals(product)) {
                stocks.remove(stocks.get(i).getProduct());
            }
        }*/
    }
}
