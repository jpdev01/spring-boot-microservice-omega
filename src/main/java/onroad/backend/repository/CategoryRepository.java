package onroad.backend.repository;

import onroad.backend.entity.Category;
import onroad.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
