package com.onroad.backend.service;

import com.onroad.backend.entity.Product;
import com.onroad.backend.entity.Provider;
import com.onroad.backend.entity.Sale;
import com.onroad.backend.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public void save(Sale sale)
    {
        List<Product> products = sale.getProducts();
        Float finalValue = sale.getTotalValue() != null ? sale.getTotalValue() : 0;
        for (Product product: products)
        {
            Integer qtde = product.getQtde();
            if (qtde > 0)
            {
                product.setQtde(qtde);
                finalValue = finalValue + product.getFinalValue();
            }
            else
            {
                System.err.println("Produto não está disponível");
            }
        }
        if (finalValue != sale.getTotalValue())
        {
            sale.setTotalValue(finalValue);
        }
        repository.save(sale);
    }

    public List<Sale> findAll()
    {
        return repository.findAll();
    }

    public Page<Sale> findAll(Pageable pageable)
    {
        return repository.findAll(pageable);
    }

    public Optional<Sale> findById(Integer id)
    {
        return repository.findById(id);
    }

}
