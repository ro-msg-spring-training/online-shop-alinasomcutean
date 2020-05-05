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
import ro.msg.learning.shop.repository.StockRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MostAbundantTest {

    @Mock
    private StockRepo stockRepo;

    @InjectMocks
    private MostAbundant mostAbundant;

    @Test
    void passTest() {
        /*Product p1 = Product.builder().id(1).build();
        Product p2 = Product.builder().id(2).build();

        Address a1 = Address.builder().id(1).build();
        Address a2 = Address.builder().id(2).build();

        Location l1 = Location.builder().id(1).address(a1).build();
        Location l2 = Location.builder().id(2).address(a2).build();

        Stock s1 = Stock.builder().product(p1).location(l2).quantity(20).build();
        Stock s2 = Stock.builder().product(p2).location(l1).quantity(10).build();
        List<Stock> list1 = new ArrayList<>();
        list1.add(s1);
        List<Stock> list2 = new ArrayList<>();
        list2.add(s2);
        when(stockRepo.findByProductIdOrderByQuantityDesc(1)).thenReturn(list1);
        when(stockRepo.findByProductIdOrderByQuantityDesc(2)).thenReturn(list2);
        when(stockRepo.findByProductIdAndLocationId(1, 2)).thenReturn(s1);
        when(stockRepo.findByProductIdAndLocationId(2, 1)).thenReturn(s2);

        HashMap<Integer, Integer> orderedProducts = new HashMap<>();
        orderedProducts.put(1, 1);
        orderedProducts.put(2, 1);
        List<OrderDetail> orderDetailDTOS = mostAbundant.chooseStrategy(orderedProducts);
        assertNotNull(orderDetailDTOS);
        assertEquals(19, s1.getQuantity());
        assertEquals(9, s2.getQuantity());*/
    }

    @Test()
    public void stockNotAvailable() {
        Product p1 = Product.builder().id(1).build();
        Product p2 = Product.builder().id(2).build();

        Address a1 = Address.builder().id(1).build();
        Address a2 = Address.builder().id(2).build();

        Location l1 = Location.builder().id(1).address(a1).build();
        Location l2 = Location.builder().id(2).address(a2).build();

        Stock s1 = Stock.builder().product(p1).location(l2).quantity(20).build();
        Stock s2 = Stock.builder().product(p2).location(l1).quantity(10).build();
        Stock s3 = Stock.builder().product(p2).location(l2).quantity(8).build();
        List<Stock> list1 = new ArrayList<>();
        list1.add(s1);
        List<Stock> list2 = new ArrayList<>();
        list2.add(s2);
        list2.add(s3);
        when(stockRepo.findByProductIdOrderByQuantityDesc(1)).thenReturn(list1);
        when(stockRepo.findByProductIdOrderByQuantityDesc(2)).thenReturn(list2);

        HashMap<Integer, Integer> orderedProducts = new HashMap<>();
        orderedProducts.put(1, 1);
        orderedProducts.put(2, 12);
        assertThrows(UnavailableStockException.class, () -> {mostAbundant.chooseStrategy(orderedProducts);});
    }

    @Test()
    public void locationNotFound() {
        Product p1 = Product.builder().id(1).build();
        Product p2 = Product.builder().id(2).build();

        Address a1 = Address.builder().id(1).build();
        Address a2 = Address.builder().id(2).build();

        Location l1 = Location.builder().id(1).address(a1).build();
        Location l2 = Location.builder().id(2).address(a2).build();

        Stock s2 = Stock.builder().product(p2).location(l1).quantity(10).build();
        Stock s3 = Stock.builder().product(p2).location(l2).quantity(8).build();
        List<Stock> list1 = new ArrayList<>();
        List<Stock> list2 = new ArrayList<>();
        list2.add(s2);
        list2.add(s3);
        when(stockRepo.findByProductIdOrderByQuantityDesc(1)).thenReturn(null);

        HashMap<Integer, Integer> orderedProducts = new HashMap<>();
        orderedProducts.put(1, 1);
        orderedProducts.put(2, 2);
        assertThrows(LocationNotFoundException.class, () -> {mostAbundant.chooseStrategy(orderedProducts);});
    }
}