package ro.msg.learning.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("ro.msg.learning.data_access.repositories")
@EntityScan(basePackages = {"ro.msg.learning.entities"})
@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

}
