package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.model.StockId;

import java.util.List;

@Repository
public interface StockRepo extends JpaRepository<Stock, StockId> {

    void deleteByProductId(Integer id);

    Stock findByProductIdAndLocationId(Integer productId, Integer locationId);

    List<Stock> findByProductId(Integer productId);

    List<Stock> findByProductIdOrderByQuantityDesc(Integer productId);
}
