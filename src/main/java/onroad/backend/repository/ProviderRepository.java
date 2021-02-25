package onroad.backend.repository;

import onroad.backend.entity.Product;
import onroad.backend.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Integer> {
}
