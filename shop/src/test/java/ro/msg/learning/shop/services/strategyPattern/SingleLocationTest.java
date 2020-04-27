package ro.msg.learning.shop.services.strategyPattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.msg.learning.shop.dto.OrderDetailDTO;
import ro.msg.learning.shop.model.Address;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.repository.LocationRepo;
import ro.msg.learning.shop.repository.ProductRepo;
import ro.msg.learning.shop.repository.StockRepo;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.List;

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
    void chooseStrategy() {
        /*Address a1 = Address.builder().country()
                .county()
                .city()
                .streetAddress().build();
        Location l1 = Location.builder()..build();*/
        HashMap<Integer, Integer> orderedProducts = new HashMap<>();
        orderedProducts.put(1, 2);
        orderedProducts.put(2, 1);
        //List<OrderDetailDTO> orderDetailDTOS = singleLocation.chooseStrategy(orderedProducts);
    }
}