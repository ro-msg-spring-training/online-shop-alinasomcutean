package ro.msg.learning.shop.services.strategyPattern;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.msg.learning.shop.exceptions.LocationNotFoundException;
import ro.msg.learning.shop.exceptions.UnavailableStockException;
import ro.msg.learning.shop.model.Address;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.repository.LocationRepo;
import ro.msg.learning.shop.repository.ProductRepo;
import ro.msg.learning.shop.repository.StockRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SingleLocationTest {

    @Mock
    private LocationRepo locationRepo;
    @Mock
    private StockRepo stockRepo;
    @Mock
    private ProductRepo productRepo;

    @InjectMocks
    private SingleLocation singleLocation;

    @Test
    void passTest() {
        /*Address a1 = Address.builder().id(1).build();
        Address a2 = Address.builder().id(2).build();

        Product p1 = Product.builder().id(1).build();
        Product p2 = Product.builder().id(2).build();
        when(productRepo.findById(1)).thenReturn(java.util.Optional.ofNullable(p1));
        when(productRepo.findById(2)).thenReturn(java.util.Optional.ofNullable(p2));

        Stock s1 = Stock.builder().product(p1).quantity(10).build();
        Stock s2 = Stock.builder().product(p2).quantity(20).build();
        List<Stock> list1 = new ArrayList<>();
        list1.add(s1);
        list1.add(s2);
        List<Stock> list2 = new ArrayList<>();
        list2.add(s2);

        Location l1 = Location.builder().id(1).stock(list1).address(a1).build();
        Location l2 = Location.builder().id(2).stock(list2).address(a2).build();
        List<Location> locations = new ArrayList<>();
        locations.add(l1);
        locations.add(l2);
        when(locationRepo.findAll()).thenReturn(locations);

        Stock s11 = Stock.builder().product(p1).quantity(10).build();
        Stock s21 = Stock.builder().product(p2).quantity(20).build();
        when(stockRepo.findByProductIdAndLocationId(1, 1)).thenReturn(s11);
        when(stockRepo.findByProductIdAndLocationId(2, 1)).thenReturn(s21);

        // Create hash map with the order
        HashMap<Integer, Integer> orderedProducts = new HashMap<>();
        orderedProducts.put(1, 1);
        orderedProducts.put(2, 1);
        List<OrderDetail> orderDetailDTOS = singleLocation.chooseStrategy(orderedProducts);
        assertNotNull(orderDetailDTOS);
        assertEquals(9, s11.getQuantity());
        assertEquals(19, s21.getQuantity());*/
    }

    @Test()
    public void stockNotAvailable() {
        Address a1 = Address.builder().id(1).build();
        Address a2 = Address.builder().id(2).build();

        Product p1 = Product.builder().id(1).build();
        Product p2 = Product.builder().id(2).build();

        Stock s1 = Stock.builder().product(p1).quantity(10).build();
        Stock s2 = Stock.builder().product(p2).quantity(20).build();
        List<Stock> list1 = new ArrayList<>();
        list1.add(s1);
        list1.add(s2);
        List<Stock> list2 = new ArrayList<>();
        list2.add(s2);

        Location l1 = Location.builder().id(1).stock(list1).address(a1).build();
        Location l2 = Location.builder().id(2).stock(list2).address(a2).build();
        List<Location> locations = new ArrayList<>();
        locations.add(l1);
        locations.add(l2);
        when(locationRepo.findAll()).thenReturn(locations);

        Stock s11 = Stock.builder().product(p1).quantity(10).build();
        Stock s21 = Stock.builder().product(p2).quantity(20).build();
        when(stockRepo.findByProductIdAndLocationId(1, 1)).thenReturn(s11);

        HashMap<Integer, Integer> orderedProducts = new HashMap<>();
        orderedProducts.put(1, 15);
        orderedProducts.put(2, 1);
        assertThrows(UnavailableStockException.class, () -> {singleLocation.chooseStrategy(orderedProducts);});
    }

    @Test()
    public void locationNotFound() {
        Address a1 = Address.builder().id(1).build();
        Address a2 = Address.builder().id(2).build();

        Product p1 = Product.builder().id(1).build();
        Product p2 = Product.builder().id(2).build();
        when(productRepo.findById(1)).thenReturn(java.util.Optional.ofNullable(p1));

        Stock s1 = Stock.builder().product(p1).quantity(10).build();
        Stock s2 = Stock.builder().product(p2).quantity(20).build();
        List<Stock> list1 = new ArrayList<>();
        list1.add(s1);
        List<Stock> list2 = new ArrayList<>();
        list2.add(s2);

        Location l1 = Location.builder().id(1).stock(list1).address(a1).build();
        Location l2 = Location.builder().id(2).stock(list2).address(a2).build();
        List<Location> locations = new ArrayList<>();
        locations.add(l1);
        locations.add(l2);
        when(locationRepo.findAll()).thenReturn(locations);

        Stock s11 = Stock.builder().product(p1).quantity(10).build();
        Stock s21 = Stock.builder().product(p2).quantity(20).build();
        when(stockRepo.findByProductIdAndLocationId(1, 1)).thenReturn(s11);

        HashMap<Integer, Integer> orderedProducts = new HashMap<>();
        orderedProducts.put(1, 1);
        orderedProducts.put(2, 1);
        assertThrows(LocationNotFoundException.class, () -> {singleLocation.chooseStrategy(orderedProducts);});
    }
}