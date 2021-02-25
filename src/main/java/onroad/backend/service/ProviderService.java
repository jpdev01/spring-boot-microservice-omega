package onroad.backend.service;

import onroad.backend.entity.Product;
import onroad.backend.entity.Provider;
import onroad.backend.repository.ProductRepository;
import onroad.backend.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {
    @Autowired
    ProviderRepository productRepository;
    public ProviderService(){}

    public void save(Provider provider)
    {
        if (provider != null) {
            try
            {
                productRepository.save(provider);
            }
            catch (Exception e)
            {
                System.err.println("erro ao salvar novo produto!");
            }
        }
    }
}
