package ro.msg.learning.shop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ro.msg.learning.shop.services.ProductService;
import ro.msg.learning.shop.services.ProductServiceImpl;

@SpringBootTest
class ShopApplicationTests {

	@Autowired
	ProductServiceImpl productService;

	@Test
	void contextLoads() {
		productService.deleteProduct(1);
		assert true;
	}

}
