package onroad.backend.repository;

import onroad.backend.entity.Cashier;
import onroad.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashierRepository extends JpaRepository<Cashier, Integer> {
}
