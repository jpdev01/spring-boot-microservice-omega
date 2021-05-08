package com.core.backend.service;

import com.core.backend.entity.Product;
import com.core.backend.entity.Sale;
import com.core.backend.entity.User;
import com.core.backend.repository.SaleRepository;
import com.core.backend.service.list.EntityList;
import com.core.backend.service.list.ListBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService implements ServiceInterface<Sale>{

    @Autowired
    private SaleRepository repository;

    @Autowired
    private ListBuilder listBuilder;

    @Override
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
    @Override
    public List<Sale> getAll()
    {
        return repository.findAll();
    }
    @Override
    public Page<Sale> getAll(Pageable pageable)
    {
        return repository.findAll(pageable);
    }
    @Override
    public Optional<Sale> get(Integer id)
    {
        return repository.findById(id);
    }

    public EntityList getList()
    {
        try {
            return listBuilder.build(Sale.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
