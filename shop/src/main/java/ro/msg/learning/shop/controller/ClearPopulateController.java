package ro.msg.learning.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.model.*;
import ro.msg.learning.shop.repository.*;

@Profile("test")
@RequestMapping("/test")
@RequiredArgsConstructor
@RestController
public class ClearPopulateController {

    private final CategoryRepo categoryRepo;
    private final SupplierRepo supplierRepo;
    private final ProductRepo productRepo;
    private final CustomerRepo customerRepo;
    private final AddressRepo addressRepo;
    private final LocationRepo locationRepo;
    private final StockRepo stockRepo;

    @DeleteMapping(value = "/clear")
    public ResponseEntity<Object> clearData() {
        stockRepo.deleteAll();
        locationRepo.deleteAll();
        addressRepo.deleteAll();
        customerRepo.deleteAll();
        productRepo.deleteAll();
        categoryRepo.deleteAll();
        supplierRepo.deleteAll();
        return new ResponseEntity<>("Data deleted successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/populate")
    public ResponseEntity<Object> populateData() {
        // Save categories
        Category category1 = Category.builder().name("Sweet").description("Sweet").build();
        categoryRepo.save(category1);
        Category category2 = Category.builder().name("Dairy products").description("Dairy products").build();
        categoryRepo.save(category2);

        // Save suppliers
        Supplier supplier1 = Supplier.builder().name("Lidl").build();
        supplierRepo.save(supplier1);

        // Save product
        Product product1 = Product.builder().name("Chocolate").category(category1).description("chocolate")
                .imageUrl("x").price(4.0).weight(100.0).supplier(supplier1).build();
        productRepo.save(product1);
        Product product2 = Product.builder().name("Milk").category(category1).description("Milk")
                .imageUrl("x").price(5.0).weight(1000.0).supplier(supplier1).build();
        productRepo.save(product2);

        // Save customer
        Customer customer1 = Customer.builder().firstName("Aline").lastName("Somcutean").username("alina").password("alina").build();
        customerRepo.save(customer1);

        // Save address
        Address address1 = Address.builder().country("Romania").county("Cluj").city("Cluj-Napoca").streetAddress("Aleea Herculane").build();
        addressRepo.save(address1);
        Address address2 = Address.builder().country("Romania").county("Maramures").city("Baia Mare").streetAddress("Bd. Traian").build();
        addressRepo.save(address2);

        // Save location
        Location location1 = Location.builder().name("Cluj").address(address1).build();
        locationRepo.save(location1);
        Location location2 = Location.builder().name("Baia Mare").address(address2).build();
        locationRepo.save(location2);

        // Save stock
        StockId stockId1 = StockId.builder().productId(product1.getId()).locationId(location1.getId()).build();
        Stock stock1 = Stock.builder().stockId(stockId1).product(product1).location(location1).quantity(10).build();
        stockRepo.save(stock1);
        StockId stockId2 = StockId.builder().productId(product1.getId()).locationId(location2.getId()).build();
        Stock stock2 = Stock.builder().stockId(stockId2).product(product1).location(location2).quantity(20).build();
        stockRepo.save(stock2);
        StockId stockId3 = StockId.builder().productId(product2.getId()).locationId(location1.getId()).build();
        Stock stock3 = Stock.builder().stockId(stockId3).product(product2).location(location1).quantity(20).build();
        stockRepo.save(stock3);
        StockId stockId4 = StockId.builder().productId(product2.getId()).locationId(location2.getId()).build();
        Stock stock4 = Stock.builder().stockId(stockId4).product(product2).location(location2).quantity(10).build();
        stockRepo.save(stock4);
        return new ResponseEntity<>("Data added successfully", HttpStatus.OK);
    }
}
