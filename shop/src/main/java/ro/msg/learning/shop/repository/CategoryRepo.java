package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.msg.learning.shop.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

    Category findByName(String name);
}
