package com.onroad.simulation;


import com.onroad.backend.entity.Category;
import com.onroad.backend.entity.Product;
import com.onroad.backend.entity.Provider;
import com.onroad.backend.service.CategoryService;
import com.onroad.backend.service.ProductService;
import com.onroad.backend.service.ProviderService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ProductTest {

    public void testAll()
    {
        saveTest();
        updateTest();
        List<Category> categories = new ArrayList<>();
        categories.add((Category) generateCategory());
        Provider provider = generateProvider();
        Date date = new Date();
        Product p = generateProduct(categories, provider, date);

    }


    public void saveTest(){
        List<Product> produtos = new ArrayList<Product>();

        List<Category> categories = new ArrayList<>();
        categories.add((Category) generateCategory());

        Provider provider = generateProvider();

        Date date = new Date();

        produtos.add(generateProduct(categories, provider, date));

        for (Product product : produtos){
            new ProductService().save(product);
        }
    }

    public void updateTest(){
        List<Category> categories = new ArrayList<>();
        categories.add((Category) generateCategory());

        Provider provider = generateProvider();

        Date date = new Date();

        Product p = generateProduct(categories, provider, date);
        new ProductService().save(p);
    }

//    public Optional<Product> findTest(){
//        return new ProductService().find(01);
//    }

//    public List<Product> findAllTest(){
//        return productRepository.findAll();
//    }

    public static String toString(Product p){
        String txt = "";
        if (p != null){
            txt += "------------------";
            txt += "\nProduto";
            txt += "\nId: " + p.getId();
            txt += "\nNome: " + p.getName();
            txt += "\nDescrição: " + p.getDescription();

            if (p.getCategories() != null){
                txt += categoriesToString(p.getCategories());
            }

            txt += "\nValor: " + p.getFinalValue();
            txt += "\nQuantidade: " + p.getQtde();
            txt += "\n-------------\n";
        }
        return txt;
    }

    public static String allToString(List<Product> products){
        String txt = "";
        if (products != null && !products.isEmpty()){
            for (Product p : products){
                txt += toString(p);
            }
        }
        return txt;
    }

    public static String categoriesToString(List<Category> categories)
    {
        String txt = "\nCategorias:";
        if (categories != null && !categories.isEmpty())
        {
            for (Category category : categories)
            {
                txt = "\nNome: " + category.getName();
                txt = "\nDescrição: " + category.getDescription();
            }
        }

        return txt;
    }

    public Provider generateProvider()
    {
        Provider provider = new Provider("Monnari", "Monnari Jeans");
        try
        {
            new ProviderService().save(provider);
        } catch (Exception e)
        {
            System.out.println(e);
        }

        return provider;
    }

    public Category generateCategory()
    {
            Category category = new Category("Roupas", "Roupas com desconto");
            new CategoryService().save(category);
            return category;
    }

    public static Product generateProduct(List<Category> categories, Provider provider, Date date)
    {
        return new Product("Produto 1", 120.00f, 30.00f, "Produto de teste", 01, "red", "f", date, "summer", "P", "32", "1212", categories, provider);

    }

}
