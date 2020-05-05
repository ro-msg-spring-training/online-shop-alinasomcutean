package ro.msg.learning.shop.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ro.msg.learning.shop.repository.AddressRepo;
import ro.msg.learning.shop.repository.OrderRepo;

//@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
class OrderServiceImplTest {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    void createOrder() {
        /*HashMap<Integer, Integer> orderedProducts = new HashMap<>();
        orderedProducts.put(1, 2);
        orderedProducts.put(2, 2);

        OrderDTO orderDTO = OrderDTO.builder().country("Romania").county("Maramures").city("Baia Mare").streetAddress("street")
                .createdAt(new Date()).orderedProducts(orderedProducts).build();

        List<Address> addresses = addressRepo.findAll();
        List<Order> orders = orderRepo.findAll();

        Order order = orderService.createOrder(orderDTO);
        assertNotNull(order);
        assertEquals(2, order.getOrderDetail().size());
        assertEquals(addresses.size() + 1, addressRepo.findAll().size());
        assertEquals(orders.size() + 1, orderRepo.findAll().size());*/
    }

    @Test
    void missingStock() {
        /*HashMap<Integer, Integer> orderedProducts = new HashMap<>();
        orderedProducts.put(1, 2);
        orderedProducts.put(5, 20);

        OrderDTO orderDTO = OrderDTO.builder().country("Romania").county("Maramures").city("Baia Mare").streetAddress("street")
                .createdAt(new Date()).orderedProducts(orderedProducts).build();

        assertThrows(UnavailableStockException.class, () -> {orderService.createOrder(orderDTO);});*/
    }
}