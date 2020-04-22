package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.model.StockId;

@Repository
public interface StockRepo extends JpaRepository<Stock, StockId> {

    Stock findByProduct(Product product);
    void deleteByProductId(int id);
}
