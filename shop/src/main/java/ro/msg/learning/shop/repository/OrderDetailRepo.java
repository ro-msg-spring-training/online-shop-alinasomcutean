package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.msg.learning.shop.model.OrderDetail;
import ro.msg.learning.shop.model.OrderDetailId;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail, OrderDetailId> {

    void deleteByProductId(Integer id);
}
